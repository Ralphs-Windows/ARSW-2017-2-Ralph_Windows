/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.model;

import java.util.ArrayList;

/**
 *
 * @author laura
 */
public class Equipo {
    private String ideq;
    private int puntos=0;
    private int vida=3;
    private ArrayList<Felix> felixs;
    
    public Equipo(String id) {
        ideq=id;
        felixs=new ArrayList<>();
    }
    
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public ArrayList<Felix> getFelixs() {
        return felixs;
    }

    public void setFelixs(ArrayList<Felix> js) {
        this.felixs = js;
    }

    public String getIdeq() {
        return ideq;
    }
    
    public void setIdeq(String id) {
        this.ideq = id;
    }
    
    
    
}
