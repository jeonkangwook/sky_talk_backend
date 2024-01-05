package com.example.message.friendListDto;

import java.sql.Date;

import lombok.Data;

@Data
public class FriendListDTO {
	
	private int friNo;
	private int friCode;
	private Date relDtm;
	private Date relUpDtm;
	private int userNo;
	
	
	public int getFriNo() {
		return friNo;
	}
	public void setFriNo(int friNo) {
		this.friNo = friNo;
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
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	

}
