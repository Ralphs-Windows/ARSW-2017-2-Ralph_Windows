/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.persistence;

/**
 *
 * @author laura
 */
public class RalphWindowsPersistenceException extends Exception{
    public RalphWindowsPersistenceException(String message) {
        super(message);
    }

    public RalphWindowsPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
