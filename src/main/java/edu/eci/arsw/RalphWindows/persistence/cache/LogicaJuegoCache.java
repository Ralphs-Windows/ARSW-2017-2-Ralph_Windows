/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.persistence.cache;


import edu.eci.arsw.RalphWindows.model.*;
import edu.eci.arsw.RalphWindows.persistence.stub.RalphWindowsPersistenceException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author laura
 */
@Service
public class LogicaJuegoCache {
    
    private StringRedisTemplate template;
    private String id;
    
    /**
     * 
     * @param template
     */
    public  LogicaJuegoCache()  {
    }
    
    public LogicaJuegoCache(int id,StringRedisTemplate template) {
        this.id="juego:"+id;
        this.template=template;
    }
    
    /**
     * 
     * @param f
     * @return 
     * @throws edu.eci.arsw.RalphWindows.persistence.stub.RalphWindowsPersistenceException 
     */
    public ArrayList<Equipo> mover(Felix f) throws RalphWindowsPersistenceException{
       
        return null;
    }
    /**
     * 
     * @param jg
     * @throws edu.eci.arsw.RalphWindows.persistence.stub.RalphWindowsPersistenceException 
     */
    public void reparar(Felix jg) throws RalphWindowsPersistenceException {
         
    }
    /**
     * 
     * @return 
     * @throws edu.eci.arsw.RalphWindows.persistence.stub.RalphWindowsPersistenceException 
     */
    public boolean terminar()throws RalphWindowsPersistenceException {
        return true;
    }
    
    /**
     * 
     * @return 
     * @throws edu.eci.arsw.RalphWindows.persistence.stub.RalphWindowsPersistenceException 
     */
    public ArrayList<Equipo> infoWinner()throws RalphWindowsPersistenceException {
        return null;
    }
    
    /**
     * 
     * @param f
     * @return 
     * @throws edu.eci.arsw.RalphWindows.persistence.stub.RalphWindowsPersistenceException 
     */
    public ArrayList information(Felix f) throws RalphWindowsPersistenceException {
       
        return null;
    }
    
    public Mapa getMapajuego() throws RalphWindowsPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMapajuego( Mapa mp) throws RalphWindowsPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getEquipoFelix1() throws RalphWindowsPersistenceException {
        List value=(List<String>)template.opsForHash().get(id, "equipoFelix:1");
        return value;
    }

    public List getEquipoFelix2() throws RalphWindowsPersistenceException {
        List value=(List<String>)template.opsForHash().get(id, "equipoFelix:2");
        return value;
    }

    public void registrarEquipoFelix1(Jugador p) throws RalphWindowsPersistenceException {
        List num=(List<String>)template.opsForHash().get(id, "equipoFelix:1");
        template.opsForHash().put(id+"equipoFelix:1 jugador:"+String.valueOf(num.size()),"nombre",p.getUsername());
        template.opsForHash().put(id+"equipoFelix:1 jugador:"+String.valueOf(num.size()),"score",p.getScore());
        
        
    }

    public void registrarEquipoFelix2(Jugador p) throws RalphWindowsPersistenceException {
        List num=(List<String>)template.opsForHash().get(id, "equipoFelix:2");
        template.opsForHash().put(id+"equipoFelix:2 jugador:"+String.valueOf(num.size()),"nombre",p.getUsername());
        template.opsForHash().put(id+"equipoFelix:2 jugador:"+String.valueOf(num.size()),"score",p.getScore());
    }
    
}
