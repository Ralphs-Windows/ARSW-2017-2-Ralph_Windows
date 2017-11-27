package edu.eci.arsw.RalphWindows.controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.eci.arsw.RalphWindows.model.Felix;
import edu.eci.arsw.RalphWindows.persistence.cache.LogicaJuegoCache;
import edu.eci.arsw.RalphWindows.game.LogicaJuegoStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
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
    LogicaJuegoStub log=null;
    
    
    @MessageMapping("/mover.{idsala}")
    public void mover(@DestinationVariable int idsala, Felix f) throws Exception {
        System.out.println("Mover a felix numero "+f.getNum()+" del equipo "+f.getEq());
        synchronized (msgt) {
            /*Se envia informacion de todos los jugadores al moverse*/
            msgt.convertAndSend("/topic/juego-mover." + idsala, log.mover(idsala,f));
        }
    }

    @MessageMapping("/reparar.{idsala}")
    public void getSalas(@DestinationVariable int idsala,Felix f) throws Exception {
        /*System.out.println("Felix numero "+f.getNum()+" repara la ventana");*/
        synchronized (msgt) {
            /*Revisa si la ventana puede ser reparada*/
            log.reparar(idsala,f);
            /*Revisa si se repraron todas la ventanas*/
            
            if(log.terminar(idsala)){
                /*Si si se han reparado todas las ventanas, se envia informacion de fin de juego*/
                msgt.convertAndSend("/topic/juego-estadojuego."+idsala, log.infoWinner(idsala));
            }else{
                /*Si el juego aun no termina se envia informacion de puntos y vidas.*/
                msgt.convertAndSend("/topic/juego-informacion."+idsala+"eq."+f.getEq(), log.information(idsala,f));
            }
        }
    }
}
