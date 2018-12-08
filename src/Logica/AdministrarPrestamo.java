/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.Realizacion;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


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
    
}