package java_ex100;

import java.util.Scanner;

import java.util.Scanner;

public class ex100_82 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("시작할 구구단의 단수를 입력하세요>");
		int start = scan.nextInt();
		System.out.print("마지막 구구단의 단수를 입력하세요>");
		int last = scan.nextInt();
		
		for(int i = start; i<=last; i++) {
			for(int j = 1; j<10; j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
		}
		
	}

}
