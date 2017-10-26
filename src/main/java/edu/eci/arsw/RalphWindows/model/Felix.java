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
    private int eq;
    private String dir;
    public Felix(int x, int y, int w, int h,int eq,String r) {
        ubicacion=new Ubicacion(x, y, w, h);
        this.eq=eq;
        this.dir=r;
        
    }
    public Felix() {
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getEq() {
        return eq;
    }

    public void setEq(int eq) {
        this.eq = eq;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String mirada) {
        this.dir = mirada;
    }

    
    
}   

