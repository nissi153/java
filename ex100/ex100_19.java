package java_ex100;
import java.util.Scanner;

public class ex100_19 {

	public static void main(String[] args) {
		// 정수를 입력받아 아스키코드 10진수값으로 
		// 출력하는 프로그램을 작성해보자.
		System.out.println("입력하세요.");
		Scanner scan = new Scanner(System.in);
		String ch = scan.nextLine();
		//문자열을 정수로 변환하는 함수
		int ch_int = Integer.parseInt(ch);
		
		System.out.println((char)ch_int );

	}

}
