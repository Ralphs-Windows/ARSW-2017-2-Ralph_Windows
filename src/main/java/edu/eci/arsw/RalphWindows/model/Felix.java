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
    private String eq;
    private String dir;
    private int num;
    private int puntos=0;
    
    public Felix(int x, int y, int w, int h,String eq,String r,int num) {
        ubicacion=new Ubicacion(x, y, w, h);
        this.eq=eq;
        this.dir=r;
        this.num=num;
        
    }
    public Felix() {
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEq() {
        return eq;
    }

    public void setEq(String eq) {
        this.eq = eq;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String mirada) {
        this.dir = mirada;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
    
}   

