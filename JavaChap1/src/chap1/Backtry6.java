package chap1;

import java.util.Scanner;

public class Backtry6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr1 = new int[26];
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = -1;
		}
		String word = sc.nextLine();
		
		for(int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			if(arr1[ch - 'a'] == -1) {
				arr1[ch - 'a'] = i; 
			}
			
		}
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
	}

}
