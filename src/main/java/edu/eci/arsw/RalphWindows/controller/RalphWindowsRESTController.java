/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.controller;

import edu.eci.arsw.RalphWindows.model.Jugador;
import edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException;
import edu.eci.arsw.RalphWindows.services.RalphWindowsException;
import edu.eci.arsw.RalphWindows.services.RalphWindowsService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(path = "/mapaJuego", method = RequestMethod.GET)
    public ResponseEntity<?> getMapa() {
        try {
            System.out.println("");
            return new ResponseEntity<>(RalphServices.getMapajuego(), HttpStatus.ACCEPTED);
        } catch (NumberFormatException | RalphWindowsPersistenceException ex) {
            Logger.getLogger(RalphWindowsRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("error al cargar mapa", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/{juegonum}/equipo1", method = RequestMethod.PUT)
    public ResponseEntity<?> agregarEquipo1(@PathVariable(name = "juegonum") String juegonum, @RequestBody Jugador p) throws RalphWindowsException, RalphWindowsPersistenceException {
        synchronized (RalphServices) {
            try {
                if (RalphServices.getEquipoFelix1(Integer.parseInt(juegonum)).size() < 1) {
                    RalphServices.registrarJugadorFelix1(Integer.parseInt(juegonum), p);
                    ArrayList<List<Jugador>> temp = new ArrayList<>();
                    List<Jugador> equipo1 = RalphServices.getEquipoFelix1(Integer.parseInt(juegonum));
                    List<Jugador> equipo2 = RalphServices.getEquipoFelix2(Integer.parseInt(juegonum));
                    temp.add(equipo1);
                    temp.add(equipo2);

                    if (equipo2.size() == 1 && equipo1.size() == 1) {
                        RalphServices.setSalaDisponible(RalphServices.getSalaDisponible() + 1);
                    }
                    msgt.convertAndSend("/topic/mostrarJugadores", temp);
                } else {
                    throw new RalphWindowsException("No se puede elegir el equipo 1 porque está lleno");
                }

            } catch (RalphWindowsException ex) {
                Logger.getLogger(RalphWindowsRESTController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(path = "/{juegonum}/equipo2", method = RequestMethod.PUT)
    public ResponseEntity<?> agregarEquipo2(@PathVariable(name = "juegonum") String juegonum, @RequestBody Jugador p) throws RalphWindowsException, RalphWindowsPersistenceException {
        synchronized (RalphServices) {
            try {
                if (RalphServices.getEquipoFelix2(Integer.parseInt(juegonum)).size() < 1) {
                    RalphServices.registrarJugadorFelix2(Integer.parseInt(juegonum), p);
                    ArrayList<List<Jugador>> temp = new ArrayList<>();
                    List<Jugador> equipo1 = RalphServices.getEquipoFelix1(Integer.parseInt(juegonum));
                    List<Jugador> equipo2 = RalphServices.getEquipoFelix2(Integer.parseInt(juegonum));
                    temp.add(equipo1);
                    temp.add(equipo2);

                    if (equipo2.size() == 1 && equipo1.size() == 1) {
                        RalphServices.setSalaDisponible(RalphServices.getSalaDisponible() + 1);
                    }
                    msgt.convertAndSend("/topic/mostrarJugadores", temp);
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
    public ResponseEntity<?> getEquipo1(@PathVariable(name = "juegonum") String juegonum) {

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
    public ResponseEntity<?> getEquipo2(@PathVariable(name = "juegonum") String juegonum) {

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

}
