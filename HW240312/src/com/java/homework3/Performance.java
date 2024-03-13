package com.java.homework3;

public class Performance extends Culture{
	//필드
	String genre;
	
	//생성자
	Performance(String name, int directorNum, int actorNum, String genre){
		super(name, directorNum, actorNum);
		this.genre = genre;
	}
	
	//메소드
	@Override
	public void getInformation() {
		System.out.printf("공연제목 : %s\n감독 : %d\n배우 : %d\n공연총점 : %d\n공연평점 : %s\n"
				, this.name, this.directorNum, this.actorNum, this.totalscore, this.getGrade());
	}
	

}
