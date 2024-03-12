package com.java.homework2;

public class ObesityInfo extends StandardWeightInfo{

	ObesityInfo(String name, int height, int weight) {
		super(name, height, weight);
		
	}
	
	//메소드
	public void getInformation() {
		System.out.printf("이름 : %s 키 : %.2f 몸무게 : %.2f  %s\n", name, height, weight, getObesity() );
	}
	public double getObesity() {
		double obesity = (weight - super.getStandardWeight())/super.getStandardWeight()*100;
		return obesity;
	}
	

}
