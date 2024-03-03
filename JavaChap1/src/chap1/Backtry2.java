package chap1;
import java.util.Scanner;

public class Backtry2 { //42로 나눳을때 나머지 계산

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int[10];
		int count = 0;
		int temp = 0;
		
		for(int i=0; i<10; i++) {
			arr1[i] = sc.nextInt() % 42;
		}
		for(int i=0; i<10; i++) {
			temp = 0;
			for(int j=i+1; j<10; j++) {
				if(arr1[i] == arr1[j]) {
					temp++;
				}
			}
			if(temp == 0) {
				count++;
			}
		}
		System.out.println(count);
		
	}

}
