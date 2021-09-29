package ex100;


//문제83~87번  별찍기 - 반복문(이중)

public class ex100_83 {

	public static void main(String[] args) {
		
		//*****
		//*****
		//*****
		//*****
		//*****
		int n = 5;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//n이 5 이면
		//*
		//**
		//***
		//****
		//*****
		
	}

}
