package com.example.message.webSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import com.example.message.webSocketHandler.MyWebSocketHandler;

@Configuration
@EnableWebSocket
//@EnableWebSocketMessageBroker
@Controller
public class WebSocketConfig implements WebSocketConfigurer, WebSocketMessageBrokerConfigurer {

	@Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new MyWebSocketHandler(), "/ws/").setAllowedOriginPatterns("*");
    }

//    @Bean
//    public MyWebSocketHandler myWebSocketHandler() {
//        return new MyWebSocketHandler();
//    }
    
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws").
////        setAllowedOrigins("*").
//        setAllowedOriginPatterns("*");
////        withSockJS();
//    }
//    
//    
//    
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/topic");
//        config.setApplicationDestinationPrefixes("/app");
//    }
}
