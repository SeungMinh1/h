package com.java.homework3;

public abstract class Culture {
	//필드
	String name;
	int directorNum;
	int actorNum;
	int audience;
	int totalscore = 0;
	
	//생성자
	Culture(String name, int directorNum, int actorNum){
		this.name = name;
		this.directorNum = directorNum;
		this.actorNum = actorNum;
	}
	//메소드
	public void setTotalScore(int score) { //관객수와 총점을 누적
		audience++;
		totalscore +=score;
	}
	 public String getGrade() { // 평점을 구하는 기능
		String star = "";
		for(int i=1; i <= totalscore / audience ; i++) 
			star +="☆";
		return star;
	 }
	 
	 public abstract void getInformation();
	

}
