package java_ex100;

import java.util.Scanner;

public class ex100_43 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("�ѱ۷� ��ȯ�� ���� �Է��ϼ���:");
		int number = scan.nextInt();
		
		int[] nums = new int[5];
		
		//12345	�ϸ� ��õ ��� ��� ��
		nums[0] = number / 10000; //���� �ڸ� ��
		nums[1] = (number / 1000) % 10; //õ�� �ڸ� ��
		nums[2] = (number / 100) % 10; //���� �ڸ� ��
		nums[3] = (number / 10) % 10; //���� �ڸ� ��
		nums[4] = number % 10; //���� �ڸ� ��
		
		String sum_str = "";
		for(int i=0; i<5; i++) {
			if(nums[i] == 1) {
				sum_str += "��";
			}else if(nums[i] == 2) {
				sum_str += "��";
			}else if(nums[i] == 3) {
				sum_str += "��";
			}else if(nums[i] == 4) {
				sum_str += "��";
			}else if(nums[i] == 5) {
				sum_str += "��";
			}else if(nums[i] == 6) {
				sum_str += "��";
			}else if(nums[i] == 7) {
				sum_str += "ĥ";
			}else if(nums[i] == 8) {
				sum_str += "��";
			} else if(nums[i] == 9) {
				sum_str += "��";
			}  
			
			if(i==0 && nums[0]>=1) {//���� �ڸ����� ���ڰ� �ִٸ�,
				sum_str += "��";
			}
			if(i==1 && nums[1]>=1) {//ù�� �ڸ����� ���ڰ� �ִٸ�,
				sum_str += "õ";
			}
			if(i==2 && nums[2]>=1) {//���� �ڸ����� ���ڰ� �ִٸ�,
				sum_str += "��";
			}
			if(i==3 && nums[3]>=1) {//���� �ڸ����� ���ڰ� �ִٸ�,
				sum_str += "��";
			}
			System.out.println(sum_str);
		}
		//"�ϸ���õ�����"
		System.out.println(sum_str);

	}

}
