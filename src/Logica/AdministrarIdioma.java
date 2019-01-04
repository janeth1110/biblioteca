/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.QueryIdioma;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author delmy
 */
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
    
//    public Idioma devolverIdioma(int id){
//        Idioma idi = new Idioma();
//        QueryIdioma rel = new QueryIdioma();
//        idi = rel.devolberIdioma(id);
//        return idi;
//    }
    
        /** 
         * Devuelve el idioma a partir de su ID
         */
    public String ObtenerIdio(int y) {
        String g;
        Idioma idi = new Idioma();
        idi = rel.devolberIdioma(y);
        g = idi.getIdioma();
        return g;
    }

    
}
