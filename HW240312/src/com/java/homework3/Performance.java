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
	public abstract void getInformation()

}
