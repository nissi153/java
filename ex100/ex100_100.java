package java_ex100;
import java.util.Random;
import java.util.Scanner;

public class ex100_100 {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
			
		int answer = rand.nextInt(100)+1;
			
		while(true) {
			System.out.println("번호를 입력하세요.");
			int userAnswer = scan.nextInt();
			if(userAnswer < answer) {
				System.out.println("번호가 정답보다 작습니다.");
			}else if(userAnswer > answer) {
				System.out.println("번호가 정답보다 큽니다.");
			}else {
				System.out.println("정답입니다.");
				break;
			}
		}

	}

}