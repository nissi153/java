package java_ex100;
import java.util.Scanner;

public class ex100_98 {

	public static void main(String[] args) {
		//�ٵ����� ��Ȳ ����ϱ�
		//�ٵ���(10 * 10)�� n���� ���� ���´ٰ� �� ��
		//�Է� ���� 
		//5
		//X:1
		//Y:1
		//X:2
		//Y:2
// ���
/*��� ����
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
				board[i][j] = 0; //�ʱ�ȭ
			}
		}
		Scanner scan = new Scanner(System.in);
		System.out.print("n��:");
		int n = scan.nextInt();
		//n�� 10������ �ڿ����̰� 
		//�ٵ� ���� x, y ��ǥ�� 1 ~ 10 ����
		int[][] xy = new int[10][2];
		for(int i=0; i<n; i++) {
			System.out.print("X:");
			xy[i][0] = scan.nextInt();
			System.out.print("Y:");
			xy[i][1] = scan.nextInt();
		}
		for(int i=0; i<n; i++) {
			int x = xy[i][0] - 1; //����� 1->ù��°
			int y = xy[i][1] - 1; //����Ÿ 0->ù��°
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