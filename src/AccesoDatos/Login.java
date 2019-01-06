package AccesoDatos;

import Logica.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Login {

    private final conexion con = new conexion();
    Usuario user = new Usuario();

    /**
     * Inserta usuario nuevo a la base de datos
     *
     * @param id
     * @param contra
     * @param nombre
     * @param apellido
     * @param rol
     * @return true/false
     */
    public boolean agregarUsuario(int id, String contra, String nombre, String apellido, String rol) {
        try {
            int rows_updated;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO biblioteca.login (idUser, pass, nombre, apellido, cargo) VALUES(?,?,?,?,?)");
            stmt1.setInt(1, id);
            stmt1.setString(2, contra);
            stmt1.setString(3, nombre);
            stmt1.setString(4, apellido);
            stmt1.setString(5, rol);
            rows_updated = stmt1.executeUpdate();

            if (rows_updated == 1) {
                JOptionPane.showMessageDialog(null, "Usuario agregado correctamente!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                con.desconectar();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar usuario. \nPor favor verifique los datos", "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
                con.desconectar();
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar usuario, error:\n" + ex.getMessage(), "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
            con.desconectar();
            return false;
        }
    }

    /**
     * Obtiene usuario para permitir/denegar inicio de sesion
     *
     * @param id
     * @return user
     */
    public Usuario obtenerUsuario(int id) {
        try {
            Statement sentencia;
            ResultSet resultado;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.login WHERE idUser=" + id);
            resultado.beforeFirst();
            resultado.last();

            user.setId(resultado.getInt("idUser"));
            user.setPass(resultado.getString("pass"));
            user.setNames(resultado.getString("nombre"));
            user.setLastNames(resultado.getString("apellido"));
            user.setRol(resultado.getString("cargo"));

            con.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña invalidos\n" + e.getMessage(), "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
            con.desconectar();
        }
        return user;
    }

    /**
     * Metodo para modificar contraseña
     *
     * @param id
     * @param pass
     * @return true/false
     */
    public boolean modificarUsuario(int id, String pass) {
        try {
            int rows_updated;
            PreparedStatement stmt1 = con.conectar().prepareStatement("UPDATE biblioteca.login SET pass =? WHERE (idUser = " + id + ")");
            stmt1.setString(1, pass);

            rows_updated = stmt1.executeUpdate();
            if (rows_updated == 1) {
                JOptionPane.showMessageDialog(null, "Contraseña actualizada exitosamente!", "En horabuena!", JOptionPane.INFORMATION_MESSAGE);
                con.desconectar();
                return true;
            } else {
                con.desconectar();
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cambiar contraseña, error:\n" + e.getMessage(), "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Muestra lista de usuarios registrados
     *
     * @return Todos los usuarios
     */
    public List<Usuario> mostrarUsuario() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        try {
            Statement sentencia;
            ResultSet resultado;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.login");
            resultado.last();
            if (resultado.getRow() <= 0) {
                listaUsuarios.clear();
                return listaUsuarios;
            } else {
                resultado.beforeFirst();
                while (resultado.next()) {
                    int id = (Integer) resultado.getObject("idUser");
                    String pass = resultado.getObject("pass").toString();
                    String nombre = resultado.getObject("nombre").toString();
                    String apellido = resultado.getObject("apellido").toString();
                    String cargo = resultado.getObject("cargo").toString();
                    Usuario us = new Usuario(id, pass, nombre, apellido, cargo);
                    listaUsuarios.add(us);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar usuarios, error:\n" + e.getMessage(), "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
        con.desconectar();
        return listaUsuarios;
    }
    /**
     * Metodo para eliminar usuarios
     * @param id
     * @return 
     */
    public Boolean eliminarUsuario(int id) {
        try {
            int rows_updated;
            PreparedStatement stmt1 = con.conectar().prepareStatement("DELETE from biblioteca.login where idUser= " + id);
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
}
