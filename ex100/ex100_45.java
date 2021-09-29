package javastudy_basic_ex100;

import java.util.Scanner;

public class ex100_45 {

	public static void main(String[] args) {
		double a, b, c;                       // 이차방정식의세계수

        double x1, x2;                       // 이차방정식의두근

        double d;                                         // 판별식

        

        Scanner sc=new Scanner(System.in);

        System.out.print("a입력:");

        a=sc.nextInt();

        System.out.print("b입력:");

        b=sc.nextInt();

        System.out.print("c입력:");

        c=sc.nextInt();



        // 판별식계산

        d = b * b - 4.0 * a * c;



        // 두실근을가지는경우는포물선이x 축과두점에서만나는경우임

        if ( d > 0 )

        {

                  x1 = ( -b + Math.sqrt(d) ) / ( 2.0 * a );

                  x2 = ( -b - Math.sqrt(d) ) / ( 2.0 * a );

                  System.out.println("2개의 실근 "+x1+","+x2+"을 갖고");

                  System.out.println("x 축과의교점사이의거리는 "+(x1-x2)+"입니다.");

        }

        // 중근을가지는경우는x 축과한점에서만나는경우임

        else if ( d == 0 )

        {

                  x1 = -b / ( 2.0 * a );

                  System.out.println("1개의 실근 "+x1+"을 갖고");

                  System.out.println("x 축과한점에서만나고꼭지점의좌표는("+x1+", 0.0) 입니다");

        }

        // 허근을가지는경우는x축과만나지않는경우임

        else

        {

                  x1 = ( -b / (2.0 * a) );

                  System.out.println("2개의 허근을 갖고");

                  System.out.println("x 축과만나지않고꼭지점의좌표는("+x1+", "+(a*x1*x1 + b*x1 + c)+") 입니다.");

        }

	}

}
