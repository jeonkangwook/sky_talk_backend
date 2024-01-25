package com.example.message.userCcontroller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.message.friendListDto.FriendProfileDTO;
import com.example.message.userDto.UserDTO;
import com.example.message.userService.UserService;

import jakarta.servlet.http.HttpSession;


@RestController
public class UserController {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired UserService userService;
	@Autowired PasswordEncoder encoder;
	
	@PostMapping("/api/login")
	public UserDTO login(@RequestBody HashMap<String, String> params,HttpSession session) {
		String loginId = params.get("username");
		String password = params.get("password");
		logger.info("로그인");
		logger.info("파람스{}",params);
		int result = userService.login(loginId,password);
		logger.info("result:{}",result);
		
		UserDTO userData = null;
		if(result != 0) {
			userData = userService.userData(loginId,password);
			session.setAttribute("loginId", userData);
		}
		logger.info("userData:{}",userData);
		logger.info("session:{}",session);
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
	
	@GetMapping("/api/profile")
	public FriendProfileDTO profile(@RequestParam int userNo) {
		FriendProfileDTO result = userService.profile(userNo);
		return result;
	}
	
	@PostMapping("/api/updateImage")
	public void profile(@RequestParam MultipartFile image, @RequestParam String userNo) {
		logger.info("file::{} ",image);
		int result = userService.profileCheck(userNo);
		userService.uploadImage(image,userNo);
	}
	
	@PostMapping("/api/updateProfile")
	public void updateProfile(@RequestBody HashMap<String, String> params) {
		String nickname = params.get("nickname");
		String status = params.get("status");
		String userNo = params.get("userNo");
		int result = userService.profileCheck(userNo);
		if(result == 0) {
			userService.insertProfile(nickname,status,userNo);
		}else {
			userService.updateProfile(nickname,status,userNo);			
		}
	}
	
	@GetMapping(value = "/getImage")
	public ResponseEntity<ByteArrayResource> showImage(@RequestParam String path) {
//		try {
//            Path imagePath = Paths.get("C:/project/messageTest/upload/" + path); // 실제 이미지가 저장된 경로로 변경해주세요
//            UrlResource imageResource = new UrlResource(imagePath.toUri());
//
//            if (imageResource.exists() || imageResource.isReadable()) {
//                return ResponseEntity.ok().body(imageResource);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (MalformedURLException e) {
//            return ResponseEntity.notFound().build();
//        }
		logger.info("------------------------------------------");
		logger.info("photo name : " + path);
		String filePath = "C:/project/messageTest/upload/" + path;
		
		// 파일시스템으로 리소스를 읽어와 담는다.(리소스 바디)
		
		ByteArrayResource resource = null;
	    try {
	        byte[] fileData = Files.readAllBytes(Paths.get(filePath));
	        resource = new ByteArrayResource(fileData);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		// 헤더(내가 보낼 컨텐트의 타입이 어떤 것이다.)
		HttpHeaders header = new HttpHeaders();
		try {
			String type = Files.probeContentType(Paths.get(filePath)); //image/jpeg
			logger.info("file type : " + type);
			header.add("Content-type", type);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<ByteArrayResource>(resource,header,HttpStatus.OK);
	}
	
	

}
