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
    public static Tuple[][] dibujarMapa() {
        Tuple [][] ventanas=new Tuple[10][5];
        for (Tuple[] ventana : ventanas) {
            for (int j = 0; j < ventana.length; j++) {
                Tuple tuple=new Tuple<>((int) (Math.random()*4)+1,(int) (Math.random()*4));
                ventana[j] = tuple;
            }
        }
        return ventanas;
    }

    
}
