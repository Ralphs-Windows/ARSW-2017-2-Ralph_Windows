/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.model;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 *
 * @author laura
 */
public class SalaJuego {
    private Integer id;
    private ConcurrentLinkedDeque<Jugador> equipo1;
    private ConcurrentLinkedDeque<Jugador> equipo2;
    private ventana[][] mapaventanas;
    
    public SalaJuego(Integer id,ConcurrentLinkedDeque<Jugador> eq1,ConcurrentLinkedDeque<Jugador> eq2) {
        equipo1=eq1;
        equipo2=eq2;
        mapaventanas=Mapa.dibujarMapa();
    };
    public SalaJuego(){
        equipo1=new ConcurrentLinkedDeque();
        equipo2=new ConcurrentLinkedDeque(); 
        mapaventanas=Mapa.dibujarMapa();
    };
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ConcurrentLinkedDeque<Jugador> getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(ConcurrentLinkedDeque<Jugador> equipo1) {
        this.equipo1 = equipo1;
    }

    public ConcurrentLinkedDeque<Jugador> getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(ConcurrentLinkedDeque<Jugador> equipo2) {
        this.equipo2 = equipo2;
    }

    public ventana[][] getMapaventanas() {
        return mapaventanas;
    }

    public void setMapaventanas(ventana[][] mapaventanas) {
        this.mapaventanas = mapaventanas;
    }
    
}
