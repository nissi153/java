package java_ex100;
import java.util.Scanner;

public class ex100_71 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		System.out.println("계산기 n개의 숫자를 입력해 더합니다. 0을 입력하면 종료합니다.");
		System.out.println("==============================================");
		
		while(true){
			System.out.print("더할 숫자를 입력하세요>");
			int num = scan.nextInt();
			
			sum += num;
			System.out.println("====================");
			System.out.println("지금까지 숫자의 합은? "+sum);
			
			if(num==0) {
				System.out.println("시스템을 종료합니다.");
				break;
			}
		}
		
		
	}

}
