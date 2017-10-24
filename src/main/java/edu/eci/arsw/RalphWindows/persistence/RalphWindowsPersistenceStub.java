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
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author laura
 */
@Service
public class RalphWindowsPersistenceStub implements RalphWindowsPersistence {

    private ConcurrentHashMap<Integer, SalaJuego> DatosSalas;
    private int sala = 0;

    public RalphWindowsPersistenceStub() {
        DatosSalas = new ConcurrentHashMap<>();
        DatosSalas.put(0, new SalaJuego());
    }

    @Override
    public Tuple[][] getMapajuego() {
        return Mapa.dibujarMapa();
    }

    @Override
    public ArrayList getSalasJuegoDisponibles() throws RalphWindowsPersistenceException {
        return null;
    }

    @Override
    public void registrarJugadorEquipoFelix1(int juegonum, Jugador p) throws RalphWindowsPersistenceException {
        DatosSalas.get(juegonum).getEquipo1().add(p);

    }

    @Override
    public void registrarJugadorEquipoFelix2(int juegonum, Jugador p) throws RalphWindowsPersistenceException {
        DatosSalas.get(juegonum).getEquipo2().add(p);
    }

    @Override
    public ConcurrentLinkedDeque getEquipoFelix1(int juegonum) throws RalphWindowsPersistenceException {
        return DatosSalas.get(juegonum).getEquipo1();
    }

    @Override
    public ConcurrentLinkedDeque getEquipoFelix2(int juegonum) throws RalphWindowsPersistenceException {
        return DatosSalas.get(juegonum).getEquipo2();

    }

    @Override
    public int getSalaDisponible() throws RalphWindowsPersistenceException {
        return sala;
    }

    @Override
    public void setSalaDisponible(int sala) throws RalphWindowsPersistenceException {
        DatosSalas.put(sala, new SalaJuego());
        this.sala = sala;
    }

}
