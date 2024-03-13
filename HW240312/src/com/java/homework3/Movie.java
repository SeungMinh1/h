package com.java.homework3;

public class Movie extends Culture{
	//필드
	String genre;
	
	//생성자
	Movie(String name, int directorNum, int actorNum, String genre){
		super(name, directorNum, actorNum);
		this.genre = genre;
	}
	//메소드
	@Override
	public void getInformation() {
		System.out.printf("영화제목 : %s\n감독 : %d\n배우 : %d\n영화총점 : %d\n영화평점 : %s\n"
				, this.name, this.directorNum, this.actorNum, this.totalscore, this.getGrade());
	}

}
