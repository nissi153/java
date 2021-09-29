package ex100;

import java.util.Scanner;
public class ex100_86 {
	public static void main(String[] args) {
		
		//삼각형 출력하기4 
		//홀수 n을 입력받음(1,3,5,7,9,...)
		//   *
		//  ***
		// *****
		//n 1,3,5
		//i 1,2,3   (n/2)+1
		//k 2,1,0
		//j 1,3,5   i*2+1
		int n = 11;
		int midIndex = (n/2)+1;
		for(int i=1; i<=midIndex; i++) {
			//i값에 따라 중간까지 공백 출력
			for(int k=i; k<midIndex; k++) {
				System.out.print(" ");
			}
			//i값에 따라 1,3,5,7 홀수번 별 출력
			for(int j=2; j<i*2+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
