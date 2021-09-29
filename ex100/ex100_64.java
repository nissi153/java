package java_ex100;

import java.util.Scanner;

public class ex100_64 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("나눌 숫자(분모)를 입력해 주세요>");
		int numA = scan.nextInt();
		System.out.print("나눌 숫자(분자)를 입력해 주세요>");
		int numB = scan.nextInt();
		
		System.out.println("두 숫자를 나누어 나머지의 값은? "+(numA%numB)+" 입니다.");
		
	}

}
