/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.STOMP;


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
    
    @MessageMapping("")
    public void getSalas(@DestinationVariable int d) throws Exception {
        
    }
    
    
}
