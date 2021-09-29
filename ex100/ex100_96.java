package java_ex100;
import java.util.Scanner;

public class ex100_96 {
	public static void main(String[] args) {
		//성적순 학생이름 출력하기
		//세번째 높은 성적의 학생을 출력하기
		//입력 (최대 50명)
		//5
		//minsu
		String[][] students = new String[50][2];
		//{ {"이름","성적"},
		//  {"이름","성적"},
		//}
		Scanner scan = new Scanner(System.in);
		int n = 5;
		for(int i=0; i<5; i++) {
			students[i][1] = scan.next();
			students[i][0] = scan.next();
		}
		//내림차순 정렬(성적이 높은 순으로 정렬)
		for(int i=0; i<5; i++) {
			for(int j=i+1; j<5; j++) {
				int score1 = Integer.parseInt(students[i][1]);
				int score2 = Integer.parseInt(students[j][1]);
				if(score2>score1) { //치환해야 됨.
					String temp1 = students[i][0];
					String temp2 = students[i][1];
					students[i][0] = students[j][0];//이름
					students[i][1] = students[j][1];//성적
					students[j][0] = temp1;
					students[j][1] = temp2;
				}
			}
		}
		System.out.println("세번째 학생은");
		System.out.println(students[2][0]);
		System.out.println(students[2][1]);
	}

}