package javastudy_basic_ex100;

import java.util.Scanner;

public class ex100_32 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String ch = scan.nextLine();
		switch(ch){
			case "A":
				System.out.println("best!!!");
				break;
			case "B":
				System.out.println("good!!!");
				break;
			case "C":
				System.out.println("run!");
				break;
			case "D":
				System.out.println("slowly~");
				break;
			default:
				System.out.println("what?");
				break;
				
		}

	}

}
