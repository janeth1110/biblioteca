/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Logica.Lector;
import java.awt.HeadlessException;
import java.sql.Date;
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
public class QueryLector {

    private conexion con = new conexion();
    public Lector lector = new Lector();

    public boolean agregarLector(String nombre, String apellido, String sexo, Date fecha, String condicion, String telefono) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO biblioteca.lector (nombre, apellido, sexo, fecha_nacimiento, condicion, telefono) VALUES (?,?,?,?,?,?)");
            stmt1.setString(1, nombre);
            stmt1.setString(2, apellido);
            stmt1.setString(3, sexo);
            stmt1.setDate(4, fecha);
            stmt1.setString(5, condicion);
            stmt1.setString(6, telefono);
            rows_updated = stmt1.executeUpdate();

            if (rows_updated == 1) {
                JOptionPane.showMessageDialog(null, "Lector agregado exitosamente");
                con.desconectar();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar lector, por favor verifique los datos");
                con.desconectar();
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public Lector obtenerLector(int nombre) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.lector WHERE idlector= " + nombre);

            resultado.beforeFirst();
            resultado.last();

            lector.setNombre(resultado.getString("nombre"));
            lector.setApellido(resultado.getString("apellido"));
            lector.setSexo(resultado.getString("sexo"));
            lector.setFecha_nac(resultado.getDate("fecha_nacimiento"));
            lector.setCondicion(resultado.getString("condicion"));
            lector.setTelefono(resultado.getString("telefono"));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return lector;
    }

    public List<Lector> mostrarLector() {
        List<Lector> listaLector = new ArrayList<Lector>();
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.lector");
            resultado.last();
            if (resultado.getRow() <= 0) {
                listaLector.clear();
                return listaLector;
            } else {
                resultado.beforeFirst();
                while (resultado.next()) {
                    int id = (Integer) resultado.getObject("idlector");
                    String nombre = resultado.getObject("nombre").toString();
                    String apellido = resultado.getObject("apellido").toString();
                    String sexo = resultado.getObject("sexo").toString();
                    Date fecha = resultado.getDate("fecha_nacimiento");
                    String condicion = resultado.getObject("condicion").toString();
                    String tel = resultado.getObject("telefono").toString();
                    Lector le = new Lector(id, nombre, apellido, sexo, fecha, condicion, tel);
                    listaLector.add(le);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        con.desconectar();
        return listaLector;
    }

    public boolean modificarLector(int id, String nombre, String apellido, String condicion, String telefono) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("UPDATE biblioteca.lector SET nombre =?, apellido = ?, condicion=?, telefono = ? WHERE (idlector = " + id + ")");
            stmt1.setString(1, nombre);
            stmt1.setString(2, apellido);
            stmt1.setString(3, condicion);
            stmt1.setString(4, telefono);

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
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }

    public Boolean eliminarLector(int id) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("DELETE from biblioteca.lector where idlector= " + id);
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

    public List<Lector> buscarLector(String n) {
        List<Lector> listaLector = new ArrayList<Lector>();
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.lector WHERE nombre like '" + n + "%'");
            resultado.last();
            if (resultado.getRow() <= 0) {
                listaLector.clear();
                return listaLector;
            } else {
                resultado.beforeFirst();
                while (resultado.next()) {
                    int id = (Integer) resultado.getObject("idlector");
                    String nombre = resultado.getObject("nombre").toString();
                    String apellido = resultado.getObject("apellido").toString();
                    String sexo = resultado.getObject("sexo").toString();
                    Date fecha = resultado.getDate("fecha_nacimiento");
                    String condicion = resultado.getObject("condicion").toString();
                    String tel = resultado.getObject("telefono").toString();
                    Lector le = new Lector(id, nombre, apellido, sexo, fecha, condicion,tel);
                    listaLector.add(le);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        con.desconectar();
        return listaLector;
    }
    
    public Lector obtenerIdLector(String nombre) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM lector WHERE nombre LIKE '" + nombre +"%'");

            resultado.beforeFirst();
            resultado.last();

            lector.setNombre(resultado.getString("nombre"));
            lector.setApellido(resultado.getString("apellido"));
            lector.setSexo(resultado.getString("sexo"));
            lector.setFecha_nac(resultado.getDate("fecha_nacimiento"));
            lector.setCondicion(resultado.getString("condicion"));
            lector.setTelefono(resultado.getString("telefono"));
            lector.setId(resultado.getInt("idlector"));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
//JOptionPane.showMessageDialog(null, lector.getId());
        return lector;
    }
    
}
