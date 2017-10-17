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
public class Jugador {
    String nombreuser;
    
    public Jugador(String nombre){
        this.nombreuser=nombre;
    }
    public Jugador(){}

    public String getNombreuser() {
        return nombreuser;
    }
    
    
}
