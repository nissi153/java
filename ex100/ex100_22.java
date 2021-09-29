package javastudy_basic_ex100;

import java.util.Scanner;

public class ex100_22 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("정수를 입력하세요>");
		int a = scan.nextInt();
		System.out.println("정수를 입력하세요>");
		int b = scan.nextInt();
		if(b<a) {
			System.out.println("1");
		}else if(a==b||b>a) {
			System.out.println("0");
			
		}
		

	}

}
