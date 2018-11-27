package com.spring.board.domain;


public class BoardVO {
	private int bNum;
	private String bTitle;
	private String bContent;
	private String bWriteDate;
	private int bReadCount;
	private String userID;
	
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbWriteDate() {
		return bWriteDate;
	}
	public void setbWriteDate(String bWriteDate) {
		this.bWriteDate = bWriteDate;
	}
	public int getbReadCount() {
		return bReadCount;
	}
	public void setbReadCount(int bReadCount) {
		this.bReadCount = bReadCount;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardVO [bNum=");
		builder.append(bNum);
		builder.append(", bTitle=");
		builder.append(bTitle);
		builder.append(", bContent=");
		builder.append(bContent);
		builder.append(", bWriteDate=");
		builder.append(bWriteDate);
		builder.append(", bReadCount=");
		builder.append(bReadCount);
		builder.append(", userID=");
		builder.append(userID);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
