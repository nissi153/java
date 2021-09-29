package java_ex100;
import java.util.Scanner;

public class ex100_84 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("역삼각형의 길이를 입력하세요>");
		
		int n = scan.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
