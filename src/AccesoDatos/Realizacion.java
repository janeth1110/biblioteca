/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Logica.Prestamo;
import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Delmy Janeth
 */
public class Realizacion {

    private conexion con = new conexion();

    public boolean agregarPrestamo(int idEjemplar, int idLector, Date fechaPrestamo, Date fechaDevolucion, String devolucion, String tipo) {

        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO biblioteca.prestamo (idejemplar, id_lector, fecha_prestamo, fecha_devolucion, devolucion, tipo_prestamo) values (?,?,?,?,?,?)");
            stmt1.setInt(1, idEjemplar);
            stmt1.setInt(2, idLector);
            stmt1.setDate(3, fechaPrestamo);
            stmt1.setDate(4, fechaDevolucion);
            stmt1.setString(5, devolucion);
            stmt1.setString(6, tipo);
            rows_updated=stmt1.executeUpdate();
//            JOptionPane.showMessageDialog(null, rows_updated);
            con.desconectar();

            if (rows_updated == 1) {
                JOptionPane.showMessageDialog(null, "Prestamo generado exitosamente!!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el prestamo, favor verifique los datos");
                return false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            return false;
        }
    }
    
    public String obtenerEstadoDisponibilidad(int id) {
        String estado = "";
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.estado WHERE idEstado = "+id);
            resultado.last();
            
            estado = resultado.getString("Estado");
            con.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
//            con.desconectar();
        }
        return estado;
    }
    
    public boolean actualizarDisponibilidadEjemplar(int idEjmplar) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("UPDATE biblioteca.ejemplar SET Estado_idEstado = ? WHERE idejemplar=" + idEjmplar);
            stmt1.setInt(1, 2);

            rows_updated = stmt1.executeUpdate();
            if (rows_updated == 1) {
                JOptionPane.showMessageDialog(null, "Actualizacion realizada!");
                con.desconectar();
                return true;
            } else {
                con.desconectar();
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Errorts: " + e.getMessage());
            return false;
        }
    }
    
    public List<Prestamo> mostrarPrestamos() {
        List<Prestamo> listaPrestamo = new ArrayList<Prestamo>();
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.prestamo WHERE devolucion = 'pendiente'");
            resultado.last();
            if (resultado.getRow() <= 0) {
                listaPrestamo.clear();
                return listaPrestamo;
            } else {
                resultado.beforeFirst();
                while (resultado.next()) {
                    int idEjemplar = (Integer) resultado.getObject("idejemplar");
                    int idLector = (Integer) resultado.getObject("id_lector");
                    Date prestamo = resultado.getDate("fecha_prestamo");
                    Date devolucion = resultado.getDate("fecha_devolucion");
                    String estado = resultado.getObject("devolucion").toString();
                    String tipo = resultado.getObject("tipo_prestamo").toString();
                    Prestamo li = new Prestamo(idEjemplar, idLector, prestamo, devolucion, estado, tipo);
                    listaPrestamo.add(li);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        con.desconectar();
        return listaPrestamo;
    }
    

}
