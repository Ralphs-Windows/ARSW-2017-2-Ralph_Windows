/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.services;

/**
 *
 * @author laura
 */
public class RalphWindowsException extends Exception{
    public RalphWindowsException(String message) {
        super(message);
    }

    public RalphWindowsException(String message, Throwable cause) {
        super(message, cause);
    }
}
