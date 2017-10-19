/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.model;

/**
 *
 * @author Laura RB
 */
public class ventana {
    private Ubicacion ubicacion;
    private int estado ;
    /**
     * Constructor de la clase Sulcata.
     *
     * @param x La coordenada x en donde se encuentra ubicado la ventana.
     * @param y La coordenada y en donde se encuentra ubicado la ventana.
     * @param w El ancho de la ventana.
     * @param h El largo de la ventana.
     * @param estado El largo de la ventana. 
     * @param nombre El nombre d ela ventana
     */
    public ventana(int x, int y, int w, int h,int estado) {
        ubicacion= new Ubicacion(x, y, w, h);
        this.estado = estado;
    }
    public ventana() { }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    public int getEstado(){
        return estado;
    };
    public void setEStado(int e){
        this.estado = e;
    };

}
