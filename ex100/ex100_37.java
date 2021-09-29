package java_ex100;
import java.util.Scanner;

public class ex100_37 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("한변의 개수를 입력해주세요>");
		int n = scan.nextInt();
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
