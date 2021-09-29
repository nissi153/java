package java_ex100;
public class ex100_45 {

	public static void main(String[] args) {
		// 45번 이차방정식의 해  
		double a = 1;        
		double b = 7;
		double c = 3;
		// ax2 + bx + c = 0
		System.out.println( 1 * (-0.46) * -0.46 + 7 * (-0.46) + 3); 
		
		double D = b * b - 4 * a * c;  //허근을 판별하기 위한 변수
		
		if (D < 0) {
			System.out.println("값이 존재하지 않음.");
		}
		else if (D == 0) {
			double x1 = -b /(2*a);
			System.out.println("방정식의 해는 "+x1);
		}
		else if (D > 0) { 
			double x1 = ((-b) + Math.sqrt(D) ) / (2 * a);
			double x2 = ((-b) - Math.sqrt(D) ) / (2 * a);
			System.out.printf("방정식의 해는 %.02f\n",x1);
			System.out.printf("방정식의 해는 %.02f\n",x2);
		}
	}

}
