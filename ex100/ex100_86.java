package java_ex100;

import java.util.Scanner;

public class ex100_86 {

	public static void main(String[] args) {

		//삼각형 출력하기4 
		//홀수 n을 입력받음.
		//   *
		//  ***
		// *****
		// n=5일때, 줄수가 3, 별위치 3
		//            n/2+1
		int n = 5;
		int midIndex = (n/2)+1;
		for(int i=1; i<=midIndex; i++) {
			for(int k=i; k<midIndex; k++) {
				System.out.print(" ");
			}
			for(int j=2; j<i*2+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}