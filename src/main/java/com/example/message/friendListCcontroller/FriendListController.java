package com.example.message.friendListCcontroller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.message.friendListDto.FriendProfileDTO;
import com.example.message.friendListService.FriendListService;
import com.example.message.userDto.UserDTO;


@RestController
public class FriendListController {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	FriendListService friService;
	
	@GetMapping("/api/friendList")
	public List<FriendProfileDTO> friendList(@RequestParam int userNo) {
		logger.info("친구리스트");
//		int userNo = params.getUserNo();
		List<FriendProfileDTO> friList = friService.list(userNo);
		logger.info("friList:{}",friList);
		return friList;
	}
	
	@GetMapping("/api/findFriend")
	public FriendProfileDTO findFriend(@RequestParam  String loginId) {
		logger.info("친구찾기");
//		String param = loginId.getLoginId();
		logger.info("friendFind{}",loginId);
		FriendProfileDTO result = friService.findFriend(loginId);
		logger.info("result:{}",result);
		return result;
	}
	
	@PostMapping("/api/addFriend")
	public int addFriend(@RequestBody UserDTO params) {
		int myUserNo = params.getMyUserNo();
		int friUserNo = params.getFriUserNo();
		logger.info("myUserNo{}",myUserNo);
		logger.info("friUserNo{}",friUserNo);
		logger.info("친구추가");
		int result = friService.addFriend(myUserNo,friUserNo);
		return result;
	}
	
	
	

}
