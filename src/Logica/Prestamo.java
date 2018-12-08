/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Date;

/**
 *
 * @author delmy
 */
public class Prestamo {
    
    private int idEjemplar;
    private int idLector;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String devolucion;
    private String tipoPrestamo;
    
    public Prestamo(){
        
    }
    
    public Prestamo(int idEjemplar, int idLector, Date fechaPrestamo, Date fechaDevolucion, String devolucion, String tipoPrestamo){       
        this.idEjemplar = idEjemplar;
        this.idLector = idLector;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.devolucion = devolucion;
        this.tipoPrestamo = tipoPrestamo;      
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

    /**
     * @return the idLector
     */
    public int getIdLector() {
        return idLector;
    }

    /**
     * @param idLector the idLector to set
     */
    public void setIdLector(int idLector) {
        this.idLector = idLector;
    }

    /**
     * @return the fechaPrestamo
     */
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * @param fechaPrestamo the fechaPrestamo to set
     */
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * @return the fechaDevolucion
     */
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * @param fechaDevolucion the fechaDevolucion to set
     */
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * @return the devolucion
     */
    public String getDevolucion() {
        return devolucion;
    }

    /**
     * @param devolucion the devolucion to set
     */
    public void setDevolucion(String devolucion) {
        this.devolucion = devolucion;
    }

    /**
     * @return the tipoPrestamo
     */
    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    /**
     * @param tipoPrestamo the tipoPrestamo to set
     */
    public void setTipoPrestamo(String tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }
    
    
}
