package java_ex100;

import java.util.*;
public class ex100_48 {

	public static void main(String[] args) {
		// 기준년도는 2018년도이다. 현재 나이를 출력하시오. 
		//예)
		//790101 1 =====> 성별정보가 1이므로, 1979년생, 40살이다.
		//080521 4        
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		int male = scan.nextInt();
		
		int birth_year;
		if(male==1 || male==2) {
			birth_year = 1900 + number / 10000;
		}else {
			birth_year = 2000 + number / 10000;
		}
		
		int age = 2020 - birth_year;
		System.out.println("나이는 :"+age);

	}

}