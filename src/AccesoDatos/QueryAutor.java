/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Logica.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author delmy
 */
public class QueryAutor {

    private conexion con = new conexion();
    public Autor autor = new Autor();

    public boolean agregarAutor(String nombre, String apellido) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO biblioteca.autor (nombre,apellido) VALUES(?,?)");
            stmt1.setString(1, nombre);
            stmt1.setString(2, apellido);
            rows_updated = stmt1.executeUpdate();

            if (rows_updated == 1) {
                //JOptionPane.showMessageDialog(null, "Autor agregado correctamente!");
                con.desconectar();
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "No se pudo agregar Autor");
                con.desconectar();
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error detectado:\n"+ ex.getMessage(),"Ha ocurrido un error",JOptionPane.ERROR_MESSAGE);
            con.desconectar();
            return false;
        }
    }

    public Autor obtenerAutor(int id) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.autor WHERE idautor=" + id);

            resultado.beforeFirst();
            resultado.last();

            autor.setNombre(resultado.getString("nombre"));
            autor.setApellido(resultado.getString("apellido"));
            
            con.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            con.desconectar();
        }
        return autor;
    }

    public List<Autor> mostrarAutor() {
        List<Autor> listaAutor = new ArrayList<Autor>();
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.autor");
            resultado.last();
            if (resultado.getRow() <= 0) {
                listaAutor.clear();
                return listaAutor;
            } else {
                resultado.beforeFirst();
                while (resultado.next()) {
                    int id = (Integer) resultado.getObject("idautor");
                    String nombre = resultado.getObject("nombre").toString();
                    String direccion = resultado.getObject("apellido").toString();
                    Autor au = new Autor(id, nombre, direccion);
                    listaAutor.add(au);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        con.desconectar();
        return listaAutor;
    }

    public boolean modificarAutor(int id, String nombre, String apellido) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("UPDATE biblioteca.autor SET nombre =?, apellido = ? WHERE (idautor = " + id + ")");
            stmt1.setString(1, nombre);
            stmt1.setString(2, apellido);

            rows_updated = stmt1.executeUpdate();
            if (rows_updated == 1) {
                //JOptionPane.showMessageDialog(null, "Actualizacion realizada!");
                con.desconectar();
                return true;
            } else {
                con.desconectar();
                return false;
            }
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            return false;
        }
    }

    public Boolean eliminarAutor(int id) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("DELETE from biblioteca.autor where idautor= " + id);
            rows_updated = stmt1.executeUpdate();
            if (rows_updated == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public List<Autor> buscarAutor(String n) {
        List<Autor> listaAutor = new ArrayList<Autor>();
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.autor WHERE nombre LIKE '" + n + "%'");
            resultado.last();
            if (resultado.getRow() <= 0) {
                listaAutor.clear();
                return listaAutor;
            } else {
                resultado.beforeFirst();
                while (resultado.next()) {
                    int id = (Integer) resultado.getObject("idautor");
//                    JOptionPane.showMessageDialog(null, id);
                    String nombre = resultado.getObject("nombre").toString();
                    String direccion = resultado.getObject("apellido").toString();
                    Autor au = new Autor(id, nombre, direccion);
                    listaAutor.add(au);
//                    JOptionPane.showMessageDialog(null, au.getNombre().toString());
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        con.desconectar();
        return listaAutor;
    }

    //Para llenar comboBox de Autor
    public ArrayList<Autor> obtenerAutor() {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.autor ORDER BY nombre asc");

            ArrayList<Autor> auto = new ArrayList<Autor>();

            if (resultado.next()) {
                do {
                    Autor autorTemporal = new Autor(resultado.getInt(1), resultado.getString(2), resultado.getString(3));
                    auto.add(autorTemporal);
                } while (resultado.next());
                return auto;
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public int obtenerIdAutor(String h) {
        int auto=0;
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.autor WHERE nombre ='"+h+"'");
            
            resultado.beforeFirst();
            resultado.last();
            
            auto = resultado.getInt("idautor");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        con.desconectar();
        return auto;
    }

}
