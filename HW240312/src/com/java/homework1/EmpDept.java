package com.java.homework1;

public class EmpDept extends Employee{
	
	//필드
	String department;
	//생성자
	EmpDept(String name, int money, String department){
		super(name, money);
		this.department = department;
	}
	
	//getter
	String getDepartment() {
		return this.department;
	}
	
	//오버라이딩
	@Override
	public void getInformation() {
		System.out.printf("이름 : %s  연봉 : %d원 부서 : %s\n",this.name, this.money,this.department);
	}
	@Override
	public void print() {
		System.out.println("수퍼클래스\n서브클래스"); 
	}
	
}
