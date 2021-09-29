package ex100;

public class ex100_85 {

	public static void main(String[] args) {
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
		int n = 5;
		//*****
		// ****
		//  ***
		//   **
		//    *
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int k=0; k<n-i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		

	}

}
