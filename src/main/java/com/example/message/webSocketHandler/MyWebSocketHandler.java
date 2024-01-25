package com.example.message.webSocketHandler;

import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import ch.qos.logback.classic.Logger;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws")
@CrossOrigin(origins = "http://localhost:5173")
@Component
@Controller
public class MyWebSocketHandler extends TextWebSocketHandler {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

//	@MessageMapping("/chat")
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        // WebSocket 메시지 수신 시 처리 로직을 작성
//        String payload = message.getPayload();
//        // ... 처리 로직 작성 ...
//        session.sendMessage(new TextMessage("Hello, " + payload + "!"));
//        logger.info("연결됐니");
//        System.out.println("WebSocket 연결 확인");
//    }
    
//    @OnOpen
//    public void onOpen(Session session) {
//        // 클라이언트가 연결되었을 때의 동작
//    	logger.info("서버오픈");
//    	System.out.println("gasdasd");
//    }
//
//    @OnClose
//    public void onClose(Session session) {
//        // 클라이언트가 연결을 종료했을 때의 동작
//    	logger.info("서버닫힘");
//    }
//
//    @OnError
//    public void onError(Throwable error) {
//        // 에러가 발생했을 때의 동작
//    	logger.info("서버에러");
//    }
//    
//    @OnMessage
//    public void onMessage(String message, Session session) {
//        // 클라이언트로부터 메시지를 받았을 때의 동작
//        logger.info("Received message: " + message);
//        // ... 처리 로직 작성 ...
//    }
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        logger.info("WebSocket 연결 성공");
        logger.info("세션::{}",session);
        String message = "안녕하세요. WebSocket 연결이 성공했습니다!";
        session.sendMessage(new TextMessage(message));
    }
    
//    @MessageMapping("/sendMessage")
//    @SendTo("/topic/receiveMessage")
//    public String sendMessage(String message) {
//        System.out.println("클라이언트로부터 메시지 수신: " + message);
//        return "서버에서 보낸 응답: " + message;
//    }
    
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        logger.error("WebSocket Transport Error", exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("WebSocket 연결 종료");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
    
    @Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		if (message instanceof TextMessage textMessage) {
			handleTextMessage(session, textMessage);
		}
		else if (message instanceof BinaryMessage binaryMessage) {
			handleBinaryMessage(session, binaryMessage);
		}
		else if (message instanceof PongMessage pongMessage) {
			handlePongMessage(session, pongMessage);
		}
		else {
			throw new IllegalStateException("Unexpected WebSocket message type: " + message);
		}
	}
    
}