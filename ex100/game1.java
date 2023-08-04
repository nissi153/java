import java.util.Scanner;

class MyPlayer {
    int xpos = 1;
    int ypos = 1;
}

public class game1 {
    //게임설명
    //바둑판(15 * 15)에 맵 지도를 만들고, ●는 캐릭터를 의미하고,
    //  ■는 벽을 의미하고, ★는 목표지점으르 의미합니다.
    //캐릭터는 벽을 통과하지 못하고,
    //  사용자의 상하좌우 명령에 따라 이동해서, 목표지점에 도달해야 합니다.

    //입력
    //키보드의 입력에서 A키는 좌로 한칸, D는 우로 한칸,
    //  W는 위로 한칸, S는 아래로 한칸 이동합니다.
    //또는 자동으로 경로찾기 알고리즘을 통해 이동시킬 수도 있습니다.

    //출력
    //매 키보드 입력마다 맵을 출력하고 캐릭터의 위치와 목표지점을 출력합니다.
    //목표지점에 도달 했으면, 목표지점 ★을 지우고, GOAL IN!!!을 출력합니다.

    // 0:빈칸 1:벽 2:사람 3:골인
    static int[][] map = {
            //map[1][1] = 2  => "d"키입력 =>  map[1][1] = 0, map[1][2] = 2
            //                                   x  y           x  y+1
            //map[1][1] = 2  => "s"키입력 =>  map[1][1] = 0, map[2][1] = 2
            //                                   x  y           x+1 y

            //col 0 1 2
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, //row 0
            {1,2,0,1,0,0,0,0,0,0,0,0,0,0,1}, //1
            {1,0,0,1,0,0,1,1,1,1,1,1,0,0,1}, //2
            {1,0,0,1,0,0,0,0,0,0,0,1,0,0,1},
            {1,0,0,1,1,1,1,1,1,0,0,1,0,0,1},
            {1,0,0,1,0,0,0,0,1,0,0,1,0,0,1},
            {1,0,0,1,0,0,0,0,1,0,0,1,0,0,1},
            {1,0,0,1,0,0,0,0,1,0,0,1,0,0,1},
            {1,0,0,1,0,0,0,0,1,0,0,1,0,0,1},
            {1,0,0,1,0,0,0,0,1,0,0,1,0,0,1},
            {1,0,0,0,0,0,0,0,1,0,0,1,0,0,1},
            {1,0,0,1,0,0,0,0,1,0,0,1,0,0,1},
            {1,0,0,1,0,0,0,0,1,0,0,1,0,0,1},
            {1,0,0,1,0,0,0,0,0,0,0,1,3,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    };
    static MyPlayer player = new MyPlayer();
    static void dispMap(){
        for (int i=0; i<map.length; i++){
            for (int j=0; j<map[i].length; j++){
                if( map[i][j] == 0 ){
                    System.out.print(" ");
                }
                else if( map[i][j] == 1 ){
                    System.out.print("■");
                }
                else if( map[i][j] == 2 ){
                    System.out.print("●");
                }
                else {
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    //빈칸 1, 골인 2, 벽은 0을 반환
    static int checkBlank(String input) {
        int xpos = 0;
        int ypos = 0;
        if (input.equals("a")) { //Left
            xpos = player.xpos - 1;
            ypos = player.ypos;
        } else if (input.equals("d")) { //Right
            xpos = player.xpos + 1;
            ypos = player.ypos;
        } else if (input.equals("w")) { //Up
            xpos = player.xpos;
            ypos = player.ypos - 1;
        } else if (input.equals("s")) { //Down
            xpos = player.xpos;
            ypos = player.ypos + 1;
        }
        //xy좌표와 행열은 앞뒤가 바뀐다.
        if (map[ypos][xpos] == 0){ //빈칸인가?
            return 1;
        }else if(map[ypos][xpos] == 3) { //골인인가?
            System.out.println("골인!");
            return 2;
        }else {
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1.맵 초기화 (빈칸,벽,사람,골인 설정)

        while( true ) {
            //2.맵 데이타 출력
            dispMap();

            //3.키보드 입력
            String input = scanner.nextLine();

            //5.판별로직
            //4.키보드 입력에 따른 맵 데이타 변경
            if (input.equals("a")) { //Left
                if (checkBlank("a") == 1) {
                    //map[][] 행열의 데이타와 xy좌표 데이타가 인덱스가 거꾸로다.
                    map[player.ypos][player.xpos] = 0; //빈칸
                    int newXpos = player.xpos - 1;
                    map[player.ypos][newXpos] = 2; //주인공
                    player.xpos = newXpos;
                }
                if (checkBlank("a") == 2) {
                    //골인
                    map[player.ypos][player.xpos] = 0; //빈칸
                    int newXpos = player.xpos - 1;
                    map[player.ypos][newXpos] = 2; //주인공
                    break;
                }
            } else if (input.equals("d")) { //Right
                if (checkBlank("d") == 1) {
                    //map[][] 행열의 데이타와 xy좌표 데이타가 인덱스가 거꾸로다.
                    map[player.ypos][player.xpos] = 0; //빈칸
                    int newXpos = player.xpos + 1;
                    map[player.ypos][newXpos] = 2; //주인공
                    player.xpos = newXpos;
                }
                if (checkBlank("d") == 2) {
                    //map[][] 행열의 데이타와 xy좌표 데이타가 인덱스가 거꾸로다.
                    map[player.ypos][player.xpos] = 0; //빈칸
                    int newXpos = player.xpos + 1;
                    map[player.ypos][newXpos] = 2; //주인공
                    player.xpos = newXpos;
                    break;
                }
            } else if (input.equals("w")) { //Up
                if (checkBlank("w") == 1) {
                    //map[][] 행열의 데이타와 xy좌표 데이타가 인덱스가 거꾸로다.
                    map[player.ypos][player.xpos] = 0; //빈칸
                    int newYPos = player.ypos - 1;
                    map[newYPos][player.xpos] = 2; //주인공
                    player.ypos = newYPos;
                }
                if (checkBlank("w") == 2) {
                    //map[][] 행열의 데이타와 xy좌표 데이타가 인덱스가 거꾸로다.
                    map[player.ypos][player.xpos] = 0; //빈칸
                    int newYPos = player.ypos - 1;
                    map[newYPos][player.xpos] = 2; //주인공
                    player.ypos = newYPos;
                    break;
                }
            } else if (input.equals("s")) { //Down
                if (checkBlank("s") == 1) {
                    //map[][] 행열의 데이타와 xy좌표 데이타가 인덱스가 거꾸로다.
                    map[player.ypos][player.xpos] = 0; //빈칸
                    int newYPos = player.ypos + 1;
                    map[newYPos][player.xpos] = 2; //주인공
                    player.ypos = newYPos;
                }
                if (checkBlank("s") == 2) {
                    //map[][] 행열의 데이타와 xy좌표 데이타가 인덱스가 거꾸로다.
                    map[player.ypos][player.xpos] = 0; //빈칸
                    int newYPos = player.ypos + 1;
                    map[newYPos][player.xpos] = 2; //주인공
                    player.ypos = newYPos;
                    break;
                }
            }

        }

    }
}
