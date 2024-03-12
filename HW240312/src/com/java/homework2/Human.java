package com.java.homework2;

public class Human {
	//필드
	String name;
	int height;
	int weight;
	//생성자
	Human(String name, int height, int weight){
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	//메서드
	public void getInformation() {
		System.out.printf("이름 : %s 키 : %d 몸무게 : %d\n", name, height, weight );
	}
	
	
}
