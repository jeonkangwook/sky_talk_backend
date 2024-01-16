package com.example.message.corsConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;

import com.example.message.webSocketHandler.MyWebSocketHandler;

@Configuration
@EnableWebMvc
@EnableWebSocket
public class CorsConfig  implements WebMvcConfigurer, WebSocketConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:5173") // 클라이언트 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
        
        registry.addMapping("/ws/**") // WebSocket 엔드포인트에 대한 CORS 구성 추가
        .allowedOrigins("ws://localhost:8080")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowCredentials(true);
    }
    
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // MyWebSocketHandler 클래스는 실제로 사용 중인 WebSocketHandler에 맞게 변경
        registry.addHandler(new MyWebSocketHandler(), "/ws")
                .setAllowedOrigins("http://localhost:5173"); // 클라이언트 주소
//                .withSockJS(); // SockJS를 사용하는 경우에 필요
    }
    
    
}