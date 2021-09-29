package java_ex100;
import java.util.Scanner;

public class ex100_97 {
	public static void main(String[] args) {
		// 키 작은 순서대로 자리배치 하기
		//학생의 키순서대로 자리를 배치하는 
		//프로그램을 작성하시오
		//160, 165, 164, 165, 150, 165, 168, 145, 170
		//입력 예시 
		//9 <- 입력학생수(1~99)
		//6 <- 자릿수(1~10)
		//160 
		//165 
		//164 
		//145 150 160 164 165 165 
  		//165 168 170 오름차순 정렬!
		Scanner scan = new Scanner(System.in);
		System.out.println("입력하세요:");
		int studentCount = scan.nextInt();
		int placeCount = scan.nextInt();
		int[] heigth = new int[100];
		for(int i=0; i<studentCount; i++) {
			heigth[i] = scan.nextInt();
		}
		//오름차순 정렬
		for(int i=0; i<studentCount; i++) {
			for(int j=i+1; j<studentCount; j++) {
				if(heigth[i]>heigth[j]) { //치환
					int temp = heigth[i];
					heigth[i] = heigth[j];
					heigth[j] = temp;
				}
			}
		}
		
		for(int i=0; i<studentCount; i++) {
			System.out.print(heigth[i]+",");
			
			if(i!= 0 && (i+1)%placeCount == 0)
				System.out.println();
		}
		
	}

}