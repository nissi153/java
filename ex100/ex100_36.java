package java_ex100;

import java.util.Scanner;

public class ex100_36 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("ù��° �ֻ����� ���ڸ� �Է��ϼ���>");
		int n = scan.nextInt();
		System.out.print("�ι�° �ֻ����� ���ڸ� �Է��ϼ���>");
		int m = scan.nextInt();

		for(int i = 1; i<=n; i++) {
			for(int j =1; j<=m; j++) {
				System.out.println(i+" "+j);
			}
		}
		
	}

}