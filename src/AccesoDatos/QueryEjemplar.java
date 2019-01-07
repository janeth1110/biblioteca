/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Logica.Ejemplar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author delmy
 */
public class QueryEjemplar {

    private conexion con = new conexion();
    public Ejemplar ejemplar = new Ejemplar();

    public boolean agregarEjemplar(int idLibro, int numeroEjemplar, String ubicacion, int estado) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO biblioteca.ejemplar (idlibro, numero_ejemplar, ubicacion, Estado_idEstado) VALUES (?,?,?,?)");
            stmt1.setInt(1, idLibro);
            stmt1.setInt(2, numeroEjemplar);
            stmt1.setString(3, ubicacion);
            stmt1.setInt(4, estado);
            rows_updated = stmt1.executeUpdate();

            if (rows_updated == 1) {
                //JOptionPane.showMessageDialog(null, "Ejemplar agregado exitosamente");
                con.desconectar();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar ejemplar");
                con.desconectar();
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            con.desconectar();
            return false;
        }
    }

    //obtiene ejemplar a partir del id de libro
    public Ejemplar obtenerEjemplar(int id) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.ejemplar WHERE idlibro =" + id);

            resultado.beforeFirst();
            resultado.last();

            ejemplar.setIdEjemplar(resultado.getInt("idEjemplar"));
            ejemplar.setNumEjemplar(resultado.getInt("numero_ejemplar"));
            ejemplar.setUbicacion(resultado.getString("ubicacion"));
            ejemplar.setIdEstado(resultado.getInt("Estado_idEstado"));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Este libro no contiene ejemplares registrados. " + e.getMessage());
        }
        con.desconectar();
        return ejemplar;
    }

    public List<Ejemplar> mostrarEjemplar(int idLi) {
        List<Ejemplar> listaEjemplar = new ArrayList<Ejemplar>();
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.ejemplar WHERE idlibro =" + idLi);
            resultado.last();
            if (resultado.getRow() <= 0) {
                listaEjemplar.clear();
                return listaEjemplar;
            } else {
                resultado.beforeFirst();
                while (resultado.next()) {
                    int idLibro = (Integer) resultado.getObject("idLibro");
                    int idEjemplar = (Integer) resultado.getObject("idEjemplar");
                    int numEjemplar = (Integer) resultado.getObject("numero_ejemplar");
                    String ubicacion = resultado.getString("ubicacion");
                    int idEstado = (Integer) resultado.getInt("Estado_idEstado");
                    Ejemplar eje = new Ejemplar(idLibro, idEjemplar, numEjemplar, ubicacion, idEstado);
                    listaEjemplar.add(eje);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        con.desconectar();
        return listaEjemplar;
    }

    //obtener id de libro a partir del id de ejemplar
    public int obtenerIdLibroAPartirDeEjemplar(int id) {
        int x = 0;
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT idlibro FROM ejemplar WHERE idejemplar=" + id);

            resultado.beforeFirst();
            resultado.last();

            x = resultado.getInt("idlibro");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        con.desconectar();
        return x;
    }

}
