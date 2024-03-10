package com.yedam.java.hardst;

public class Car {
	
	//필드
	String name;
	String speed;
	
	//생성자
	Car(String name){
		this.name = name;
	}
	
	//메서드
	
	void makecar() {
		System.out.println(this.name + "입니다.");
	}

}
