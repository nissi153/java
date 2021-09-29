package java_ex100ex100;
import java.util.Scanner;

public class ex100_73 {
	public static void main(String[] args) {
//규칙
//1, 10, 2, 20, 3, 30, 4, 40, 5, 50, 6, 60, 
//7, 70, 8, 80, 9, 90, 10, 100, 11, 110, 12, 120		
//존의 번호(k), 밥의 번호(h)가 주어질 때 
//존과 밥이 받는 기부금의 합을 구하시오.
//입력값: 1,2
//출력값: 11	
		int[] rule = {1, 10, 2, 20, 3, 30, 4, 40, 5, 
			50, 6, 60, 7, 70, 8, 80, 9, 90, 
			10, 100, 11, 110, 12, 120 };	
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int money = rule[num1-1] + rule[num2-1];
		System.out.println("기부금은 "+money);
	}
}
