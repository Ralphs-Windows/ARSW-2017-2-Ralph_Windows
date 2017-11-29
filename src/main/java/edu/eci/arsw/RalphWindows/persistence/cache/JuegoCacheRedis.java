/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.persistence.cache;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author laura
 */

@Service
public class JuegoCacheRedis {
    @Autowired
    private StringRedisTemplate template;
    
    public void createSala(){
        String salanum = "juego:"+template.getConnectionFactory().getConnection().dbSize().toString();
        System.out.println("ASKJBFDSBFJSGEBNOISGNDSGSHSHSHSADOOIFJJIFASJIS"+salanum);
        Map<byte[], byte[]> hash = new HashMap<>();
        hash.put("equipos".getBytes(), "".getBytes());
        hash.put("jug11".getBytes(), "".getBytes());
        hash.put("jug12".getBytes(), "".getBytes());
        hash.put("equipoFelix2".getBytes(), "".getBytes());
        hash.put("jug21".getBytes(), "".getBytes());
        hash.put("jug22".getBytes(), "".getBytes());
        template.getConnectionFactory().getConnection().hMSet(salanum.getBytes(), hash);
    };

    public LogicaJuegoCache getSala(int gameid){
        return new LogicaJuegoCache(gameid,template);
    };

    public int getSalaDisponible() {
        int val=template.getConnectionFactory().getConnection().dbSize().intValue();
        if(val==0){
            this.createSala();
        }
        return val;
    }
   
}
