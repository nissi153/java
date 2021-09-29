package java_ex100;

import java.util.Scanner;

public class ex100_93 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("평행 사변형의 가로 길이를 입력하세요>");
		int paraWidth = scan.nextInt();
		System.out.print("평행 사변형의 세로 길이를 입력하세요>");
		int paraLength = scan.nextInt();
		System.out.print("평행 사변형의 기우는 방향을 입력하세요>");
		String slope = scan.next();
		
		int a = paraWidth;  // 범위를 제한 하기 위한 변수(1부터)
		int b = (paraWidth*2);  // 범위를 제한 하기 위한 변수(마지막 부터)
		
		int a1 = 0;// 기울기를 위한 범위 설정
		int b1 = paraWidth+1;
		for(int i = 1; i<=paraLength; i++) {
			for(int j = 1; j<(paraWidth*2); j++) {
				if(slope.equals("l")) {
					if(j<a || j>=b) {
						System.out.print(" ");
					}else {
						System.out.print("*");
					}
				}else {
					if(j<=a1 || j>=b1) {
						System.out.print(" ");
					}else {
						System.out.print("*");
					}
				}
			}
			a--;
			b--;
			
			a1++;
			b1++;
			System.out.println();
		}
		
	}

}