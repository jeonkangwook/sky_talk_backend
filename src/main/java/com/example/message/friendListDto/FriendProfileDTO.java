package com.example.message.friendListDto;

import java.sql.Date;

public class FriendProfileDTO {
	
	private int proNo;
	private int userNo;
	private String imgPath;
	private String status;
	private Date proUpdateDtm;
	private String nickname;
	private int friUserNo;
	private int friCode;
	private Date relDtm;
	private Date relUpDtm;

	
	public int getFriUserNo() {
		return friUserNo;
	}
	public void setFriUserNo(int friUserNo) {
		this.friUserNo = friUserNo;
	}
	public int getFriCode() {
		return friCode;
	}
	public void setFriCode(int friCode) {
		this.friCode = friCode;
	}
	public Date getRelDtm() {
		return relDtm;
	}
	public void setRelDtm(Date relDtm) {
		this.relDtm = relDtm;
	}
	public Date getRelUpDtm() {
		return relUpDtm;
	}
	public void setRelUpDtm(Date relUpDtm) {
		this.relUpDtm = relUpDtm;
	}
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
