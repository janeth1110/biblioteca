package Logica;

import AccesoDatos.QueryEjemplar;
import java.util.ArrayList;
import java.util.List;

public class AdministrarEjemplar {

    public boolean agregarEjemplar(Ejemplar e) {
        QueryEjemplar rel = new QueryEjemplar();
        return rel.agregarEjemplar(e.getIdLibro(), e.getNumEjemplar(), e.getUbicacion(), e.getIdEstado());
    }

    public Ejemplar obtenerEjemplar(int i) {
        Ejemplar eje = new Ejemplar();
        QueryEjemplar rel = new QueryEjemplar();
        eje = rel.obtenerEjemplar(i);
        return eje;
    }

    public List<Ejemplar> mostrarEjemplar(int i) {
        List<Ejemplar> listaEjemplar = new ArrayList<Ejemplar>();
        QueryEjemplar rel = new QueryEjemplar();
        listaEjemplar = rel.mostrarEjemplar(i);
        return listaEjemplar;
    }

    //retornar id de libro a partir de id ejemplar  
    public int devolverIdLibro(int x) {
        int i = 0;
        QueryEjemplar que = new QueryEjemplar();
        i = que.obtenerIdLibroAPartirDeEjemplar(x);
        return i;
    }
}
