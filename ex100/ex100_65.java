package java_ex100;
import java.util.Scanner;

public class ex65 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("369게임의 범위를 정해주세요>");
		int a = scan.nextInt();
		
		for(int i = 1; i<=a; i++) {
			if(i==3 || i==6 || i==9) {
				System.out.print(" X");
			}else {
				System.out.print(" "+i);
			}
		}
	}
}
