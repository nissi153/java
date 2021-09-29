package java_ex100;
import java.util.Scanner;

public class ex100_35 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요>");
		int num = scan.nextInt();
		int sum = 0;
		for(int i = 1; i<=num; i++) {
			if(i%2==0) {
				sum += i;
				System.out.print(i+" ");
			}
		}
		System.out.println();
		System.out.println("입력한 숫자는 1부터"+num+"까지의 수를 더한 수는?"+sum);

	}

}