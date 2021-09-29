package ex100;

public class ex100_84 {

	public static void main(String[] args) {
		//*****
		//*****
		//*****
		//*****
		//*****
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
		//n이 5이면
		//*****
		//****
		//***
		//**
		//*
		int n = 3;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
