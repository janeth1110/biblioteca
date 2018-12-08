/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.QueryEjemplar;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author delmy
 */
public class AdministrarEjemplar {
    
    public boolean agregarEjemplar(Ejemplar e){
        QueryEjemplar rel = new QueryEjemplar();
        return rel.agregarEjemplar(e.getIdLibro(), e.getNumEjemplar(), e.getUbicacion(), e.getIdEstado());
    }
    
    public Ejemplar obtenerEjemplar(int i){
        Ejemplar eje = new Ejemplar();
        QueryEjemplar rel = new QueryEjemplar();
        eje = rel.obtenerEjemplar(i);
        return eje;
    }
    
    public List<Ejemplar> mostrarEjemplar(int i){
        List<Ejemplar> listaEjemplar = new ArrayList<Ejemplar>();
        QueryEjemplar rel = new QueryEjemplar();
        listaEjemplar=rel.mostrarEjemplar(i);
        return listaEjemplar;
    }
    
}
