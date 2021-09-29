package java_ex100;
import java.util.Scanner;

import java.util.Scanner;

public class ex100_52 {

	public static void main(String[] args) {
		//영어 서수 표현하기
		//1st  2nd  3rd  4th  5th  6th  ... 
		//11th 12th 13th 14th 15th...
		//21st 22nd 23rd 24th 25th ...
		//...
		//91st 92nd 93rd 94th 95th ... 99th
		//숫자th  : 예외사항 1st, 2nd, 3rd, 11th, 12th
		Scanner scan = new Scanner(System.in);
		System.out.println("입력하세요:");
		int num = scan.nextInt();
		
		if( num==11 || num==12 || num==13 ) {
			System.out.println(num+"th");
		}else if( num%10==1 ) {
			System.out.println(num+"st");
		}else if(num%10==2 ) {
			System.out.println(num+"nd");
		}else if(num%10==3 ) {
			System.out.println(num+"rd");
		}else{
			System.out.println(num+"th");
		}
	}

}