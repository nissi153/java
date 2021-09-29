package java_ex100;
import java.util.Scanner;

public class ex100_70 {
	public static void main(String[] args) {
                //등비 수 나열하기
                //2 6 18 54 162 486 ... 은 2부터 시작해 
                //이전에 만든 수에 3을 곱해 다음 수를 만든 수열
                //시작 값(a), 등비의 값(r), 몇 번째인지(n)가 입력될 때
                //n번째 수를 출력하는 프로그램을 만들어보자
                //a a*r a*r*r a*r*r*r  a*r*r*r*r
                //0  1   2    3		  4
                // sum = sum + i;
                // sum = sum * r;		
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		int multiSum = num1;
		for(int i=0; i<num3; i++) {
			multiSum = multiSum * num2;
			System.out.println(multiSum);
		}
		
	}

}
