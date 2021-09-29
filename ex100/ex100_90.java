package java_ex100;

import java.util.Scanner;

public class ex100_90 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("사각형의 길이를 입력하세요>");
		int tetragonLength = scan.nextInt();
		
		for(int i = 1; i<=tetragonLength; i++) {
			for(int j = 1; j<=tetragonLength; j++) {
				if(i==1 || i==tetragonLength 
						|| j==1 || j==tetragonLength 
						|| i==j || (i+j)==(tetragonLength+1)) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		} 
	}

}
