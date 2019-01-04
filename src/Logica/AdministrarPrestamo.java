/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.Realizacion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.sql.Date;


/**
 *
 * @author delmy
 */
public class AdministrarPrestamo {
    
    public boolean agregarPrestamo(Prestamo p){
        Realizacion realizacion = new Realizacion();
        return realizacion.agregarPrestamo(p.getIdEjemplar(), p.getIdLector(), p.getFechaPrestamo(), p.getFechaDevolucion(), p.getDevolucion(), p.getTipoPrestamo());
    }
    
    public String obtenerDisponibilidad(int id){
        String estado="";
        Realizacion me = new Realizacion();
        estado = me.obtenerEstadoDisponibilidad(id);
        return estado;
    }
    
    public boolean actualizarEstadoEjemplar(int id) {
        Realizacion real = new Realizacion();
        return real.actualizarDisponibilidadEjemplar(id);
    }
    
    public boolean devolucionPrestamo(int idPrestamo, Date fechaDevolucion, String estado) {
        Realizacion real = new Realizacion();
        return real.devolucionPrestamo(idPrestamo, fechaDevolucion, estado);
    }
    
    public List<Prestamo> mostrarPrestamo() {
        List<Prestamo> listaPrestamo = new ArrayList<Prestamo>();
        Realizacion rel = new Realizacion();
        listaPrestamo = rel.mostrarPrestamos();
        return listaPrestamo;
    }
    
    //Buscar prestamos, devuelve lista de prestamos
    public List <Prestamo> buscarPrestamo(int n){
        List<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
        Realizacion rel = new Realizacion();
        listaPrestamos = rel.buscarPrestamo(n);
        return listaPrestamos;
    }
 
    //obtener tipo de prestamo seleccionado de comboBox   
    public String tipoPrestamo(JComboBox<String> tipoPrestamo) {
        int selected;
        String tipo=null;
        selected = tipoPrestamo.getSelectedIndex();

        switch (selected) {
            case 0:
//                JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de prestamo");
                tipo = "sala";
                break;
            case 1:
                tipo = "llevar a casa";
                break;
        }
        return tipo;
    }

    //Obtener prestamo para devolucion
    public Prestamo obtenerPrestamo (int id){
        Prestamo prestamo = new Prestamo();
        Realizacion rel = new Realizacion();
        prestamo = rel.obtenerPrestamo(id);
        return prestamo;
    }   
    
    
}
