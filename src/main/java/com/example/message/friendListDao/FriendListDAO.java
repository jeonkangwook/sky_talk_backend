package com.example.message.friendListDao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.message.friendListDto.FriendListDTO;
import com.example.message.friendListDto.FriendProfileDTO;
import com.example.message.userDto.UserDTO;

@Mapper
public interface FriendListDAO {
	

	List<FriendProfileDTO> list(int userNo);

	FriendProfileDTO findFriend(String param);

	int addFriend(int myUserNo, int friUserNo);

	void friSetting(int code, int userNo, int friNo);

	List<FriendProfileDTO> friStat(int userNo);


}
