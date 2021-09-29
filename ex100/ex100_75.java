package java_ex100;
import java.util.Scanner;
public class ex100_75 {

	public static void main(String[] args) {
//75. 소수 판별
//2 ====> 소수 (왜냐하면 약수가 1 과 
//      		자기자신 2밖에 없기때문..)
//3 ====> 소수 (왜냐하면 약수가 1 과 
//				자기자신 3밖에 없기때문..)
//4 ====> 소수가 아님 (왜냐하면 약수가 1 , 2 , 4 이기
//		때문..)
// 약수(나누어 떨어지는 수)의 갯수를 구하는 문제.
// 약수가 2개면 소수, 3개이상이면 소수가 아님.		
//  2의 약수를 구하는 방법, 1 나눈다. 2나눈다.
//  3의 약수를 구하는 방법, 1 나눈다 2나눈다 3나눈다		
//  4의 약수 : 1나눈다 2나눈다 3나눈다 4나눈다
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0; //약수 카운트
		for(int i=1; i<=n; i++) {
			if(n % i == 0) { //나누어 떨어짐.
				count++;
			}
		}
		if(count == 2) {
			System.out.println("소수임");
			System.out.println("약수갯수:"+count);
		}else {
			System.out.println("소수가 아님");
			System.out.println("약수갯수:"+count);
		}
	}

}
