/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.model;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author laura
 */
public class Equipo {
    private String ideq;
    private int puntos=0;
    private int vida=3;
    private ConcurrentHashMap<Integer,Felix> felixs;
    
    public Equipo(String id) {
        ideq=id;
        felixs=new ConcurrentHashMap<>();
    }
    
    public Equipo() {
        felixs=new ConcurrentHashMap<>();
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

    public ConcurrentHashMap<Integer,Felix> getFelixs() {
        return felixs;
    }

    public void setFelixs(ConcurrentHashMap<Integer,Felix> js) {
        this.felixs = js;
    }

    public String getIdeq() {
        return ideq;
    }
    
    public void setIdeq(String id) {
        this.ideq = id;
    }
    
    
    
}
