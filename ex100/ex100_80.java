package java_ex100;

public class ex100_80 {

	public static void main(String[] args) {
		//씨저의 암호
		//씨저 암호는 알파벳을 3글자씩 밀려서 쓰면서
		//문장을 만들었다
//암호 - A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
//평문 - X Y Z A B C D E F G H I J K L M N O P Q R S T U V W 
		//입력값: qhyhu wuxvw euxwxv
		//출력값: never trust brutus
		String password = "qhyhu wuxvw euxwxv";
		for(int i=0; i<password.length(); i++) {
			char c = password.charAt(i);
			
			if(c >= 'd' && c <= 'z' ) {
				System.out.print( (char)(c - 3) );
			}
			else if(c >= 'a' && c <= 'c') {
				System.out.println( (char)(c + 23) );
			}
			else { //공백인 경우
				System.out.print(c);
			}
		}
	}

}
