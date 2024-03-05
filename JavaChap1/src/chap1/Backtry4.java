package chap1;

import java.util.Scanner;

public class Backtry4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //sc.nextLine();
		
		for(int i =0; i<n; i++) {
			String a = sc.nextLine();
			System.out.println(a.charAt(0) + a.charAt(a.length()-1));
		}
		/*
		String[] word = new String[n];
		for(int i =0; i<n; i++) {
			word[i] = sc.nextLine();
		}
		for(int i =0; i<n; i++) {
			System.out.println(word[i].charAt(0) + word[i].charAt(word[i].length()-1));
		}
		*/
	}
		

}
