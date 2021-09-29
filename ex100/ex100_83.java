package java_ex100;
import java.util.Scanner;

public class ex100_83 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("삼각형의 길이를 입력하세요>");
		int size = scan.nextInt();
		
		for(int i = 1; i<=size; i++) {
			for(int j = 1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
