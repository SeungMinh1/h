package com.java.homework2;

public class ObesityExample {

	public static void main(String[] args) {
		
		Human human = new StandardWeightInfo("홍길동", 168, 45);
		
		human.getInformation();
		human = new ObesityInfo("홍길동", 168, 90);
		human.getInformation();
		

	}

}
