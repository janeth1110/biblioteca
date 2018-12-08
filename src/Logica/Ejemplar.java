/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author delmy
 */
public class Ejemplar {

    private int idLibro;
    private int idEjemplar;
    private int numEjemplar;
    private String ubicacion;
    private int idEstado;

    public Ejemplar() {

    }

    public Ejemplar(int libro, int ejemplar, int numero, String ubicacion, int idEstado) {
        this.idLibro = libro;
        this.idEjemplar = ejemplar;
        this.numEjemplar = numero;
        this.ubicacion = ubicacion;
        this.idEstado = idEstado;
    }

    /**
     * @return the idLibro
     */
    public int getIdLibro() {
        return idLibro;
    }

    /**
     * @param idLibro the idLibro to set
     */
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * @return the numEjemplar
     */
    public int getNumEjemplar() {
        return numEjemplar;
    }

    /**
     * @param numEjemplar the numEjemplar to set
     */
    public void setNumEjemplar(int numEjemplar) {
        this.numEjemplar = numEjemplar;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the idEstado
     */
    public int getIdEstado() {
        return idEstado;
    }

    /**
     * @param idEstado the idEstado to set
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    /**
     * @return the idEjemplar
     */
    public int getIdEjemplar() {
        return idEjemplar;
    }

    /**
     * @param idEjemplar the idEjemplar to set
     */
    public void setIdEjemplar(int idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

}
