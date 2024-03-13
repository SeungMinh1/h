package com.java.homework1;

public class Employee {
	
	//필드
	String name;
	int money;
	
	//생성자
	Employee(String name, int money){
		this.name = name;
		this.money = money;
	}
	
	
	//메서드
	public void getInformation() {
		System.out.printf("이름 : %s  연봉 : %d\n", this.name,this.money);
	}
	public void print() {
		System.out.println("수퍼클래스"); 
	}
	
	//getter
	String getName() {
		return this.name;
	}
	int getMoney() {
		return this.money;
	}
	

}
