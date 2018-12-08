/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author delmy
 */
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
    
    public List <Lector> buscarLector(String n){
        List<Lector> listaLector = new ArrayList<Lector>();
        QueryLector rel = new QueryLector();
        listaLector = rel.buscarLector(n);
        return listaLector;
    }
}
