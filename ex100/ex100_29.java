package java_ex100;

import java.util.Scanner;

public class ex100_29 {

	public static void main(String[] args) {
		// ???? even(?)/odd(?)? ????.
		Scanner scan = new Scanner(System.in);
		System.out.print("??? ?????>");
		int a = scan.nextInt();
		System.out.print("??? ?????>");
		int b = scan.nextInt();
		System.out.print("??? ?????>");
		int c = scan.nextInt();
		
		if(a%2==0) {
			System.out.println("even");
		}else {
			System.out.println("odd");
		}
		if(b%2==0) {
			System.out.println("even");
		}else {
			System.out.println("odd");
		}
		if(c%2==0) {
			System.out.println("even");
		}else {
			System.out.println("odd");
		}
	}

}