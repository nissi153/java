package javastudy_basic_ex100;

import java.util.Scanner;

public class ex100_38 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("삼각형의 밑변을 입력해주세요>");
		float a = scan.nextFloat();
		System.out.print("삼각형의 높이를 입력해주세요>");
		float b = scan.nextFloat();
		
		System.out.printf("삼각형의 넓이는? "+"%.1f", (a+b)/2);
		
	}

}
