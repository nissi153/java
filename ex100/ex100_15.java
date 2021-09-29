package javastudy_basic_ex100;

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
		
		System.out.printf("%02d", year);
		System.out.printf(",");		
		System.out.printf("%02d", mon);
		System.out.printf(",");
		System.out.printf("%02d", day);
		
	}

}
