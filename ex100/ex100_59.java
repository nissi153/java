package java_ex100;

import java.util.*;

public class ex100_59 {

	public static void main(String[] args) {
		//(�ζ� ���� �ű�� ���)
		//1��	��÷��ȣ 6�� ��ġ
		//2��	��÷��ȣ 5�� ��ġ + ���ʽ���ȣ ��ġ
		//3��	5�� ��ȣ ��ġ
		//4��	4�� ��ȣ ��ġ
		//5��	3�� ��ȣ ��ġ : 5000��
		//��	2�� ���� ��ġ
		//�ζǴ�÷��ȣ 6 + 1(���ʽ�����)
		//�����ȣ 6��
		int[] lotto = {13,23,24,35,40,45};
		int bonus = 7;
		int[] myNumber = {13,23,8,35,40,45};
		
		int count = 0;
		for(int i=0; i<6; i++) { //����ȣ
			for(int j=0; j<6; j++) { //��÷��ȣ
				if( myNumber[i] == lotto[j] ) {
					count++;
				}
			}
		}
		if(count==6) {
			System.out.println("1���÷!");
		}
		else if(count==5) {
			int bonusCount = 0;
			for(int i=0; i<6; i++) {
				if(myNumber[i]==bonus) {
					bonusCount++;
				}
			}
			if(bonusCount>0)
				System.out.println("2���÷");
			else
				System.out.println("3���÷!");
		}
		else if(count==4) {
			System.out.println("4���÷!");
		}
		else if(count==3) {
			System.out.println("5���÷!");
		}
		else {
			System.out.println("��! ������ȸ��~");
		}
		
	}

}