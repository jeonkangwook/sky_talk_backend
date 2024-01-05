package com.example.message.userCcontroller;

import java.util.HashMap;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.message.userDto.UserDTO;
import com.example.message.userService.UserService;


@RestController
public class UserController {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired UserService userService;
	@Autowired PasswordEncoder encoder;
	
	@PostMapping("/api/login")
	public UserDTO login(@RequestBody HashMap<String, String> params) {
		String loginId = params.get("username");
		String password = params.get("password");
		logger.info("로그인");
		logger.info("파람스{}",params);
		int result = userService.login(loginId,password);
		logger.info("result:{}",result);
		
		UserDTO userData = null;
		if(result != 0) {
			userData = userService.userData(loginId,password);
		}
		logger.info("userData:{}",userData);
		return userData;
	}
	
	
	@PostMapping("/api/join")
	public String join(@RequestBody HashMap<String, String> params) {
		logger.info("가입전송");
		logger.info("파람:{}",params);
		
		String plain_pw = params.get("password");
		logger.info("평문번호:{}",plain_pw);
		String enc_pw = encoder.encode(plain_pw);
		logger.info("암호번호:{}",enc_pw);
		params.put("password", enc_pw);
		String result = "실패";
		int success = userService.join(params);
		if(success == 1) {
			result = "성공";
		}
		return result;
	}
	
	@PostMapping("/api/idCheck")
	public boolean idCheck(@RequestBody UserDTO params) {
		String loginId = params.getLoginId();
		boolean result = userService.idCheck(loginId);
		return result;
	}
	
	@PostMapping("/api/findId")
	public String findId(@RequestBody HashMap<String, String> params) {
		logger.info("아이디 찾기");
		logger.info("파람:{}",params);
		String success = userService.findId(params);

		return success;
	}
	
	@PostMapping("/api/findPw")
	public int findPw(@RequestBody HashMap<String, String> params) {
		logger.info("아이디 찾기");
		logger.info("파람:{}",params);
		int success = userService.findPw(params);
		return success;
	}
	
	@PostMapping("/api/changePw")
	public int changePw(@RequestBody HashMap<String, String> params) {
		logger.info("아이디 찾기");
		logger.info("파람:{}",params);
		String plain_pw = params.get("password");
		logger.info("평문번호:{}",plain_pw);
		String enc_pw = encoder.encode(plain_pw);
		params.put("password", enc_pw);
		int success = userService.changePw(params);
		return success;
	}
	
	

}
