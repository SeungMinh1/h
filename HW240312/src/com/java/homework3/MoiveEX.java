package com.java.homework3;

public class MoiveEX {

	public static void main(String[] args) {
		
		Movie movie = new Movie("추격자", 7, 5, "영화");
		
		movie.setTotalScore(5);
		movie.setTotalScore(4);
		movie.setTotalScore(3);
		
		movie.getInformation();
		System.out.println("==================================");
		
		Performance per = new Performance("지킬앤하이드", 9, 10, "공연");
		
		per.setTotalScore(5);
		per.setTotalScore(4);
		per.setTotalScore(3);
		per.setTotalScore(5);
		per.setTotalScore(5);
		
		per.getInformation();
		

	}

}
