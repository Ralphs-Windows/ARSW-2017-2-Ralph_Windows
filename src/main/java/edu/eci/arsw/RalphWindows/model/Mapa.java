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
public class Mapa {
    /**
     *Crear ventanas aleatorias con diferentes estados
     * @return Retorna una matriz con las fiferentes ventanas para reparar
     */
    public static ventana[][] dibujarMapa() {
        ventana [][] ventanas=new ventana[9][5];
        for (ventana[] ventana : ventanas) {
            for (int j = 0; j < ventana.length; j++) {
                ventana[j] = new ventana(0,0,0,0,(int)(Math.random()*5),(int)(Math.random()*4));
            }
        }
        return ventanas;
    }

    
}
