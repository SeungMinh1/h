package com.java.homework2;

public class StandardWeightInfo extends Human{
	
	
	StandardWeightInfo(String name, int height, int weight) {
		super(name, height, weight);
	}
	
	public void getInformation() {
		System.out.printf("이름 : %s 키 : %d 몸무게 : %d 표준체중 : %.1f\n", name, height, weight,getStandardWeight());
	}
	public double getStandardWeight() {
		double standard = (height - 100) * 0.9;
		return standard;
	}

}
