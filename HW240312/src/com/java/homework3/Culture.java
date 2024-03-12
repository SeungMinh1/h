package com.java.homework3;

public class Culture {
	//필드
	String name;
	int directorNum;
	int actorNum;
	int score;
	//생성자
	Culture(String name, int directorNum, int actorNum){
		this.name = name;
		this.directorNum = directorNum;
		this.actorNum = actorNum;
	}
	//메소드
	public void setTotalScore(int score) { //관객수와 총점을 누적
		
	}
	 public String getGrade() { // 평점을 구하는 기능
		return name;
	 }
	 public abstract void getInformation()
	

}
