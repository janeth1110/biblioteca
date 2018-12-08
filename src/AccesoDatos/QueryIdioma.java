/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Logica.Idioma;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author delmy
 */
public class QueryIdioma {

    private conexion con = new conexion();
    public Idioma idioma = new Idioma();

    public ArrayList<Idioma> ObtenerIdiomas() {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.idioma ORDER BY idioma asc");

            ArrayList<Idioma> idio = new ArrayList<Idioma>();

            if (resultado.next()) {
                do {
                    Idioma idiomaTemporal = new Idioma(resultado.getInt(1), resultado.getString(2));
                    idio.add(idiomaTemporal);
                } while (resultado.next());
                con.desconectar();
                return idio;
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

    public int obtenerIdIdioma(String u) {
        int idio = 0;
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.idioma WHERE idioma = '" + u + "'");

            resultado.beforeFirst();
            resultado.last();

            idio = resultado.getInt("idIdioma");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            con.desconectar();
        }
        con.desconectar();
        return idio;
    }
    
    public Idioma devolberIdioma(int x){
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM biblioteca.idioma WHERE idIdioma=" + x);

            resultado.beforeFirst();
            resultado.last();

            idioma.setId(resultado.getInt("idIdioma"));
            idioma.setIdioma(resultado.getString("idioma"));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return idioma;
    }

}
