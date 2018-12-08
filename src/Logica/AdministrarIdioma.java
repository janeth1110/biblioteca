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
    
    public List<Idioma> obteIdioma(){
        List<Idioma> listaIdioma = new ArrayList<Idioma>();
        QueryIdioma rel = new QueryIdioma();
        listaIdioma = rel.ObtenerIdiomas();
        return listaIdioma;        
    }
    
    public int ObtenerIdIdioma(String u){
        int idio = 0;
        QueryIdioma rel = new QueryIdioma();
        idio=rel.obtenerIdIdioma(u);
        return idio;
    }
    
    public Idioma devolverIdioma(int id){
        Idioma idi = new Idioma();
        QueryIdioma rel = new QueryIdioma();
        idi = rel.devolberIdioma(id);
        return idi;
    }
    
}
