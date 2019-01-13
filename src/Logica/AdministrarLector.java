package Logica;

import AccesoDatos.*;
import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class AdministrarLector {

    public boolean agregarLector(Lector l) {
        QueryLector rel = new QueryLector();
        return rel.agregarLector(l.getNombre(), l.getApellido(), l.getSexo(), l.getFecha_nac(), l.getCondicion(), l.getTelefono());
    }

    public List<Lector> mostrarLector() {
        List<Lector> listaLector = new ArrayList<Lector>();
        QueryLector rel = new QueryLector();
        listaLector = rel.mostrarLector();
        return listaLector;
    }

    public Lector obtenerLector(int nombre) {
        Lector lec = new Lector();
        QueryLector rel = new QueryLector();
        lec = rel.obtenerLector(nombre);
        return lec;
    }

    public boolean modificarLector(int id, String nombre, String apellido, String condicion, String tel) {
        QueryLector qul = new QueryLector();
        return qul.modificarLector(id, nombre, apellido, condicion, tel);
    }

    public boolean eliminarLector(int id) {
        QueryLector el = new QueryLector();
        return el.eliminarLector(id);
    }

    public List<Lector> buscarLector(String n) {
        List<Lector> listaLector = new ArrayList<Lector>();
        QueryLector rel = new QueryLector();
        listaLector = rel.buscarLector(n);
        return listaLector;
    }

    public Lector obtenerIdLector(String nombre) {
        Lector lec = new Lector();
        QueryLector rel = new QueryLector();
        lec = rel.obtenerIdLector(nombre);
        return lec;
    }

    public String SexoSeleccionado(JComboBox<String> sex) {
        int selected;
        String sexo;
        selected = sex.getSelectedIndex();

        switch (selected) {
            case 0:
                sexo = "F";
                break;
            default:
                sexo = "M";
                break;
        }
        return sexo;
    }

    public String CondicionSeleccionada(JComboBox<String> cond) {
        String condicion;
        int selected = cond.getSelectedIndex();

        switch (selected) {
            case 0:
                condicion = "Docente";
                break;
            case 1:
                condicion = "Externo";
                break;
            default:
                condicion = "Estudiante";
                break;
        }
        return condicion;
    }

    public Date fecha_nacimiento(JDateChooser fech) {
        java.sql.Date sqlDate;
        try {
            java.util.Date date = fech.getDate();
            sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Al menos elija una FECHA DE NACIMIENTO VALIDA ", "Error..!!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
