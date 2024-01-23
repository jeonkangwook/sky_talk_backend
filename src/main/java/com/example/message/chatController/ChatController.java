package com.example.message.chatController;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.message.chatDto.ChatDto;
import com.example.message.chatService.ChatService;
import com.example.message.friendListDto.FriendProfileDTO;

//@ServerEndpoint("/ws")
@RestController
public class ChatController {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ChatService chatService;

	@ResponseBody
	@PostMapping("/api/chatSend")
	public int chatSend(@RequestBody ChatDto dto) {
		String content = dto.getContent();
		int getUserNo = dto.getUserNo();
		int sendUserNo = dto.getSendUserNo();
		logger.info("content::{}",content);
		logger.info("getUserNo::{}",getUserNo);
		logger.info("sendUserNo::{}",sendUserNo);
		int result = chatService.chatRoom(getUserNo,sendUserNo);
		if(result == 0) {
			chatService.createRoom(getUserNo,sendUserNo);
		}
		chatService.chatSend(content,getUserNo,sendUserNo);
		return result;
	}
	
	@GetMapping("/api/chatContent")
	public List<ChatDto> chatList(@RequestParam int chatRoomNo){
//		logger.info("chatRoomNo::{}",chatRoomNo);
		ArrayList<ChatDto> chatList = chatService.chatList(chatRoomNo);
//		logger.info("chatList::{}",chatList);
//		for (ChatDto chatDto : chatList) {
//			logger.info("chatList::{}",chatDto.getChatDtm());
//		}
		return chatList;
	}
	
	@GetMapping("/api/findChatRoom")
	public int findChatRoom (@RequestParam int getUserNo, @RequestParam int sendUserNo) {
		logger.info("getUserNo::{}",getUserNo);
		logger.info("sendUserNo::{}",sendUserNo);
		int result = chatService.findChatRoom(getUserNo,sendUserNo);
		logger.info("result::{}",result);
		if(result != 0) {
			return result;
		}else {
			result = 0;
		}
			
		return result;
	}
	 
	@GetMapping("/api/chatRoomList")
	public List<ChatDto> chatRoomList (@RequestParam int userNo){
		ArrayList<ChatDto> result = chatService.chatRoomList(userNo);
		return result;
	}
	
	@PostMapping("/api/chatRead")
	public void chatRead (@RequestBody ChatDto dto) {
		logger.info("너는 실행이 왜 안되니??");
		int chatRoomNo = dto.getChatRoomNo();
		int userNo = dto.getUserNo();
		logger.info("읽을떄chatRoomNo::{}",chatRoomNo);
		logger.info("읽을떄userNo::{}",userNo);
		
		chatService.chatRead(chatRoomNo,userNo);
	}
	

}
