package chap1;
import java.util.Scanner;

public class Backtry7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num1 = sc.next();
		String num2 = sc.next();
		String num11 = "";
		String num22 = "";
		for(int i=2; i>=0; i--) {
			num11 += num1.charAt(i);
			num22 += num2.charAt(i);
		}
		int a = 0;
		if(Integer.parseInt(num11) > Integer.parseInt(num22)) {
			a = Integer.parseInt(num11);
		}else a = Integer.parseInt(num22);
		
		System.out.println(a);
		
		/*
		char temp = num1.charAt(0);
		num[0] = num[num1.length()-1];
		num[num1.length()-1] = temp;
		
		int num1to2 = num[0]+ num[1] + num[2]; 
		System.out.println(num1to2);
		//num1.charAt(0) = num1.charAt(num1.length);
		*/
	}

}
