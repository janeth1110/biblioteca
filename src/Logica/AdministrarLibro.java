/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.QueryLibro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author delmy
 */
public class AdministrarLibro {
    
    public boolean agregarLibro(Libro l) {
        QueryLibro rel = new QueryLibro();
        return rel.agregarLibro(l.getIdEditorial(), l.getIdCategoria(), l.getIdAutor(), l.getISBN(), l.getTitulo(), l.getAño(), l.getDescripcion(), l.getEdicion(), l.getIdioma());
    }

    public List<Libro> mostrarLibro() {
        List<Libro> listaLibro = new ArrayList<Libro>();
        QueryLibro rel = new QueryLibro();
        listaLibro = rel.mostrarLibro();
        return listaLibro;
    }

    public Libro obtenerLibro(int nombre) {
        Libro lib = new Libro();
        QueryLibro rel = new QueryLibro();
        lib = rel.obtenerLibro(nombre);
        return lib;
    }

    public boolean modificarLibro(int id, String titulo, String descripcion, int edicion) {
        QueryLibro qul = new QueryLibro();
        return qul.modificarLibro(id, titulo, descripcion, edicion);
    }
    
    public boolean eliminarLibro(int id) {
        QueryLibro el = new QueryLibro();
        return el.eliminarLibro(id);
    }
    
    public List <Libro> buscarLibro(String n){
        List<Libro> listaLibro = new ArrayList<Libro>();
        QueryLibro rel = new QueryLibro();
        listaLibro = rel.buscarLibro(n);
        return listaLibro;
    }
    
    public int mostrarEjemplar(int id){
        int cantidad=0;
        QueryLibro me = new QueryLibro();
        cantidad = me.obtenerEjemplares(id);
        return cantidad;
    }
    
}
