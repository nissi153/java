package javastudy_basic_ex100;

import java.util.Scanner;

public class ex100_36 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 주사위의 숫자를 입력하세요>");
		int n = scan.nextInt();
		System.out.print("두번째 주사위의 숫자를 입력하세요>");
		int m = scan.nextInt();

		for(int i = 1; i<=n; i++) {
			for(int j =1; j<=m; j++) {
				System.out.println(i+" "+j);
			}
		}
		
	}

}
