/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Logica.Categoria;
import java.awt.HeadlessException;
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
public class QueryCategoria {

    private conexion con = new conexion();
    public Categoria categoria = new Categoria();

    public boolean agregarCategoria(String cate) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO biblioteca.categoria (categoria) VALUES (?)");
            stmt1.setString(1, cate);
            rows_updated = stmt1.executeUpdate();

            if (rows_updated == 1) {
                //JOptionPane.showMessageDialog(null, "Categoria agregada correctamente");
                con.desconectar();
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "No se pudo agregar la categoria");
                con.desconectar();
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    //Se usa para el actualizar categoria
    public Categoria obtenerCategoria(int id) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.categoria WHERE idcategoria = " + id);

            resultado.beforeFirst();
            resultado.last();

            categoria.setCategoria(resultado.getString("categoria"));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return categoria;
    }

    public List<Categoria> mostrarCategoria() {
        List<Categoria> listaCategorias = new ArrayList<Categoria>();
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.categoria");

            resultado.last();

            if (resultado.getRow() <= 0) {
                listaCategorias.clear();
                return listaCategorias;
            } else {
                resultado.beforeFirst();
                while (resultado.next()) {
                    int id = (Integer) resultado.getObject("idcategoria");
                    String categoria = resultado.getObject("categoria").toString();
                    Categoria ca = new Categoria(id, categoria);
                    listaCategorias.add(ca);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        con.desconectar();
        return listaCategorias;
    }

    public boolean modificarCategoria(int id, String categoria) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("UPDATE biblioteca.categoria SET categoria =? WHERE (idcategoria=" + id + ")");
            stmt1.setString(1, categoria);
            rows_updated = stmt1.executeUpdate();

            if (rows_updated == 1) {
//                JOptionPane.showMessageDialog(null, "Actualizacion realizada");
                con.desconectar();
                return true;
            } else {
                con.desconectar();
                return false;
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarCategoria(int id) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("DELETE FROM biblioteca.categoria WHERE idcategoria = " + id);
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

    public List<Categoria> buscarCategoria(String n) {
        List<Categoria> listaCategorias = new ArrayList<Categoria>();
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.categoria WHERE categoria like '" + n + "%'");
            resultado.last();
            if (resultado.getRow() <= 0) {
                listaCategorias.clear();
                return listaCategorias;
            } else {
                resultado.beforeFirst();
                while (resultado.next()) {
                    int id = (Integer) resultado.getObject("idcategoria");
                    String categoria = resultado.getObject("categoria").toString();
                    Categoria ca = new Categoria(id, categoria);
                    listaCategorias.add(ca);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        con.desconectar();
        return listaCategorias;
    }

    //para llenar comboBox de agregar Libro
    public ArrayList<Categoria> obtenerLista() {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.categoria ORDER BY categoria asc");

            ArrayList<Categoria> info = new ArrayList<Categoria>();

            if (resultado.next()) {
                do {
                    Categoria listaTemporal = new Categoria(resultado.getInt(1), resultado.getString(2));
//                    JOptionPane.showMessageDialog(null, resultado.getString(2));
                    info.add(listaTemporal);
                } while (resultado.next());
                return info;
            } else {
                return null;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public int obtenerIdCategoria(String i) {
        int catego = 0;
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.categoria WHERE categoria = '" + i + "'");

            resultado.beforeFirst();
            resultado.last();

            catego = resultado.getInt("idcategoria");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return catego;
    }

}
