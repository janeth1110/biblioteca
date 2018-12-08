/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Logica.Editorial;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author delmy
 */
public class QueryEditorial {

    private conexion con = new conexion();
    public Editorial editorial = new Editorial();

    public boolean agregarEditorial(String nombre, String direccion, String telefono) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO biblioteca.editorial (nombre,direccion,telefono) VALUES(?,?,?)");
            stmt1.setString(1, nombre);
            stmt1.setString(2, direccion);
            stmt1.setString(3, telefono);
            rows_updated = stmt1.executeUpdate();

            if (rows_updated == 1) {
                JOptionPane.showMessageDialog(null, "Editorial agregada correctamente!");
                con.desconectar();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar editorial");
                con.desconectar();
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    public Editorial obtenerEditorial(int id) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.editorial WHERE idEditorial=" + id);

            resultado.beforeFirst();
            resultado.last();

            editorial.setNombre(resultado.getString("nombre"));
            editorial.setDireccion(resultado.getString("direccion"));
            editorial.setTelefono(resultado.getString("telefono"));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return editorial;
    }

    public List<Editorial> mostrarEditorial() {
        List<Editorial> listaEditorial = new ArrayList<Editorial>();
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.editorial");
            resultado.last();
            if (resultado.getRow() <= 0) {
                listaEditorial.clear();
                return listaEditorial;
            } else {
                resultado.beforeFirst();
                while (resultado.next()) {
                    int id = (Integer) resultado.getObject("ideditorial");
                    String nombre = resultado.getObject("nombre").toString();
                    String direccion = resultado.getObject("direccion").toString();
                    String tel = resultado.getObject("telefono").toString();
                    Editorial ed = new Editorial(id, nombre, direccion, tel);
                    listaEditorial.add(ed);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        con.desconectar();
        return listaEditorial;
    }

    public boolean modificarEditorial(int id, String nombre, String direccion, String telefono) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("update biblioteca.editorial SET nombre =?, direccion = ?, telefono = ? WHERE (ideditorial = " + id + ")");
            stmt1.setString(1, nombre);
            stmt1.setString(2, direccion);
            stmt1.setString(3, telefono);

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
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            return false;
        }
    }

    public Boolean eliminarEditorial(int id) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("DELETE from biblioteca.editorial where ideditorial= " + id);
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

    public List<Editorial> buscarEditorial(String n) {
        List<Editorial> listaEditorial = new ArrayList<Editorial>();
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.editorial WHERE nombre LIKE '%" + n + "%'");
            resultado.last();
            if (resultado.getRow() <= 0) {
                listaEditorial.clear();
                return listaEditorial;
            } else {
                resultado.beforeFirst();
                while (resultado.next()) {
                    int id = (Integer) resultado.getObject("ideditorial");
                    String nombre = resultado.getObject("nombre").toString();
                    String direccion = resultado.getObject("direccion").toString();
                    String tel = resultado.getObject("telefono").toString();
                    Editorial ed = new Editorial(id, nombre, direccion, tel);
                    listaEditorial.add(ed);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        con.desconectar();
        return listaEditorial;
    }

// Para llenar listbox de agregar libro
    public List<Editorial> obtenerEditorial() {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.editorial ORDER BY nombre asc");

            ArrayList<Editorial> edi = new ArrayList<Editorial>();

            if (resultado.next()) {
                do {
                    Editorial editorialTemporal = new Editorial(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4));
                    edi.add(editorialTemporal);
                } while (resultado.next());
                con.desconectar();
                return edi;
            } else {
                con.desconectar();
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            con.desconectar();
            return null;
        }
    }

    public int obtenerIdEditorial(String u) {
        int idio = 0;
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.editorial WHERE nombre ='" + u + "'");

            resultado.beforeFirst();
            resultado.last();

            idio = resultado.getInt("idEditorial");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            con.desconectar();
        }
        con.desconectar();
        return idio;
    }

}
