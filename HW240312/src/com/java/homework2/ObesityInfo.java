package com.java.homework2;

public class ObesityInfo extends StandardWeightInfo{

	ObesityInfo(String name, int height, int weight) {
		super(name, height, weight);
		
	}
	
	//메소드
	public void getInformation() {
		System.out.printf("이름 : %s 키 : %d 몸무게 : %d  %.2f\n", name, height, weight, getObesity());
	}
	public double getObesity() {
		double obesity = (weight - super.getStandardWeight())/super.getStandardWeight()*100;
		return obesity;
	}
	
	public String obe() {
		if(getObesity() > 10) {
			return "비만";
		}else {
			return "정상";
		}
	}
	

}
