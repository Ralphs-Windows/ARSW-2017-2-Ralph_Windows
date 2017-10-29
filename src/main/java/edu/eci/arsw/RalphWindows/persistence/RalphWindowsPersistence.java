/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.persistence;

import edu.eci.arsw.RalphWindows.model.Jugador;
import edu.eci.arsw.RalphWindows.model.Mapa;
import edu.eci.arsw.RalphWindows.model.SalaJuego;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 *
 * @author laura
 */
public interface RalphWindowsPersistence {

    /**
     * Retorna una tupla con los estados inciales de las ventanas
     *
     * @param idsala el mapa correspondiente a esa sala ya que las ventanas son creadas aleatoriamente
     * @return retorna un mapa de las ventanas
     * @throws
     * edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException
     *
     */
    public Mapa getMapajuego(int idsala) throws RalphWindowsPersistenceException;
    
    /**
     * Cambia las posiciones de las ventanas respectivamente a la parte visual
     *
     * @param juegonum
     * @param mp
     * @throws
     * edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException
     */
    public void setMapajuego(int juegonum, Mapa mp) throws RalphWindowsPersistenceException;
    /**
     * Retorna el equipo1 de la sala de juego
     *
     * @param juegonum la id de la sala correspondiente
     * @return 
     * @throws edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException
     */
    public ConcurrentLinkedDeque getEquipoFelix1(int juegonum) throws RalphWindowsPersistenceException;
    /**
     * Retorna el equipo2 de la sala de juego
     *
     * @param juegonum la id de la sala correspondiente
     * @return 
     * @throws edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException
     */
    public ConcurrentLinkedDeque getEquipoFelix2(int juegonum) throws RalphWindowsPersistenceException;
    /**
     * RegistrarJugadorEquipoFelix2 a la sala de juego
     *
     * @param juegonum la id de la sala correspondiente
     * @param p El nuevo jugador a registrar
     * @throws edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException
     */
    public void registrarJugadorEquipoFelix1(int juegonum, Jugador p) throws RalphWindowsPersistenceException;
    /**
     * RegistrarJugadorEquipoFelix2 a la sala de juego
     *
     * @param juegonum la id de la sala correspondiente
     * @param p El nuevo jugador a registrar
     * @throws edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException
     */
    public void registrarJugadorEquipoFelix2(int juegonum, Jugador p) throws RalphWindowsPersistenceException;
    /**
     * Retorna la sala de juego disponible actual para registrar jugadores
     *
     * @return  el id de la sala disponible
     * @throws edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException
     */
    public int getSalaDisponible() throws RalphWindowsPersistenceException;
    /**
     * Cambia la sala disponible actual
     *
     * @param sala 
     * @throws edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException
     */
    public void setSalaDisponible(int sala) throws RalphWindowsPersistenceException;

     /**
     * Retorna la sala de juego disponible actual para registrar jugadores
     *
     * @param id
     * @return  el id de la sala disponible
     * @throws edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException
     */
    public SalaJuego getSalas(int id) throws RalphWindowsPersistenceException;
}
