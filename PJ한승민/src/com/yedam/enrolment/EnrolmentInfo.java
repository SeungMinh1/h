package com.yedam.enrolment;

public class EnrolmentInfo {
	
	//필드
	private String memberId;
	private String classTitle ;
	
	
	//메소드
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getClassTitle() {
		return classTitle;
	}
	public void setClassTitle(String classTitle) {
		this.classTitle = classTitle;
	}
	
	
	@Override
	public String toString() {
		return "EnrolmentInfo [memberId=" + memberId + ", classTitle=" + classTitle + "]";
	}
	
	

}