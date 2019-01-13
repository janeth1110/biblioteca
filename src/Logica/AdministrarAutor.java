package Logica;

import AccesoDatos.*;
import java.util.ArrayList;
import java.util.List;

public class AdministrarAutor {

    public boolean agregarAutor(Autor a) {
        QueryAutor rel = new QueryAutor();
        return rel.agregarAutor(a.getNombre(), a.getApellido());
    }

    public List<Autor> mostrarAutor() {
        List<Autor> listaAutor = new ArrayList<Autor>();
        QueryAutor rel = new QueryAutor();
        listaAutor = rel.mostrarAutor();
        return listaAutor;
    }

    public Autor obtenerAutor(int id) {
        Autor edi = new Autor();
        QueryAutor rel = new QueryAutor();
        edi = rel.obtenerAutor(id);
        return edi;
    }

    public boolean modificarAutor(int id, String nombre, String apellido) {
        QueryAutor que = new QueryAutor();
        return que.modificarAutor(id, nombre, apellido);
    }

    public boolean eliminarAutor(int id) {
        QueryAutor pa = new QueryAutor();
        return pa.eliminarAutor(id);
    }

    public List<Autor> buscarAutor(String n) {
        List<Autor> listaAutor = new ArrayList<Autor>();
        QueryAutor rel = new QueryAutor();
        listaAutor = rel.buscarAutor(n);
        return listaAutor;
    }

    //para llenar comboBox
    public List<Autor> obteAutor() {
        List<Autor> listaAutor = new ArrayList<Autor>();
        QueryAutor rel = new QueryAutor();
        listaAutor = rel.obtenerAutor();
        return listaAutor;
    }

    public int obtenerIdAutor(String n) {
        int au = 0;
        QueryAutor rel = new QueryAutor();
        au = rel.obtenerIdAutor(n);
        return au;
    }

    /**
     * Devuelve el nombre del autor a partir de su ID
     */
    public String ObtenerAut(int y) {
        String g;
        Autor au = new Autor();
        au = obtenerAutor(y);
        g = au.getNombre() + " " + au.getApellido();
        return g;
    }
}
