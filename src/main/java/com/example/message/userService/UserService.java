package com.example.message.userService;

import java.util.HashMap;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.message.userDao.UserDAO;
import com.example.message.userDto.UserDTO;


@Service
public class UserService {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired UserDAO userDao;
	@Autowired PasswordEncoder encoder;
	



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



	
	
	

}
