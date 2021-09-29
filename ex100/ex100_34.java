package java_ex100ex100;
import java.util.Scanner;

public class ex100_34 {

	public static void main(String[] args) {
//		0이 아니면 입력된 정수를 출력하고
//		0이 입력되면 출력을 중단해보자.
		Scanner scan = new Scanner(System.in);
		
		//무한반복문
//		while( true ) {
//			System.out.println("run..");
//		}
//		for( ; ; ) {
//			System.out.println("run..");
//		}
		
		while(true) {
			System.out.print("숫자를 입력해주세요>");
			int num = scan.nextInt();
			if(num!=0) {
				System.out.println(num);
				continue;
			}else {
				System.out.println(num+"종료");
				break;
			}
		}
	}

}
