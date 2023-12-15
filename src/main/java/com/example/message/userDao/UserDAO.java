package com.example.message.userDao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.example.message.userDto.UserDTO;

@Mapper
public interface UserDAO {

	int login(String loginId);

	int join(HashMap<String, String> params);

	String passCheck(String loginId);

	UserDTO userData(String loginId);

	String findId(HashMap<String, String> params);

	int findPw(HashMap<String, String> params);

	int changePw(HashMap<String, String> params);

	String idCheck(String loginId);

}
