package java_ex100;

import java.util.Scanner;

public class ex100_27 {

	public static void main(String[] args) {
		// 큰 값이 10진수로 출력된다.
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요>");
		int a = scan.nextInt();
		System.out.print("정수를 입력하세요>");
		int b = scan.nextInt();
		
		int i = ( a > b ) ? a : b; //?연산자 (삼항연산자)
		System.out.println(i);
		
		if( a > b ) {
			//true
			i = a;
		}else {
			//false
			i = b;
		}
		System.out.println(i);
		
	}

}