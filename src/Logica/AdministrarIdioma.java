package Logica;

import AccesoDatos.QueryIdioma;
import java.util.ArrayList;
import java.util.List;

public class AdministrarIdioma {
    
     QueryIdioma rel = new QueryIdioma();
    
    public List<Idioma> obteIdioma(){
        List<Idioma> listaIdioma = new ArrayList<Idioma>();
        listaIdioma = rel.ObtenerIdiomas();
        return listaIdioma;        
    }
    
    public int ObtenerIdIdioma(String u){
        int idio = 0;
        idio=rel.obtenerIdIdioma(u);
        return idio;
    }
    
        /** 
         * Devuelve el idioma a partir de su ID
         */
    public String ObtenerIdio(int y) {
        String g;
        Idioma idi = new Idioma();
        idi = rel.devolverIdioma(y);
        g = idi.getIdioma();
        return g;
    }
}
