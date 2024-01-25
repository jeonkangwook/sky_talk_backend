package com.example.message.friendListDto;

import java.sql.Date;

import lombok.Data;

@Data
public class FriendListDTO {
	
	private int friUserNo;
	private int friCode;
	private Date relDtm;
	private Date relUpDtm;
	private int userNo;
	
	
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
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	

}
