/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.model;


/**
 *
 * @author laura RB
 */
public class Felix{
    private Ubicacion ubicacion;
    private String eq;
    private String dir;
    private int num;
    private int puntos=0;
    
    /**
     * 
     * @param x
     * @param y
     * @param w
     * @param h
     * @param eq
     * @param r
     * @param num 
     */
    public Felix(int x, int y, int w, int h,String eq,String r,int num) {
        ubicacion=new Ubicacion(x, y, w, h);
        this.eq=eq;
        this.dir=r;
        this.num=num;
        
    }
    /**
     * 
     */
    public Felix() {
    }
    /**
     * 
     * @return 
     */
    public Ubicacion getUbicacion() {
        return ubicacion;
    }
    /**
     * 
     * @param ubicacion 
     */
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    /**
     * 
     * @return 
     */
    public String getEq() {
        return eq;
    }
    /**
     * 
     * @param eq
     */
    public void setEq(String eq) {
        this.eq = eq;
    }
    /**
     * 
     * @return 
     */
    public String getDir() {
        return dir;
    }
    /**
     * 
     * @param mirada 
     */
    public void setDir(String mirada) {
        this.dir = mirada;
    }
    /**
     * 
     * @return 
     */
    public int getNum() {
        return num;
    }
    /**
     * 
     * @param num 
     */
    public void setNum(int num) {
        this.num = num;
    }
    /**
     * 
     * @return 
     */
    public int getPuntos() {
        return puntos;
    }
    /**
     * 
     * @param puntos
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
    
}   

