package java_ex100;
import java.util.Scanner;

public class ex100_79 {

	public static void main(String[] args) {
		// 알파벳 대소문자 변환
		//CodeChallenge2014withMSP
		//cODEcHALLENGE2014WITHmsp
		Scanner scan = new Scanner(System.in);
		System.out.println("입력하세요:");
		String str = scan.nextLine();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if( c >= 'a' && c <= 'z') { //영소문자
				System.out.print( (char)(c - 32) );
			}else if( c >= 'A' && c <= 'Z') {//영대문자
				System.out.print( (char)(c + 32) );
			}else { //숫자나 특수문자임.
				System.out.print(c);
			}
			
		}
	}

}
