package com.java.homework2;

public class ObesityInfo extends StandardWeightInfo{

	ObesityInfo(String name, int height, int weight) {
		super(name, height, weight);
		
	}
	
	//메소드
	public void getInformation() {
		System.out.printf("이름 : %s 키 : %d 몸무게 : %d  %s\n", name, height, weight, this.obesityreturn());
	}
	public double getObesity() {
		double obesity = (this.weight - super.getStandardWeight())/super.getStandardWeight()*100;
		return obesity;
	}
	public String obesityreturn() {
		if(this.getObesity() <18.5) {
			return "저체중";
		}else {
			return "비만";
		}
	}
	
	

}
