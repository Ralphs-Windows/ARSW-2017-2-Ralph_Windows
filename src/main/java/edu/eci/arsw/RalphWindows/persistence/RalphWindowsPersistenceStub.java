/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.persistence;

import edu.eci.arsw.RalphWindows.model.Jugador;
import edu.eci.arsw.RalphWindows.model.Mapa;
import edu.eci.arsw.RalphWindows.model.SalaJuego;
import edu.eci.arsw.RalphWindows.model.Tuple;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.springframework.stereotype.Service;

/**
 *
 * @author laura
 */
@Service
public class RalphWindowsPersistenceStub implements RalphWindowsPersistence{
    private ConcurrentHashMap<String,SalaJuego> salas;
    public RalphWindowsPersistenceStub(){
        salas=new ConcurrentHashMap<>();
        ConcurrentLinkedDeque<Jugador> eq1=new ConcurrentLinkedDeque<>();
        ConcurrentLinkedDeque<Jugador> eq2=new ConcurrentLinkedDeque<>();
        ConcurrentLinkedDeque<Jugador> eq11=new ConcurrentLinkedDeque<>();
        Jugador j1=new Jugador("Laura");
        Jugador j2=new Jugador("Laura2");
        Jugador j3=new Jugador("Laura3");
        Jugador j4=new Jugador("Laura4");
        eq2.add(j2);eq1.add(j1);eq11.add(j4);eq11.add(j3);
        salas.put("Sala1",new SalaJuego());
        salas.put("Sala2",new SalaJuego("Sala2",eq1,eq2));
        salas.put("Sala1",new SalaJuego("sala3",eq11,new ConcurrentLinkedDeque<>()));
    }
    @Override
    public Tuple[][] getMapajuego() {
        return Mapa.dibujarMapa();
    }

    @Override
    public ArrayList getSalasJuegoDisponibles() throws RalphWindowsPersistenceException {
        return null;
    }
}
