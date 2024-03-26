package com.yedam.education;


public class EduClass {
	
	//필드
	private int classnum;
	private String title;
	private String professor;
	private int maxNum;
	private int currentNum;
	
	//생성자
	
	//메서드
	
	public int getClassnum() {
		return classnum;
	}
	public void setClassnum(int classnum) {
		this.classnum = classnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public int getCurrentNum() {
		return currentNum;
	}
	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}
	
	@Override
	public String toString() {
		return "EduClass [classnum=" + classnum + ", title=" + title + ", professor=" + professor + ", maxNum=" + maxNum
				+ ", currentNum=" + currentNum + "]";
	}
	
	

}