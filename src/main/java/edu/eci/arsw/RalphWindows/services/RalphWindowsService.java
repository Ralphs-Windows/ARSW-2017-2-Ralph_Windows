/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.services;

import edu.eci.arsw.RalphWindows.model.Tuple;
import edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistence;
import edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author laura
 */
@Service
public class RalphWindowsService {
    
    @Autowired
    RalphWindowsPersistence ralphpersistence=null;
    
    public Tuple [][] getMapajuego() throws RalphWindowsPersistenceException{
        return ralphpersistence.getMapajuego();
    }
    
}
