package java_ex100;

public class ex100_49 {

	public static void main(String[] args) {
		// 49번. 30분 되돌리기 / 30분 앞으로 가기 
		
		// 하루 24시간 ( 0시 0분~23시59분 )
		// 시간 60분 (0분~59분)
		
		// 분이 30분이상이면, 시간이 +1됨.
		// 분+30-60 => 분
		
		
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
		System.out.println("30분 이전은 "+new_hour+"시"+new_min+"분");
        
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
		
		System.out.println("30분 이후는 "+new_hour+"시"+new_min+"분");

	}

}
