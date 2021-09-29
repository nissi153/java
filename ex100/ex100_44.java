package java_ex100;

import java.util.Scanner;

public class ex100_44 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("1.월요일 | 2.화요일 | 3.수요일 | 4.목요일 | 5.금요일 | 6.토요일 | 7.일요일");
		System.out.print("오늘의 요일을 입력해 주세요>");
		int day = scan.nextInt();
		switch(day) {
		case 1:
		case 3:
		case 5:
		case 7:
			System.out.println("오늘은 알바가는 날~");
			System.out.println("Oh! my god!");
			break;
		case 2:
		case 4:
		case 6:
			System.out.println("오늘은 쉬는날~");
			System.out.println("Enjoy~~~~!!");
			break;
		}
	}
}