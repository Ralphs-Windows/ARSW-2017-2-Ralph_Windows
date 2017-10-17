/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.model;


/**
 *
 * @author laura
 */
public class Felix{
    private Ubicacion ubicacion;
    public Felix(int x, int y, int w, int h) {
        ubicacion=new Ubicacion(x, y, w, h);
    }
    public Felix() {
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    
}   

