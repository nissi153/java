package java_ex100;
import java.util.Scanner;

public class ex68 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("(역)카운트 다운 시작할 숫자를 입력하세요>");
		int a = scan.nextInt();
		for(int i = 1; i<=a; i++) {
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(i);
		}
		System.out.println("종료합니다.");
		
		
	}

}
