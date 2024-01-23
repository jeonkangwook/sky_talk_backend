package com.example.message.chatService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.message.chatDao.ChatDao;
import com.example.message.chatDto.ChatDto;

@Service
public class ChatService {
	
	@Autowired
	ChatDao chatDao;

	public void chatSend(String content, int getUserNo, int sendUserNo) {
		chatDao.chatSend(content,getUserNo,sendUserNo);
		
	}

	public int chatRoom(int getUserNo, int sendUserNo) {
		return chatDao.chatRoom(getUserNo,sendUserNo);
	}

	public void createRoom(int getUserNo, int sendUserNo) {
		chatDao.createRoom(getUserNo,sendUserNo);
		
	}

	public ArrayList<ChatDto> chatList(int chatRoomNo) {
		return chatDao.chatList(chatRoomNo);
	}

	public int findChatRoom(int getUserNo, int sendUserNo) {
		return chatDao.findChatRoom(getUserNo,sendUserNo);
	}

	public ArrayList<ChatDto> chatRoomList(int userNo) {
		return chatDao.chatRoomList(userNo);
	}

	public void chatRead(int chatRoomNo, int userNo) {
		chatDao.chatRead(chatRoomNo,userNo);
		
	}

	public ArrayList<ChatDto> roomFind(int userNo) {
		return chatDao.roomFind(userNo);
	}

}
