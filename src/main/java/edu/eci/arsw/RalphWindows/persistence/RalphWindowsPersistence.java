/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.persistence;

import edu.eci.arsw.RalphWindows.model.Tuple;
import java.util.ArrayList;

/**
 *
 * @author laura
 */
public interface RalphWindowsPersistence {
    /**
     * Retorna una tupla con los estados inciales d ela ventanas
     * @return 
     * @throws edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException
     **/
    public Tuple[][] getMapajuego() throws RalphWindowsPersistenceException;
    
    /**Retorna las Salas de juego disponibles donde aun no hay 4 jugadores
     * @return 
     * @throws edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException**/
    public ArrayList getSalasJuegoDisponibles() throws RalphWindowsPersistenceException;
}
