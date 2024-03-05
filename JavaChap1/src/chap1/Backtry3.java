package chap1;

import java.util.Scanner;

public class Backtry3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //바구니
		int m = sc.nextInt(); // 횟수
		
		
		int[] basket = new int[n+1];
		for(int k=1; k<=n; k++) {
			basket[k] = k;
		}
		
		for(int k=0; k<m; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			while(i<j) {
				int box = 0;
				box = basket[i];
				basket[i] = basket[j];
				basket[j] = box;
				++i; --j;
			}
			
//			for(int h=i; h<=j; h++) {
//				int box = 0; //저장할 공간
//				
//				box = basket[h];
//				basket[h] = basket[j];
//				basket[j] = box;
//				--j;
			}
		
		
		for(int q=1; q<=n; q++) {
			System.out.print(basket[q]+" ");
		}

	}

}
