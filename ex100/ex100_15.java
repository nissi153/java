package java_ex100;

import java.util.*;

public class ex100_15 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("몇 년인가요? ");
		int year = scan.nextInt();
		System.out.print("몇 월인가요? ");
		int mon = scan.nextInt();
		System.out.print("몇 일인가요? ");
		int day = scan.nextInt();
		// % : 심볼 
		// 02 : 2자릿수가 안되면 0으로 출
		// d : 십진수 형태로 출
		// %02d
		System.out.printf("%d", year);
		System.out.printf(".");		
		System.out.printf("%d", mon);
		System.out.printf(".");
		System.out.printf("%d", day);
		
	}

}
