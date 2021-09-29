package java_ex100;
import java.util.Scanner;

public class ex100_54 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("a의 값을 입력하세요>");
		int a = scan.nextInt();
		System.out.println("b의 값을 입력하세요>");
		int b = scan.nextInt();
		
		if(b%a==0) {
			System.out.println(a+"*x="+b);
		}else if(a%b==0) {
			System.out.println(b+"*x="+a);
		}else {
			System.out.println("none");
		}
		
	}

}
