package java_ex100;

import java.util.Scanner;

public class ex100_26 {

	public static void main(String[] args) {
		// 입력된 값이 true이면 false, false이면 true을 출력한다.
		//scan.nextBoolean() 사용
		Scanner scan = new Scanner(System.in);
		boolean b = scan.nextBoolean();
		
		if(b==true) {
			System.out.println("false");
		}else {
			System.out.println("true");
		}
		
		
		System.out.println( !b );// !연산자 = NOT연산자(논리부정연산자)
		
	}

}
