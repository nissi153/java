package javastudy_basic_ex100;

import java.util.Scanner;

public class ex100_29 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요>");
		int a = scan.nextInt();
		System.out.print("정수를 입력하세요>");
		int b = scan.nextInt();
		System.out.print("정수를 입력하세요>");
		int c = scan.nextInt();
		
		if(a%2==0) {
			System.out.println("even");
		}else {
			System.out.println("ood");
		}
		if(b%2==0) {
			System.out.println("even");
		}else {
			System.out.println("ood");
		}
		if(c%2==0) {
			System.out.println("even");
		}else {
			System.out.println("ood");
		}

	}

}
