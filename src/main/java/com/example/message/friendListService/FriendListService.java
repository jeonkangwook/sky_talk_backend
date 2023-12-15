package com.example.message.friendListService;

import java.util.HashMap;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.message.friendListDao.FriendListDAO;
import com.example.message.friendListDto.FriendProfileDTO;
import com.example.message.userDto.UserDTO;


@Service
public class FriendListService {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	FriendListDAO friDao;
	

	public List<FriendProfileDTO> list(int userNo) {
		List<FriendProfileDTO> list = friDao.list(userNo);
		return list;
	}


	public FriendProfileDTO findFriend(String param) {
		logger.info("findFriendService:{}",param);
		return friDao.findFriend(param);
	}


	public int addFriend(int myUserNo, int friUserNo) {
		return friDao.addFriend(myUserNo,friUserNo);
	}

	
	

}
