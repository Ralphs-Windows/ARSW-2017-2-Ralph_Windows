/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.controller;
/**
 *
 * @author Laura RB
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class RalphWindowsWebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Value("${relayHost}")
    private String relayHost;
    
    @Value("${relayPort}")
    private String relayPort;
    
    @Value("${userCloud}")
    private String user;
    
    @Value("${passwordCloud}")
    private String password;
    
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        /*config.enableSimpleBroker("/topic");*/
        config.enableStompBrokerRelay("/topic").setRelayHost(relayHost).setRelayPort(Integer.parseInt(relayPort)).
                setClientLogin(user).
                setClientPasscode(password).
                setSystemLogin(user).
                setSystemPasscode(password).
                setVirtualHost(user);
        config.setApplicationDestinationPrefixes("/app");        
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /*registry.addEndpoint("/stompendpoint").withSockJS();*/
        registry.addEndpoint("/stompendpoint").setAllowedOrigins("*").withSockJS();
        
    }
    

}