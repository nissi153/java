package javastudy_basic_ex100;

import java.util.Scanner;

public class ex100_23 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요>");
		int a = scan.nextInt();
		System.out.print("정수를 입력하세요>");
		int b = scan.nextInt();
		if(a==b) {
			System.out.println("1");
		}else {
			System.out.println("0");
			
		}
	}

}
