package java_ex100ex100;
import java.util.Scanner;

public class ex100_34 {

	public static void main(String[] args) {
//		0�� �ƴϸ� �Էµ� ������ ����ϰ�
//		0�� �ԷµǸ� ����� �ߴ��غ���.
		Scanner scan = new Scanner(System.in);
		
		//���ѹݺ���
//		while( true ) {
//			System.out.println("run..");
//		}
//		for( ; ; ) {
//			System.out.println("run..");
//		}
		
		while(true) {
			System.out.print("���ڸ� �Է����ּ���>");
			int num = scan.nextInt();
			if(num!=0) {
				System.out.println(num);
				continue;
			}else {
				System.out.println(num+"����");
				break;
			}
		}
	}

}
