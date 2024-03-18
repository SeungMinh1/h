package chap1;

import java.util.Scanner;

public class Backtry8 {

	public static void main(String[] args) {  //백준 5622
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		int time = 0;
		
		for(int i = 0; i<choice.length(); i++) {
			
			char num = choice.charAt(i);
			
			if(num == 'A' || num == 'B' || num =='C') {
				time += 3;
			}else if(num == 'D' || num == 'E' || num =='F') {
				time += 4;
			}else if(num == 'G' || num == 'H' || num =='I') {
				time += 5;
			}else if(num == 'J' || num == 'K' || num =='L') {
				time += 6;
			}else if(num == 'M' || num == 'N' || num =='O') {
				time += 7;
			}else if(num == 'P' || num == 'Q' || num =='R' || num == 'S' ) {
				time += 8;
			}else if(num == 'T' || num =='U' || num == 'V') {
				time += 9;
			}else if(num == 'W' || num =='X' || num == 'Y' || num == 'Z') {
				time += 10;

			}
		}
		System.out.println(time);
	}

}
