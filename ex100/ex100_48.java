package java_ex100;

import java.util.*;
public class ex100_48 {

	public static void main(String[] args) {
		// ���س⵵�� 2018�⵵�̴�. ���� ���̸� ����Ͻÿ�. 
		//��)
		//790101 1 =====> ���������� 1�̹Ƿ�, 1979���, 40���̴�.
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
		System.out.println("���̴� :"+age);

	}

}