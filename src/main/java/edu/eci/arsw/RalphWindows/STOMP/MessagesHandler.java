package edu.eci.arsw.RalphWindows.STOMP;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.ConcurrentLinkedQueue;
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
public class MessagesHandler{

    @Autowired
    SimpMessagingTemplate msgt;
    ConcurrentLinkedQueue<String> idrooms=new ConcurrentLinkedQueue<>();
    @MessageMapping("/rooms")
    public void getSalas() throws Exception {
        System.err.println("nuevo usuario suscrito a las salas");
        idrooms.add("prueba1");
        msgt.convertAndSend("/topic/rooms",idrooms);
    }
    
    @MessageMapping("/room.{name}")
    public void getSalas(@DestinationVariable String name) throws Exception {
        System.err.println("nuevo usuario suscrito a la sala"+ name);
        //msgt.convertAndSend("/topic/rooms",idrooms);
    }
    
    
}
