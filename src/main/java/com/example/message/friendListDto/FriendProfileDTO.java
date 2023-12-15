package com.example.message.friendListDto;

import java.sql.Date;

public class FriendProfileDTO {
	
	private int proNo;
	private int userNo;
	private String imgPath;
	private String status;
	private Date proUpdateDtm;
	private String nickname;
	
	public int getProNo() {
		return proNo;
	}
	public void setProNo(int proNo) {
		this.proNo = proNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getProUpdateDtm() {
		return proUpdateDtm;
	}
	public void setProUpdateDtm(Date proUpdateDtm) {
		this.proUpdateDtm = proUpdateDtm;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	

}
