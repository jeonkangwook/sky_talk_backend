package com.example.message.userDto;

import java.sql.Date;

public class UserDTO {
	
	private int userNo;
	private String loginId;
	private String password;
	private String name;
	private String birth;
	private String mobile;
	private Date joinDtm;
	private Date updateDtm;
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getJoinDtm() {
		return joinDtm;
	}
	public void setJoinDtm(Date joinDtm) {
		this.joinDtm = joinDtm;
	}
	public Date getUpdateDtm() {
		return updateDtm;
	}
	public void setUpdateDtm(Date updateDtm) {
		this.updateDtm = updateDtm;
	}
	
	

}
