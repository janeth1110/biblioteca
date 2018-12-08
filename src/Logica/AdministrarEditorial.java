/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.QueryEditorial;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author delmy
 */
public class AdministrarEditorial {

    public boolean agregarEditorial(Editorial e) {
        QueryEditorial rel = new QueryEditorial();
        return rel.agregarEditorial(e.getNombre(), e.getDireccion(), e.getTelefono());
    }


    public List<Editorial> mostrarEditorial() {
        List<Editorial> listaEditorial = new ArrayList<Editorial>();
        QueryEditorial rel = new QueryEditorial();
        listaEditorial = rel.mostrarEditorial();
        return listaEditorial;
    }

    public Editorial obtenerEditorial(int id) {
        Editorial edi = new Editorial();
        QueryEditorial rel = new QueryEditorial();
        edi = rel.obtenerEditorial(id);
        return edi;
    }

    public boolean modificarEditorial(int id, String nombre, String direccion, String tel) {
        QueryEditorial que = new QueryEditorial();
        return que.modificarEditorial(id, nombre, direccion, tel);
    }

    public boolean eliminarEditorial(int id) {
        QueryEditorial pa = new QueryEditorial();
        return pa.eliminarEditorial(id);
    }
    
     public List<Editorial> buscarEditorial(String n) {
        List<Editorial> listaEditorial = new ArrayList<Editorial>();
        QueryEditorial rel = new QueryEditorial();
        listaEditorial = rel.buscarEditorial(n);
        return listaEditorial;
    }
     
     //Llenar listbox de agregar libro
     
     public List<Editorial> obteEditorial() {
        List<Editorial> listaEditorial = new ArrayList<Editorial>();
        QueryEditorial rel = new QueryEditorial();
        listaEditorial = rel.obtenerEditorial();
        return listaEditorial;
    }
     
     public int obtenerIdEditorial(String u){
         int edi=0;
         QueryEditorial rel = new QueryEditorial();
        edi = rel.obtenerIdEditorial(u);
        return edi;
     }
     
}
