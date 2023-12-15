package com.example.message.friendListCcontroller;

import java.util.HashMap;
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
		List<FriendProfileDTO> friList = friService.list(userNo);
		return friList;
	}
	
	@PostMapping("/api/findFriend")
	public FriendProfileDTO findFriend(@RequestBody  UserDTO loginId) {
		logger.info("친구찾기");
		String param = loginId.getLoginId();
		logger.info("friendFind{}",param);
		FriendProfileDTO result = friService.findFriend(param);
		logger.info("result:{}",result);
		return result;
	}
	
	@PostMapping("/api/addFriend")
	public int addFriend(@RequestParam int myUserNo, @RequestParam int friUserNo) {
		logger.info("친구추가");
		int result = friService.addFriend(myUserNo,friUserNo);
		return result;
	}
	
	
	

}
