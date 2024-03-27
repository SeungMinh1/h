package com.yedam.board;

import java.sql.Date;

public class Board {
	
	//필드
	private String boardTitle;
	private String memberId;
	private String content; 
	private Date writeDate;
	
	

	//메소드
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	} 
	
	@Override
	public String toString() {
		return "Board [boardTitle=" + boardTitle + ", memberId=" + memberId + ", content=" + content + ", writeDate="
				+ writeDate + "]";
	}

}
