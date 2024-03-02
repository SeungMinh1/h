package chap1;
import java.util.Scanner;

public class Backtry1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int[31]; //1번부터 30번
		for(int i=0; i<28; i++) {
			int num = sc.nextInt();
			arr1[num] = 1;
		}
		for(int i=1; i<arr1.length; i++) {
			if(arr1[i] != 1 ) {
				System.out.println(i);
			}
		}
	}

}
