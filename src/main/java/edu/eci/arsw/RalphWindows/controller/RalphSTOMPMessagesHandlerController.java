package edu.eci.arsw.RalphWindows.controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.eci.arsw.RalphWindows.model.Felix;
import edu.eci.arsw.RalphWindows.model.LogicaJuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Laura RB
 */
@Controller
public class RalphSTOMPMessagesHandlerController{

    @Autowired
    SimpMessagingTemplate msgt;
    
    @Autowired
    LogicaJuego log=null;
    
    /*ConcurrentHashMap<String,LogicaJuego> idrooms=new ConcurrentHashMap<>();*/
    
    @MessageMapping("/juego/mover.{idsala}")
    public void mover(@DestinationVariable int idsala, Felix f) throws Exception {
        System.out.println("Mover a felix numero "+f.getNum()+" del equipo "+f.getEq());
        /*if (!idrooms.containsKey(idsala)) {
            idrooms.put(idsala, new LogicaJuego(Integer.parseInt(idsala)));
        }
        LogicaJuego log=idrooms.get(idsala);*/
        synchronized (msgt) {
            msgt.convertAndSend("/topic/juego/mover." + idsala, log.mover(idsala,f));
        }
    }

    @MessageMapping("/juego/reparar.{idsala}")
    public void getSalas(@DestinationVariable int idsala,Felix f) throws Exception {
        System.out.println("Felix numero "+f.getNum()+" repara la ventana");
        /*if (!idrooms.containsKey(idsala)) {
            idrooms.put(idsala, new LogicaJuego(Integer.parseInt(idsala)));
        }
        LogicaJuego log=idrooms.get(idsala);*/
        synchronized (msgt) {
            msgt.convertAndSend("/topic/juego/reparar." + idsala, log.reparar(idsala,f));
            msgt.convertAndSend("/topic/juego/informacion."+idsala+"/eq."+f.getEq(), log.information(idsala,f.getEq()));
            msgt.convertAndSend("/topic/juego/estadojuego."+idsala, log.terminar(idsala));
        }
    }
}
