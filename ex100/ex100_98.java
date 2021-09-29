package java_ex100;
import java.util.Scanner;

public class ex100_98 {

	public static void main(String[] args) {
		//바둑판의 현황 출력하기
		//바둑판(10 * 10)에 n개의 흰돌을 놓는다고 할 때
		//입력 예시 
		//5
		//X:1
		//Y:1
		//X:2
		//Y:2
// 출력
/*출력 예시
1 0 0 0 0 0 0 0 0 0 
0 1 0 0 0 0 0 0 0 0 
0 0 1 0 0 0 0 0 0 0 
0 0 0 1 0 0 0 0 0 0 
0 0 0 0 1 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 
*/		
		int[][] board = new int[10][10];
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				board[i][j] = 0; //초기화
			}
		}
		Scanner scan = new Scanner(System.in);
		System.out.print("n값:");
		int n = scan.nextInt();
		//n은 10이하의 자연수이고 
		//바둑 판의 x, y 좌표는 1 ~ 10 까지
		int[][] xy = new int[10][2];
		for(int i=0; i<n; i++) {
			System.out.print("X:");
			xy[i][0] = scan.nextInt();
			System.out.print("Y:");
			xy[i][1] = scan.nextInt();
		}
		for(int i=0; i<n; i++) {
			int x = xy[i][0] - 1; //사용자 1->첫번째
			int y = xy[i][1] - 1; //데이타 0->첫번째
			board[x][y] = 1;
		}
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}