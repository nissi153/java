package java_ex100;
import java.util.Scanner;

public class ex69 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("시작값을 입력해주세요>");
		int a = scan.nextInt();
		System.out.print("등차 값을 입력해주세요>");
		int b = scan.nextInt();
		System.out.print("몇 번째 자리 까지 출력을 할지 입력해주세요>");
		int n = scan.nextInt();
		
		for(int i = a; i<=(b*n); i+=b) {
			System.out.println(i);
		}
	}
}
