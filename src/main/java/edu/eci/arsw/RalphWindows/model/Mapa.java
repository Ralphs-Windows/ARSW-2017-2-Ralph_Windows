/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.model;

import java.util.Arrays;



/**
 *
 * @author laura
 */
public class Mapa {
    private ventana[][] ventanas;
    /**
     *Crear ventanas aleatorias con diferentes estados
     * @param v
     */
    public Mapa(ventana[][] v) {
        ventanas=v;
    }
    /**
     *Crear ventanas aleatorias con diferentes estados
     */
    public Mapa() {
    }
    /**
     * 
     * @return 
     */
    public static ventana[][] dibujarMapa() {
        ventana[][] ventanas=new ventana[9][5];
        for (ventana[] ventana : ventanas) {
            for (int j = 0; j < ventana.length; j++) {
                ventana[j] = new ventana(0,0,0,0,(int)(Math.random()*5),(int)(Math.random()*4));
            }
        }
        return ventanas;
    }
    /**
     * 
     * @return 
     */
    public ventana[][] getVentanas() {
        return ventanas;
    }
    /**
     * 
     * @param ventanas
     */
    public void setVentanas(ventana[][] ventanas) {    
        this.ventanas = ventanas;
    }
    
    @Override
    public String toString(){
        return "{ venatanas: "+Arrays.toString(ventanas)+"}";
    }
}
