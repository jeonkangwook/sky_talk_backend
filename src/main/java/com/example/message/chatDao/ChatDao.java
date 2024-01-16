package com.example.message.chatDao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.message.chatDto.ChatDto;

@Mapper
public interface ChatDao {

	void chatSend(String content, int getUserNo, int sendUserNo);

	int chatRoom(int getUserNo, int sendUserNo);

	void createRoom(int getUserNo, int sendUserNo);

	ArrayList<ChatDto> chatList(int chatRoomNo);

	int findChatRoom(int getUserNo, int sendUserNo);

}
