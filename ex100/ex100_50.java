package javastudy_basic_ex100;

import java.util.Scanner;

public class ex100_50 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요> ");
		String name = scan.nextLine();
		System.out.println("성별을 입력하세요> ");
		String sex = scan.nextLine();
		System.out.println("키를 입력해 주세요> ");
		float height = scan.nextInt();
		System.out.println("체중을 입력해 주세요> ");
		float weight = scan.nextInt();
		
		
		if(sex=="남") {
			System.out.println("표준 체중은 "+((height-100)*0.9)+"입니다.");
		}else {
			System.out.println("표준 체중은 "+((height-100)*0.85)+"입니다.");
			
		}
		float mbi = (weight/((height/100)*(height/100)));
		System.out.println("체질량 지수 = "+ mbi);
		
		System.out.print("이름 : "+name+"  ");
		System.out.print("성별 : "+sex+"  ");
		System.out.print("키   : "+height+"  ");
		System.out.print("체중 : "+weight+"  ");
		if(mbi<18.5) {
			System.out.print("저체중 입니다.");
		}else if(mbi>=18.5&&mbi<=23) {
			System.out.print("정상 체중입니다.");
			
		}else {
			
			System.out.print("과체중입니다.");
		}

	}

}
