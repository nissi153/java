package java_ex100;

public class ex100_49 {

	public static void main(String[] args) {
		// 49��. 30�� �ǵ����� / 30�� ������ ���� 
		
		// �Ϸ� 24�ð� ( 0�� 0��~23��59�� )
		// �ð� 60�� (0��~59��)
		
		// ���� 30���̻��̸�, �ð��� +1��.
		// ��+30-60 => ��
		
		
		int hour = 13;
		int min = 40;
		
		int new_hour = 0;
		int new_min = 0;
		
		if( min < 30 ) {
			new_min = min + 60 - 30;
			if(hour<1) {
				new_hour = 23;
			}else {
				new_hour = hour - 1;
			}
		}else {
			new_hour = hour;
			new_min = min - 30;
		}
		System.out.println("30�� ������ "+new_hour+"��"+new_min+"��");
        
		new_hour = 0;
		new_min = 0;
		if( min >= 30 ) {
			new_min = min - 60 + 30;
			if(hour>=23) {
				new_hour = 0;
			}else {
				new_hour = hour + 1;
			}
		}else {
			new_hour = hour;
			new_min = min + 30;
		}
		
		System.out.println("30�� ���Ĵ� "+new_hour+"��"+new_min+"��");

	}

}
