package java_ex100;
import java.util.Scanner;

public class ex100_62 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("학년을 입력하세요.");
		int a = scan.nextInt();
		System.out.print("반을 입력하세요.");
		int b = scan.nextInt();
		System.out.print("번호을 입력하세요.");
		int c = scan.nextInt();
		
		System.out.print(a);
		System.out.printf("%02d", b);
		System.out.printf("%03d", c);
		
		
		
	}

}
