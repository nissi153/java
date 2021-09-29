package java_ex100;
import java.util.Scanner;

public class ex66 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를 입력해 주세요>");
		int a = scan.nextInt();
		int sum = 0;
		for(int i = 1; i<=a; i++) {
			sum += i;
			if(sum >= a) {
				break;
			}
			System.out.print(i+"+");
		}
		System.out.println();
		System.out.println(sum+"입력한 수보다 크거나 같으므로 종료 합니다.");
	}
}
