/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.persistence.cache;


import edu.eci.arsw.RalphWindows.model.*;
import edu.eci.arsw.RalphWindows.persistence.stub.RalphWindowsPersistenceException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author laura
 */
@Service
public class LogicaJuegoCache {
    @Autowired
    RalphWindowsPersistenceCache rph=null;
    @Autowired
    SimpMessagingTemplate msgt;
    @Autowired
    StringRedisTemplate template;
    
    /**
     * 
     * @param template
     */
    public LogicaJuegoCache(StringRedisTemplate template) {
    }
    /**
     * 
     * @param id
     * @param f
     * @return 
     * @throws edu.eci.arsw.RalphWindows.persistence.stub.RalphWindowsPersistenceException 
     */
    public ArrayList<Equipo> mover(int id,Felix f) throws RalphWindowsPersistenceException{
       
        return null;
    }
    /**
     * 
     * @param id
     * @param jg
     * @throws edu.eci.arsw.RalphWindows.persistence.stub.RalphWindowsPersistenceException 
     */
    public void reparar(int id,Felix jg) throws RalphWindowsPersistenceException {
         
    }
    /**
     * 
     * @param id
     * @return 
     * @throws edu.eci.arsw.RalphWindows.persistence.stub.RalphWindowsPersistenceException 
     */
    public boolean terminar(int id)throws RalphWindowsPersistenceException {
        return true;
    }
    
    /**
     * 
     * @param id
     * @return 
     * @throws edu.eci.arsw.RalphWindows.persistence.stub.RalphWindowsPersistenceException 
     */
    public ArrayList<Equipo> infoWinner(int id)throws RalphWindowsPersistenceException {
        return null;
    }
    
    /**
     * 
     * @param id
     * @param f
     * @return 
     * @throws edu.eci.arsw.RalphWindows.persistence.stub.RalphWindowsPersistenceException 
     */
    public ArrayList information(int id,Felix f) throws RalphWindowsPersistenceException {
       
        return null;
    }
    
}
