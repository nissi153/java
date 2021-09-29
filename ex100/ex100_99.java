package java_ex100;

import java.util.Scanner;

public class ex100_99 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("로테이션 할 횟수를 입력해주세요>");
		int lotation = scan.nextInt();
		
		int[] arr = new int [5];
		
		for(int i = 0; i<5; i++) {  // 배열에 입력한 숫자를 저장한다.
			System.out.print("숫자를 입력해주세요>");
			int num = scan.nextInt();
			arr[i] = num;
		}
		
		for(int a = 0; a<lotation; a++) {
			
			int tmp = 0;
			for(int i = 0; i<5; i++) {
				if((i+1)==5) {
					/*tmp = arr[i];
				arr[i] = arr[0];    // 인덱스가 5인 경우 조치가 필요 없으므로 비워놨음.
				arr[0] = tmp;*/
				}else {
					tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
				}
				System.out.print(arr[i]);
			}
			System.out.println();
			
		}
		
		
	}

}