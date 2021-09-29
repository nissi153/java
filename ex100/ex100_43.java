package javastudy_basic_ex100;

import java.util.Scanner;

public class ex100_43 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int money = scan.nextInt();
		int[] num = new int [10];
		
		for(int i = 0; i<num.length; i++) {
			num[i] = money%10;
			money = money/10;
		}
		for(int i=num.length-1; i>=0; i--) {
			switch(num[i]) {
			case 1:
				System.out.print("일");
				break;
			case 2:
				System.out.print("이");
				break;
			case 3:
				System.out.print("삼");
				break;
			case 4:
				System.out.print("사");
				break;
			case 5:
				System.out.print("오");
				break;
			case 6:
				System.out.print("육");
				break;
			case 7:
				System.out.print("칠");
				break;
			case 8:
				System.out.print("팔");
				break;
			case 9:
				System.out.print("구");
				break;
			case 0:
				System.out.print("영");
				break;
				
			}
			switch(i) {
			case 0:
				System.out.print("원");
				break;
			case 1:
				System.out.print("십");
				break;
			case 2:
				System.out.print("백");
				break;
			case 3:
				System.out.print("천");
				break;
			case 4:
				System.out.print("만");
				break;
			case 5:
				System.out.print("십만");
				break;
			case 6:
				System.out.print("백만");
				break;
			case 7:
				System.out.print("천만");
				break;
			case 8:
				System.out.print("억");
				break;
			case 9:
				System.out.print("십억");
				break;
			
			}	
			System.out.print(" ");
			
		}

	}

}
