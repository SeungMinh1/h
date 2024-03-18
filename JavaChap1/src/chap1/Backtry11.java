package chap1;

import java.util.Scanner;

public class Backtry11 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int[] list = {1, 1, 2, 2, 2, 8};
		int[] list2 = new int[6];
		for(int i=0; i<list2.length; i++) {
			list2[i] = sc.nextInt();
			list[i] -= list2[i];
		}
		for(int i=0; i<list.length; i++) {
			System.out.print(list[i] + " ");
			
		}
		

	}

}
