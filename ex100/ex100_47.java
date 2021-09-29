package java_ex100;

import java.util.Scanner;

public class ex100_47 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("년도를 입력하세요>");
		int year = scan.nextInt();
		
		if((year%4==0&&year%100!=0)) {
			System.out.println("윤년(1번 조건)");
		}else if(year%400==0){
			System.out.println("윤년(2번 조건)");
		}else {
			System.out.println("윤년 아님");
		}

	}

}