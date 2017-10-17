
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.arsw.RalphWindows.model;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Laura Ramos
 */
public class Equipos {
    
    
    private CopyOnWriteArrayList <Jugador> equipo1 = new CopyOnWriteArrayList ();
    private CopyOnWriteArrayList <Jugador> equipo2 = new CopyOnWriteArrayList ();

    public Equipos() {
        
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
