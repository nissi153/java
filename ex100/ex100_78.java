package java_ex100;
import java.util.Scanner;

public class ex100_78 {

	public static void main(String[] args) {
		// 계산기
		//3 + 3 – 3 * 3 / 3 =
		//정수형, 문자형 입력으로 받는다.
		//'='문자를 만날때까지(무한루프)
		//연산자우선순위는 무시해야 됨.
		int num1;
		int num2;
		char op;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("입력하세요.");
		num1 = scan.nextInt();
	
		int result = num1;
	
		while(true)
		{
			String input = scan.next();//nextLine다른점은
			                           //공백,줄바꿈을 끝으로 인식함.
			op = input.charAt(0);
			if(op == '=') {
				System.out.println(result);
				break;
			}
			
			num2 = scan.nextInt();
			
			if(op == '+') {
				result = result + num2;
			}else if(op == '-') {
				result = result - num2;
			}else if(op == '*') {
				result = result * num2;
			}else if(op == '/') {
				result = result / num2;
			}
		}
	}

}
