package java_ex100;
import java.util.Scanner;

public class ex100_70 {
	public static void main(String[] args) {
                //��� �� �����ϱ�
                //2 6 18 54 162 486 ... �� 2���� ������ 
                //������ ���� ���� 3�� ���� ���� ���� ���� ����
                //���� ��(a), ����� ��(r), �� ��°����(n)�� �Էµ� ��
                //n��° ���� ����ϴ� ���α׷��� ������
                //a a*r a*r*r a*r*r*r  a*r*r*r*r
                //0  1   2    3		  4
                // sum = sum + i;
                // sum = sum * r;		
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		int multiSum = num1;
		for(int i=0; i<num3; i++) {
			multiSum = multiSum * num2;
			System.out.println(multiSum);
		}
		
	}

}
