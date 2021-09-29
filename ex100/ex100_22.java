package java_ex100;

import java.util.Scanner;

public class ex100_22 {

	public static void main(String[] args) {
		//a가 b보다 큰 경우 1을, 그렇지 않은 경우 0을 출력한다
		Scanner scan = new Scanner(System.in);
		System.out.println("정수를 입력하세요>");
		int a = scan.nextInt();
		System.out.println("정수를 입력하세요>");
		int b = scan.nextInt();
		if(b<a) {
			System.out.println("1");
		}else if( b >= a) { // b==a || b>a
			System.out.println("0");
			
		}
		
		if(b<a) {
			System.out.println("1");
		}else if( b==a || b>a) { // || 는 or 연산입니다.
			System.out.println("0");
			
		}
	}

}
