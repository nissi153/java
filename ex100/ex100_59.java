package java_ex100;

import java.util.*;

public class ex100_59 {

	public static void main(String[] args) {
		//(로또 순위 매기는 방법)
		//1등	당첨번호 6개 일치
		//2등	당첨번호 5개 일치 + 보너스번호 일치
		//3등	5개 번호 일치
		//4등	4개 번호 일치
		//5등	3개 번호 일치 : 5000원
		//꽝	2개 이하 일치
		//로또당첨번호 6 + 1(보너스점수)
		//주희번호 6개
		int[] lotto = {13,23,24,35,40,45};
		int bonus = 7;
		int[] myNumber = {13,23,8,35,40,45};
		
		int count = 0;
		for(int i=0; i<6; i++) { //내번호
			for(int j=0; j<6; j++) { //당첨번호
				if( myNumber[i] == lotto[j] ) {
					count++;
				}
			}
		}
		if(count==6) {
			System.out.println("1등당첨!");
		}
		else if(count==5) {
			int bonusCount = 0;
			for(int i=0; i<6; i++) {
				if(myNumber[i]==bonus) {
					bonusCount++;
				}
			}
			if(bonusCount>0)
				System.out.println("2등당첨");
			else
				System.out.println("3등당첨!");
		}
		else if(count==4) {
			System.out.println("4등당첨!");
		}
		else if(count==3) {
			System.out.println("5등당첨!");
		}
		else {
			System.out.println("꽝! 다음기회에~");
		}
		
	}

}