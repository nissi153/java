package javastudy_basic_ex100;

import java.util.Scanner;

public class ex100_48 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("생년월일을 입력해주세요>");
		int ssn = scan.nextInt();
		System.out.print("주민번호 뒷 자리 첫번째 숫자를 입력해주세요>");
		int num = scan.nextInt();
		
		if(num==1||num==2) {
			int age = (1120000-ssn)/10000;
			System.out.println(age);
		}else {
			int age = (120000-ssn)/10000;
			System.out.println(age);
		}
		

	}

}
