/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.controller;

import edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException;
import edu.eci.arsw.RalphWindows.services.RalphWindowsService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    @RequestMapping(path = "/mapaJuego",method = RequestMethod.GET)
    public ResponseEntity<?> getMapa() {
        try {System.out.println("");
            return new ResponseEntity<>(RalphServices.getMapajuego(),HttpStatus.ACCEPTED);
        } catch (NumberFormatException|RalphWindowsPersistenceException ex){
            Logger.getLogger(RalphWindowsRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("error al cargar mapa",HttpStatus.BAD_REQUEST);
        }
    }  
    
}
