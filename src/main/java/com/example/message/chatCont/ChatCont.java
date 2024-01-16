package com.example.message.chatCont;

import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws")
//@CrossOrigin(origins = "http://localhost:5173")
@Controller
public class ChatCont {
	
	
	public class ChatController {
		
		org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

	    @MessageMapping("/ws")
	    @SendTo("/topic/chat")
	    public ChatMessage handleChatMessage(ChatMessage message) {
	    	logger.info("너는되니");
	        return message;
	    }
	}

}
