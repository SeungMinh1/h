package chap1;

import java.util.Scanner;

public class Backtry5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int sum = 0;
		String num = sc.nextLine();
		for(int i=0; i<n; i++) {
			sum+= Character.getNumericValue(num.charAt(i)) ;
		}
		System.out.println(sum);
		
	}

}
