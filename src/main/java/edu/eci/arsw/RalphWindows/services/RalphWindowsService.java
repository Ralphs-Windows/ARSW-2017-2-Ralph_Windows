/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.services;

import edu.eci.arsw.RalphWindows.model.Jugador;
import edu.eci.arsw.RalphWindows.model.Mapa;
import edu.eci.arsw.RalphWindows.persistence.cache.JuegoCacheRedis;
import edu.eci.arsw.RalphWindows.persistence.cache.JugadoresMongoDB;
import edu.eci.arsw.RalphWindows.persistence.stub.RalphWindowsPersistence;
import edu.eci.arsw.RalphWindows.persistence.stub.RalphWindowsPersistenceException;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author laura
 */
@Service
public class RalphWindowsService {

    @Autowired
    private RalphWindowsPersistence ralphpersistence = null;
    
    @Autowired
    private JuegoCacheRedis juegoredis = null;
    
    //repositorios (capa de persistencia)
    @Autowired
    private JugadoresMongoDB jugadores;
    
    @Autowired
    private MongoTemplate mt;

    public Mapa getMapajuego(int juegonum) throws RalphWindowsPersistenceException {
        return ralphpersistence.getMapajuego(juegonum);
    }
    public void setMapajuego(int juegonum,Mapa mp) throws RalphWindowsPersistenceException {
        ralphpersistence.setMapajuego(juegonum,mp);
    }
    public ConcurrentLinkedDeque getEquipoFelix1(int juegonum) throws RalphWindowsPersistenceException {
        return ralphpersistence.getEquipoFelix1(juegonum);
    }

    public ConcurrentLinkedDeque getEquipoFelix2(int juegonum) throws RalphWindowsPersistenceException {
        return ralphpersistence.getEquipoFelix2(juegonum);
    }

    public void registrarJugadorFelix1(int juegonum, Jugador p) throws RalphWindowsPersistenceException {
        ralphpersistence.registrarJugadorEquipoFelix1(juegonum, p);
    }

    public void registrarJugadorFelix2(int juegonum, Jugador p) throws RalphWindowsPersistenceException {
        ralphpersistence.registrarJugadorEquipoFelix2(juegonum, p);
    }
    
    public int getSalaDisponible() throws RalphWindowsPersistenceException {
        //juegoredis.getSalaDisponible();
        return ralphpersistence.getSalaDisponible();
    }
    
    public void setSalaDisponible(int sala) throws RalphWindowsPersistenceException {
        //juegoredis.createSala();
        ralphpersistence.setSalaDisponible(sala);

    }
    /*MongoDB*/
    public void newUser(Jugador j) throws RalphWindowsPersistenceException{
        mt.insert(j,"jugadores");
    }
    public List<Jugador> getPuntajesJugadores() throws RalphWindowsPersistenceException {
        return jugadores.findByScore(1000);
    }
    public Jugador getPerfil(String nombre) throws RalphWindowsPersistenceException {
        return jugadores.findByUsername(nombre);
    }

}
