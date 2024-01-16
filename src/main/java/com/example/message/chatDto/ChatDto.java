package com.example.message.chatDto;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ChatDto {
	
	private int chatNo;
	private String imgPath;
	private String content;
	private LocalDateTime chatDtm;
	private int chatRoomNo;
	private int userNo;
	private String nickName;
	
	private Date createDtm;
	private Date proUpdateDtm;
	private String chatName;
	private String readYn;
	private Date readDtm;
	private int sendUserNo;
	
	private String getUserName;
	private String sendUserName;
	
	public String getGetUserName() {
		return getUserName;
	}
	public void setGetUserName(String getUserName) {
		this.getUserName = getUserName;
	}
	public String getSendUserName() {
		return sendUserName;
	}
	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getChatNo() {
		return chatNo;
	}
	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getChatDtm() {
		return chatDtm;
	}
	public void setChatDtm(LocalDateTime chatDtm) {
		this.chatDtm = chatDtm;
	}
	public int getChatRoomNo() {
		return chatRoomNo;
	}
	public void setChatRoomNo(int chatRoomNo) {
		this.chatRoomNo = chatRoomNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public Date getCreateDtm() {
		return createDtm;
	}
	public void setCreateDtm(Date createDtm) {
		this.createDtm = createDtm;
	}
	public Date getProUpdateDtm() {
		return proUpdateDtm;
	}
	public void setProUpdateDtm(Date proUpdateDtm) {
		this.proUpdateDtm = proUpdateDtm;
	}
	public String getChatName() {
		return chatName;
	}
	public void setChatName(String chatName) {
		this.chatName = chatName;
	}
	public String getReadYn() {
		return readYn;
	}
	public void setReadYn(String readYn) {
		this.readYn = readYn;
	}
	public Date getReadDtm() {
		return readDtm;
	}
	public void setReadDtm(Date readDtm) {
		this.readDtm = readDtm;
	}
	public int getSendUserNo() {
		return sendUserNo;
	}
	public void setSendUserNo(int sendUserNo) {
		this.sendUserNo = sendUserNo;
	}

}
