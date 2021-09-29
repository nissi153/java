package javastudy_basic_ex100;

import java.util.Scanner;

public class ex100_20 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 숫자 입력>");
		short num1 = scan.nextShort();
		System.out.print("두번째 숫자 입력>");
		short num2 = scan.nextShort();
		System.out.print("세번째 숫자 입력>");
		short num3 = scan.nextShort();
		int sum = num1+num2+num3;
		System.out.println("총합 : "+sum);
		System.out.println("총합 : "+(float)sum/3);
		
	}

}
