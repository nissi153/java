package java_ex100;

import java.util.Scanner;

public class ex100_42 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("���Ⱑ ���� ���� ��ġ>");
		int ball = scan.nextInt();
		
		if((ball<=70&&ball>=50)||(ball%6==0)) {
			System.out.println("Win");
		}else {
			System.out.println("Lose");	
		}

	}

}
