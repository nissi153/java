package java_ex100;
import java.util.Scanner;

public class ex100_13 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float num = scan.nextFloat();
		num = (num+0.005f)*100;
		System.out.println(num);
		int i = (int)num;
		System.out.println(i);
		num =(float) i/100;
		System.out.println(num);

	}

}
