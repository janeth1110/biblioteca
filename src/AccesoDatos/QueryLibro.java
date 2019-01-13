package AccesoDatos;

import Logica.Libro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class QueryLibro {

    private conexion con = new conexion();
    public Libro libro = new Libro();

    public boolean agregarLibro(int idEditorial, int idCategoria, int idAutor, String ISBN, String titulo, int year, String desc, int edicion, int idioma) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO biblioteca.libro (ideditorial, idcategoria, idautor, ISBN, titulo, año, descripcion, edicion, idioma) VALUES (?,?,?,?,?,?,?,?,?)");
            stmt1.setInt(1, idEditorial);
            stmt1.setInt(2, idCategoria);
            stmt1.setInt(3, idAutor);
            stmt1.setString(4, ISBN);
            stmt1.setString(5, titulo);
            stmt1.setInt(6, year);
            stmt1.setString(7, desc);
            stmt1.setInt(8, edicion);
            stmt1.setInt(9, idioma);
            rows_updated = stmt1.executeUpdate();

            if (rows_updated == 1) {
                con.desconectar();
                return true;
            } else {
                con.desconectar();
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public Libro obtenerLibro(int id) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.libro WHERE idlibro= " + id);
            resultado.beforeFirst();
            resultado.last();
            libro.setIdEditorial(resultado.getInt("ideditorial"));
            libro.setIdCategoria(resultado.getInt("idcategoria"));
            libro.setIdAutor(resultado.getInt("idautor"));
            libro.setISBN(resultado.getString("ISBN"));
            libro.setTitulo(resultado.getString("titulo"));
            libro.setAño(resultado.getInt("año"));
            libro.setDescripcion(resultado.getString("descripcion"));
            libro.setEdicion(resultado.getInt("edicion"));
            libro.setIdioma(resultado.getInt("idioma"));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        con.desconectar();
        return libro;
    }

    public List<Libro> mostrarLibro() {
        List<Libro> listaLibro = new ArrayList<Libro>();
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.libro");
            resultado.last();
            if (resultado.getRow() <= 0) {
                listaLibro.clear();
                return listaLibro;
            } else {
                resultado.beforeFirst();
                while (resultado.next()) {
                    int id = (Integer) resultado.getObject("idlibro");
                    int idEditorial = (Integer) resultado.getObject("ideditorial");
                    int idCategoria = (Integer) resultado.getObject("idcategoria");
                    int idAutor = (Integer) resultado.getObject("idautor");
                    String ISBN = resultado.getObject("ISBN").toString();
                    String titulo = resultado.getObject("titulo").toString();
                    int year = (Integer) resultado.getObject("año");
                    String descripcion = resultado.getObject("descripcion").toString();
                    int edicion = (Integer) resultado.getObject("edicion");
                    int idioma = (Integer) resultado.getObject("idioma");
                    Libro li = new Libro(id, idEditorial, idCategoria, idAutor, ISBN, titulo, year, descripcion, edicion, idioma);
                    listaLibro.add(li);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        con.desconectar();
        return listaLibro;
    }

    public boolean modificarLibro(int idLibro, String titulo, String descripcion, int edicion) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("UPDATE biblioteca.libro SET titulo =?, descripcion = ?, edicion=? WHERE (idlibro = " + idLibro + ")");
            stmt1.setString(1, titulo);
            stmt1.setString(2, descripcion);
            stmt1.setInt(3, edicion);

            rows_updated = stmt1.executeUpdate();
            if (rows_updated == 1) {
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

    public Boolean eliminarLibro(int idLibro) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("DELETE from biblioteca.libro where idlibro= " + idLibro);
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

    public List<Libro> buscarLibro(String n) {
        List<Libro> listaLibro = new ArrayList<Libro>();
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.libro WHERE titulo like '%" + n + "%'");
            resultado.last();
            if (resultado.getRow() <= 0) {
                listaLibro.clear();
                return listaLibro;
            } else {
                resultado.beforeFirst();
                while (resultado.next()) {
                    int id = (Integer) resultado.getObject("idlibro");
                    int idEditorial = (Integer) resultado.getObject("ideditorial");
                    int idCategoria = (Integer) resultado.getObject("idcategoria");
                    int idAutor = (Integer) resultado.getObject("idautor");
                    String ISBN = resultado.getObject("ISBN").toString();
                    String titulo = resultado.getObject("titulo").toString();
                    int year = (Integer) resultado.getObject("año");
                    String descripcion = resultado.getObject("descripcion").toString();
                    int edicion = (Integer) resultado.getObject("edicion");
                    int idioma = (Integer) resultado.getObject("idioma");
                    Libro li = new Libro(id, idEditorial, idCategoria, idAutor, ISBN, titulo, year, descripcion, edicion, idioma);
                    listaLibro.add(li);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        con.desconectar();
        return listaLibro;
    }

    public int obtenerEjemplares(int id) {
        int numero = 0;
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT COUNT(idejemplar) FROM biblioteca.ejemplar WHERE idlibro= " + id);
            resultado.last();
            numero = resultado.getInt(1);
            con.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            con.desconectar();
        }
        return numero;
    }
}
