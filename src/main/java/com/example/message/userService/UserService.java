package com.example.message.userService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.message.friendListDto.FriendProfileDTO;
import com.example.message.userDao.UserDAO;
import com.example.message.userDto.UserDTO;


@Service
public class UserService {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired UserDAO userDao;
	@Autowired PasswordEncoder encoder;
	
	@Value("${file.location}") private String root;


	public int login(String loginId, String password) {
		logger.info("서비스 동작");
		String encpw = userDao.passCheck(loginId);
		boolean match = encoder.matches(password, encpw);
		logger.info("일치 여부 : " + match);
		
//		String success = userDao.login(loginId,password);
		int result = 0;
		if(match == true) {
			logger.info("성공");
			result = userDao.login(loginId);
		}else {
			logger.info("실패");
		}
		return result;
	}
	
	public UserDTO userData(String loginId, String password) {
		return userDao.userData(loginId);
	}



	public int join(HashMap<String, String> params) {
		
		return userDao.join(params);
	}

	public String findId(HashMap<String, String> params) {
		return userDao.findId(params);
	}

	public int findPw(HashMap<String, String> params) {
		return userDao.findPw(params);
	}

	public int changePw(HashMap<String, String> params) {
		return userDao.changePw(params);
	}

	public boolean idCheck(String loginId) {
		boolean result = false;
		String idCheck = userDao.idCheck(loginId);
		if(idCheck == null) {
			result = true;
		}
		return result;
	}

	public FriendProfileDTO profile(int userNo) {
		return userDao.profile(userNo);
	}
	

	public void uploadImage(MultipartFile uploadFile, String userNo) {
		
		//1. 파일명 추출
		String oriFileName= uploadFile.getOriginalFilename();
		logger.info("oriFileName : " + oriFileName);
		String ext = oriFileName.substring(oriFileName.lastIndexOf("."));
		logger.info("ext : " + ext);
		
		//2. 새 파일명 생성
		String newFileName= System.currentTimeMillis()+ext;
		
		try {
			// 파일 저장
			// uploadFile 에서 바이트 추출
			byte[] arr= uploadFile.getBytes();
			// 저장할 파일 위치 지정
			Path path = Paths.get(root+newFileName);
			// 파일 쓰기
			Files.write(path, arr);
			userDao.uploadImage(newFileName,userNo,oriFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void updateProfile(String nickname, String status, String userNo) {
		userDao.updateProfile(nickname,status,userNo);
		
	}

	public int profileCheck(String userNo) {
		return userDao.profileCheck(userNo);
		
	}

	public void insertProfile(String nickname, String status, String userNo) {
		userDao.insertProfile(nickname,status,userNo);
		
	}





	
	
	

}
