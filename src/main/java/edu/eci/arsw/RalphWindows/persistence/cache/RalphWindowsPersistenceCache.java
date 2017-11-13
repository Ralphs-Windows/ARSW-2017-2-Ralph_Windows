/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.persistence.cache;

import edu.eci.arsw.RalphWindows.model.Jugador;
import edu.eci.arsw.RalphWindows.model.Mapa;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.springframework.stereotype.Service;

/**
 *
 * @author laura
 */
@Service
public class RalphWindowsPersistenceCache {


    public RalphWindowsPersistenceCache() {
    }

    public Mapa getMapajuego(int juegonum) throws RalphWindowsPersistenceCacheException {
        return null;
    }
    
    public void setMapajuego(int juegonum, Mapa m) {
        
    }
    
    public void registrarJugadorEquipoFelix1(int juegonum, Jugador p) throws RalphWindowsPersistenceCacheException {

    }

    public void registrarJugadorEquipoFelix2(int juegonum, Jugador p) throws RalphWindowsPersistenceCacheException {
    }

    public ConcurrentLinkedDeque getEquipoFelix1(int juegonum) throws RalphWindowsPersistenceCacheException {
        return null;
    }

    public ConcurrentLinkedDeque getEquipoFelix2(int juegonum) throws RalphWindowsPersistenceCacheException {
        return null;
    }

    public int getSalaDisponible() throws RalphWindowsPersistenceCacheException {
        return 0;
    }

    public void setSalaDisponible(int sala) throws RalphWindowsPersistenceCacheException {
       
    }
}
