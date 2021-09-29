package ex100;

public class ex100_87 {

	public static void main(String[] args) {
		//사각형 출력
		//*****
		//*   *
		//*   *
		//*   *
		//*****
		int n = 5;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==0 || i== n-1) {
					System.out.print("*");
				}
				else {
					if(j==0 || j == n-1) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
		System.out.println();
		
		//n이 주어졌을때
		// *****
		//    *
		//   *
		//  *
		// *****
		n = 5;
		for(int i=0; i<n; i++) {
			
			if(i==0 || i== n-1) {
				for(int j=0; j<n; j++) {
				System.out.print("*");
				}
			}
			else {
				for(int k=1; k<n-i; k++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
			
			System.out.println();
		}
		System.out.println();
	}

}
