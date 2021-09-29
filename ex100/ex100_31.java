package java_ex100;

import java.util.Scanner;

public class ex100_31 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("점수를 입력하세여>");
		int num = scan.nextInt();
		if(num>=90) {
			System.out.println("평가 점수 A 입니다.");
		}
		else if(num>=70) {
			System.out.println("평가 점수 B 입니다.");
		}
		else if(num>=40) {
			System.out.println("평가 점수 C 입니다.");
		}
		else {
			System.out.println("평가 점수 D 입니다.");
		}
	}
}
