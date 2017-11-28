/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author laura
 */
@Document(collection = "jugadores")
public class Jugador {
    @Id
    private String username;
    private int score;
    /**
     * 
     * @param nombre 
     */
    public Jugador(String nombre,int score){
        this.username=nombre;
        this.score=score;
    }
    /**
     * 
     * @param nombre 
     */
    public Jugador(String nombre){
        this.username=nombre;
        score=0;
    }
    /**
     * 
     */
    public Jugador(){
        username="";
    }
    /**
     * 
     * @return 
     */
    public String getUsername() {
        return username;
    }
    /**
     * 
     * @param nombre
     */
    public void setUsername (String nombre){
        username=nombre;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
}
