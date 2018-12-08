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
public class AdministrarCategoria {

    public boolean agregarCategoria(Categoria c) {
        QueryCategoria rel = new QueryCategoria();
        return rel.agregarCategoria(c.getCategoria());
    }

    public List<Categoria> mostrarCategoria() {
        List<Categoria> listaCategoria = new ArrayList<Categoria>();
        QueryCategoria rel = new QueryCategoria();
        listaCategoria = rel.mostrarCategoria();
        return listaCategoria;
    }
    
    public Categoria obtenerCategoria(int id) {
        Categoria cat = new Categoria();
        QueryCategoria rel = new QueryCategoria();
        cat = rel.obtenerCategoria(id);
        return cat;
    }
    
    public boolean modificarCategoria(int id, String categoria) {
        QueryCategoria que = new QueryCategoria();
        return que.modificarCategoria(id, categoria);
    }
    
    public boolean eliminarCategoria(int id) {
        QueryCategoria pa = new QueryCategoria();
        return pa.eliminarCategoria(id);
    }
    
    public List<Categoria> buscarCategoria(String n) {
        List<Categoria> listaCategoria = new ArrayList<Categoria>();
        QueryCategoria rel = new QueryCategoria();
        listaCategoria = rel.buscarCategoria(n);
        return listaCategoria;
    }
    
//   lista para llenar comboBox
    public List<Categoria> obteCategoria() {
        List<Categoria> listaCategoria = new ArrayList<Categoria>();
        QueryCategoria rel = new QueryCategoria();
        listaCategoria = rel.obtenerLista();
        return listaCategoria;
    }
    
     public int obtenerCatego(String cate) {
        int cat = 0;
        QueryCategoria rel = new QueryCategoria();
        cat = rel.obtenerIdCategoria(cate);
        return cat;
    }

}
