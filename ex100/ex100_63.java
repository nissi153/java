package java_ex100;
import java.util.Scanner;

public class ex100_63 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("일을 입력해주세요>");
		int day = scan.nextInt();
		
		System.out.println("일을 시간으로 변환한 결과> "+(day*24)+" 시간입니다.");
		
		
	}

}
