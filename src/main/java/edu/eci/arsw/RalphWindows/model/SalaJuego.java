/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.model;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author laura
 */
public class SalaJuego {
    private Integer id;
    private CopyOnWriteArrayList<Jugador> equipo1;
    private CopyOnWriteArrayList<Jugador> equipo2;
    
    public SalaJuego(Integer id,CopyOnWriteArrayList<Jugador> eq1,CopyOnWriteArrayList<Jugador> eq2) {
        equipo1=eq1;
        equipo2=eq2;
    };
    public SalaJuego(){
        equipo1=new CopyOnWriteArrayList();
        equipo2=new CopyOnWriteArrayList();
    };
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CopyOnWriteArrayList<Jugador> getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(CopyOnWriteArrayList<Jugador> equipo1) {
        this.equipo1 = equipo1;
    }

    public CopyOnWriteArrayList<Jugador> getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(CopyOnWriteArrayList<Jugador> equipo2) {
        this.equipo2 = equipo2;
    }

}
