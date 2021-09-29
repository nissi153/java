package javastudy_basic_ex100;

import java.util.Scanner;

public class ex100_34 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
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
