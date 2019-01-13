package AccesoDatos;

import java.sql.*;
import javax.swing.JOptionPane;

public class conexion {

    Connection conexion = null;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/biblioteca", "root", "admin");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return conexion;
    }

    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
