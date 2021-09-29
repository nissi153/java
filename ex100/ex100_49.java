package javastudy_basic_ex100;

import java.util.Scanner;

public class ex100_49 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("시를 입력하세요>");
		int hour = scan.nextInt();
		System.out.print("분을 입력하세요>");
		int minute = scan.nextInt();
		
		if(minute>=0 && hour<=59) {
			minute = minute-30;
			if(minute<0) {
				hour--;
				minute = 60+minute;
			}
		}
		
		System.out.printf("%02d",hour);
		System.out.print(":");
		System.out.printf("%02d",minute);
	}

}
