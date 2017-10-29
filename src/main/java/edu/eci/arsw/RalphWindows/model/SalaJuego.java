/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.model;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 *
 * @author laura
 */
public class SalaJuego {
    private Integer id;
    private ConcurrentLinkedDeque<Jugador> equipo1;
    private ConcurrentLinkedDeque<Jugador> equipo2;
    private Mapa mapaventanas;
    private ConcurrentHashMap<String,Equipo> equipos;
    
    /**
     * 
     * @param id
     * @param eq1
     * @param eq2 
     */
    public SalaJuego(Integer id,ConcurrentLinkedDeque<Jugador> eq1,ConcurrentLinkedDeque<Jugador> eq2) {
        equipo1=eq1;
        equipo2=eq2;
        mapaventanas=new Mapa(Mapa.dibujarMapa());
        equipos=new ConcurrentHashMap<>();
    };
    /**
     * 
     */
    public SalaJuego(){
        equipo1=new ConcurrentLinkedDeque();
        equipo2=new ConcurrentLinkedDeque(); 
        mapaventanas=new Mapa(Mapa.dibujarMapa());
        equipos=new ConcurrentHashMap<>();
    };
    /**
     * 
     * @return 
     */   
    public Integer getId() {
        return id;
    }
    /**
     * 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * 
     * @return 
     */
    public ConcurrentLinkedDeque<Jugador> getEquipo1() {
        return equipo1;
    }
    /**
     * 
     * @param equipo1
     */
    public void setEquipo1(ConcurrentLinkedDeque<Jugador> equipo1) {
        this.equipo1 = equipo1;
    }
    /**
     * 
     * @return 
     */
    public ConcurrentLinkedDeque<Jugador> getEquipo2() {
        return equipo2;
    }
    /**
     * 
     * @param equipo2
     */
    public void setEquipo2(ConcurrentLinkedDeque<Jugador> equipo2) {
        this.equipo2 = equipo2;
    }
    /**
     * 
     * @return 
     */
    public Mapa getMapaJuego() {
        return mapaventanas;
    }
    /**
     * 
     * @param mapaventanas
     */
    public void setMapaJuego(Mapa mapaventanas) {
        this.mapaventanas = mapaventanas;
    }

    public ConcurrentHashMap<String, Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ConcurrentHashMap<String, Equipo> equipos) {
        this.equipos = equipos;
    }
    
    
}
