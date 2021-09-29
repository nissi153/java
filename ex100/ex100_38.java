package java_ex100;

import java.util.Scanner;

public class ex100_38 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("삼각형의 밑변을 입력해주세요>");
		int a = scan.nextInt();
		System.out.print("삼각형의 높이를 입력해주세요>");
		int b = scan.nextInt();
		
		System.out.printf("삼각형의 넓이는? "+"%.1f", (float)(a*b)/2);
	}

}
