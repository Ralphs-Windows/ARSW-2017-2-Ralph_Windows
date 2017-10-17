package edu.eci.arsw.RalphWindows.controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.ConcurrentHashMap;
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
public class RalphSTOMPMessagesHandlerController{

    @Autowired
    SimpMessagingTemplate msgt;
    ConcurrentHashMap<String,ConcurrentLinkedQueue<String>> idrooms=new ConcurrentHashMap<>();
    @MessageMapping("/rooms")
    public void getSalas() throws Exception {
        System.err.println("nuevo usuario suscrito a las salas");
        ConcurrentLinkedQueue a=new ConcurrentLinkedQueue<>();a.add("dgsg");
        idrooms.put("prueba1",a);
        msgt.convertAndSend("/topic/rooms",idrooms.keySet());
    }
    
    @MessageMapping("/room.{id}")
    public void getSalas(@DestinationVariable String id,String name) throws Exception {
        System.err.println("nuevo usuario suscrito a la sala "+ id);
        if (!idrooms.containsKey(id)) {
            idrooms.put(id, new ConcurrentLinkedQueue<>());
        }
        idrooms.get(id).add(name);
        synchronized(msgt){
            msgt.convertAndSend("/topic/room."+id,idrooms.get(id));
            if (idrooms.get(id).size()== 2) {
                msgt.convertAndSend("/topic/newpartida."+id, idrooms.get(id));
                idrooms.remove(id);
            }
        }
    }
}
