/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.controller;

import edu.eci.arsw.RalphWindows.game.LogicaJuegoStub;
import edu.eci.arsw.RalphWindows.model.Felix;
import edu.eci.arsw.RalphWindows.model.Jugador;
import edu.eci.arsw.RalphWindows.model.Mapa;
import edu.eci.arsw.RalphWindows.model.ventana;
import edu.eci.arsw.RalphWindows.persistence.stub.RalphWindowsPersistenceException;
import edu.eci.arsw.RalphWindows.services.RalphWindowsException;
import edu.eci.arsw.RalphWindows.services.RalphWindowsService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author laura
 */
@RestController
@RequestMapping(value = "/juego")
public class RalphWindowsRESTController {

    @Autowired
    RalphWindowsService RalphServices;

    @Autowired
    SimpMessagingTemplate msgt;
    
    @Autowired
    LogicaJuegoStub log=null;
    
    @RequestMapping(path = "/{juegonum}/mapajuego", method = RequestMethod.GET)
    public ResponseEntity<?> getMapa(@PathVariable String juegonum) {
        synchronized (RalphServices) {
        try {
            return new ResponseEntity<>(RalphServices.getMapajuego(Integer.parseInt(juegonum)),HttpStatus.ACCEPTED);
        } catch (RalphWindowsPersistenceException ex) {
            Logger.getLogger(RalphWindowsRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error no se ecuentra la sala"+juegonum, HttpStatus.BAD_REQUEST);
        }}
    }
    
    @RequestMapping(path = "/puntaje", method = RequestMethod.GET)
    public ResponseEntity<?> getPuntaje() {
        synchronized (RalphServices) {
        try {
            return new ResponseEntity<>(RalphServices.getPuntajesJugadores(),HttpStatus.ACCEPTED);
        } catch (RalphWindowsPersistenceException ex) {
            Logger.getLogger(RalphWindowsRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error al devolver puntajes", HttpStatus.BAD_REQUEST);
        }
        }
    }
    @RequestMapping(path = "/newjugador", method = RequestMethod.POST)
    public ResponseEntity<?> newJugador(@RequestBody Jugador j) {
        synchronized (RalphServices) {
            try {
                if (RalphServices.getPerfil(j.getUsername()) == null) {
                    RalphServices.newUser(j);
                    return new ResponseEntity<>(HttpStatus.ACCEPTED);
                }else{
                     return new ResponseEntity<>("Error al crear usuario",HttpStatus.BAD_REQUEST);
                }
            } catch (RalphWindowsPersistenceException ex) {
                Logger.getLogger(RalphWindowsRESTController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>("Error al crear usuario",HttpStatus.BAD_REQUEST);
            }
            
        }
    }
    @RequestMapping(path = "/perfiluser/{nombre}", method = RequestMethod.GET)
    public ResponseEntity<?> getPerfil(@PathVariable String nombre) {
        synchronized (RalphServices) {
        try {
            return new ResponseEntity<>(RalphServices.getPerfil(nombre),HttpStatus.ACCEPTED);
        } catch (RalphWindowsPersistenceException ex) {
            Logger.getLogger(RalphWindowsRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error al devolver puntajes", HttpStatus.BAD_REQUEST);
        }
        }
    }
    @RequestMapping(path = "/user/{nombre}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable String nombre) {
        synchronized (RalphServices) {
        try {
            if(RalphServices.getPerfil(nombre)==null){
                return new ResponseEntity<>("Error al devolver puntajes", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (RalphWindowsPersistenceException ex) {
            Logger.getLogger(RalphWindowsRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error al devolver puntajes", HttpStatus.BAD_REQUEST);
        }
        }
    }
    
    @RequestMapping(path = "/{juegonum}/updatemapajuego", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMapa(@PathVariable String juegonum,@RequestBody Mapa mp) {
        try {
            RalphServices.getMapajuego(Integer.parseInt(juegonum)).setVentanas(mp.getVentanas());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (RalphWindowsPersistenceException ex) {
            Logger.getLogger(RalphWindowsRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error no se ecuentra la sala"+juegonum,HttpStatus.BAD_REQUEST);
        }
    }
    
        
    @RequestMapping(path = "/{juegonum}/equipo1", method = RequestMethod.PUT)
    public ResponseEntity<?> agregarEquipo1(@PathVariable String juegonum, @RequestBody Jugador p) throws RalphWindowsException, RalphWindowsPersistenceException {
        synchronized (RalphServices) {
            try {
                if (RalphServices.getEquipoFelix1(Integer.parseInt(juegonum)).size() < 1) {
                    RalphServices.registrarJugadorFelix1(Integer.parseInt(juegonum), p);
                    ConcurrentLinkedDeque<Jugador> equipo1 = RalphServices.getEquipoFelix1(Integer.parseInt(juegonum));
                    ConcurrentLinkedDeque<Jugador> equipo2 = RalphServices.getEquipoFelix2(Integer.parseInt(juegonum));
                 

                    if (equipo2.size() == 1 && equipo1.size() == 1) {
                        RalphServices.setSalaDisponible(RalphServices.getSalaDisponible() + 1);
                        RalphServices.setSalaDisponible(2);
                    }
                    msgt.convertAndSend("/topic/equipo1."+juegonum, equipo1);
                    msgt.convertAndSend("/topic/juego."+juegonum,equipo1.size()+equipo2.size()==2);
                } else {
                    throw new RalphWindowsException("No se puede elegir el equipo 1 porque está lleno");
                }

            } catch (RalphWindowsException ex) {
                Logger.getLogger(RalphWindowsRESTController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
    }

    @RequestMapping(path = "/{juegonum}/equipo2", method = RequestMethod.PUT)
    public ResponseEntity<?> agregarEquipo2(@PathVariable String juegonum, @RequestBody Jugador p) throws RalphWindowsException, RalphWindowsPersistenceException {
        synchronized (RalphServices) {
            try {
                if (RalphServices.getEquipoFelix2(Integer.parseInt(juegonum)).size() < 1) {
                    RalphServices.registrarJugadorFelix2(Integer.parseInt(juegonum), p);
                    ConcurrentLinkedDeque<Jugador> equipo1 = RalphServices.getEquipoFelix1(Integer.parseInt(juegonum));
                    ConcurrentLinkedDeque<Jugador> equipo2 = RalphServices.getEquipoFelix2(Integer.parseInt(juegonum));
                    

                    if (equipo2.size() == 1 && equipo1.size() == 1) {
                        RalphServices.setSalaDisponible(RalphServices.getSalaDisponible() + 1);
                        RalphServices.setSalaDisponible(2);
                    }
                    msgt.convertAndSend("/topic/equipo2."+juegonum, equipo2);
                    msgt.convertAndSend("/topic/juego."+juegonum, equipo1.size()+equipo2.size()==2);
                } else {
                    throw new RalphWindowsException("No se puede elegir el equipo 2 porque está lleno");
                }

            } catch (RalphWindowsException ex) {
                Logger.getLogger(RalphWindowsRESTController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(path = "/{juegonum}/equipo1", method = RequestMethod.GET)
    public ResponseEntity<?> getEquipo1(@PathVariable String juegonum) {

        try {
            return new ResponseEntity<>(RalphServices.getEquipoFelix1(Integer.parseInt(juegonum)), HttpStatus.ACCEPTED);
        } catch (RalphWindowsPersistenceException ex) {
            Logger.getLogger(RalphWindowsRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        } catch (NumberFormatException ex) {
            Logger.getLogger(RalphWindowsRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("/{juegonum}/ debe ser un valor numerico.", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/{juegonum}/equipo2", method = RequestMethod.GET)
    public ResponseEntity<?> getEquipo2(@PathVariable String juegonum) {

        try {
            return new ResponseEntity<>(RalphServices.getEquipoFelix2(Integer.parseInt(juegonum)), HttpStatus.ACCEPTED);
        } catch (RalphWindowsPersistenceException ex) {
            Logger.getLogger(RalphWindowsRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        } catch (NumberFormatException ex) {
            Logger.getLogger(RalphWindowsRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("/{juegonum}/ debe ser un valor numerico.", HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(path = "/Sala", method = RequestMethod.GET)
    public ResponseEntity<?> getSalaDisponible() {

        try {
            return new ResponseEntity<>(RalphServices.getSalaDisponible(), HttpStatus.ACCEPTED);
        } catch (RalphWindowsPersistenceException ex) {
            Logger.getLogger(RalphWindowsRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Hay un error al llamar al metodo get de sala disponible", HttpStatus.BAD_REQUEST);
        }
    }
    
}
