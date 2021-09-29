package AwtSwing;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.*;

public class SnakeGame2 {
	
	static class MyFrame extends JFrame {
		static class XY {
			int x;
			int y;
			public XY(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
		static JPanel panelNorth;
		static JPanel panelCenter;
		static JLabel labelTitle;
		static JLabel labelMessage; //250ms * 40칸
		static JPanel[][] panels = new JPanel[20][20];
		static int[][] map = new int[20][20]; //과일 위치 9, 폭탄 8
		static LinkedList<XY> snake = new LinkedList<XY>();
		static int dir = 3; //진행방향 0:up,1:down
		                    //2:left,3:right
		static int score = 0; //점수
		static int time = 0; //진행시간
		static int timeCount = 0; //200ms마다 카운트를 센다
		static Timer timer = null; //뱀이 움직임 처리,
		                            //판정(열매,충돌)
		static int timeCountFruit = 0;
		
		public MyFrame(String title) {
			super(title);
			this.setSize(400,500);
			this.setVisible(true);
			this.setDefaultCloseOperation(
					JFrame.EXIT_ON_CLOSE);
			initUI();
			makeSnakeList();
			startTimer(); //1000ms마다 -> 200ms
			setKeyListener(); //키보드 이벤트 체크
			makeFruit();
		}
		void removeFruit() {
			for(int i=0; i<20; i++) {
				for(int j=0; j<20; j++) {
					if(map[i][j] == 9) {//과일
						map[i][j] = 0;
					}
				}
			}
		}
		void removeBomb() {
			for(int i=0; i<20; i++) {
				for(int j=0; j<20; j++) {
					if(map[i][j] == 8) {//폭탄 제거
						map[i][j] = 0;
					}
				}
			}
		}
		void makeFruit() {
			Random rand = new Random();
			//0~19, 0~19
			int randX = rand.nextInt(20);
			int randY = rand.nextInt(20);
			map[randX][randY] = 9; //과일 배치!
		}
		void setKeyListener() {
			this.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_UP) {
						if(dir!=1)//down
							dir = 0;
					}
					else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
						if(dir!=0)
							dir = 1;
					}
					else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
						if(dir!=3)
							dir = 2;
					}
					else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
						if(dir!=2)
							dir = 3;
					}
				}
			});
		}
		void makeBomb() {
			Random rand = new Random();
			int randX = 0;
			int randY = 0;
			//중복제거 - 과일,폭탄,뱀의 머리,몸체일때 다시 추첨
			boolean isRetry = true;
			while(isRetry) {
				randX = rand.nextInt(20);
				randY = rand.nextInt(20);
				boolean isSnakeBody = false;
				for(XY xy : snake) {
					if(xy.x == randX && xy.y == randY) {
						isSnakeBody = true;
					}
				}
				if(isSnakeBody==true) { //뱀의 몸체인가?
					isRetry = true;//재추첨함
				}else if(map[randX][randY]==9) { //과일이면,
					isRetry = true; //재추첨함
				}else if(map[randX][randY]==8) { //폭탄이면,
					isRetry = true;	//재추첨함
				}else {
					isRetry = false;//재추첨 안함
				}
				
			}
			
			map[randX][randY] = 8;//폭탄 설치
			
		}
		
		void startTimer() {
			//익명클래스+오버라이딩
			timer = new Timer(50, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					timeCount++;
					
					if(score < 500) {
						if(timeCount%5==0) { //250ms마다 움직임
							//10초 40카운트*5배
							if(timeCount%200 == 0) {
								removeFruit();
								makeFruit();
								removeBomb();
								makeBomb();
							}
							moveSnake();
							updateUI();		
						}
					}else if(score < 1000) {
						if(timeCount%2==0) { //100ms마다 움직임
							//4초 40카운트*2배
							if(timeCount%80 == 0) {
								removeFruit();
								makeFruit();
								removeBomb();
								makeBomb();
							}
							moveSnake();
							updateUI();		
						}
					}else {  			//50ms마다
						//2초 20카운트
						if(timeCount%50 == 0) {
							removeFruit();
							makeFruit();
						}
						moveSnake();
						updateUI();
					}
					
				}
			});
			timer.start();
		}
		void updateUI() { //모든 UI 표현!
			labelTitle.setText("점수:"+score+"점 시간:"+time+"초");
			
			for(int i=0; i<20; i++) {
				for(int j=0; j<20; j++) {
					
					if(map[i][j]==9) { //과일이면,
						panels[i][j].setBackground(Color.CYAN);
					}else if(map[i][j]==8) { //폭탄이면,
						panels[i][j].setBackground(Color.MAGENTA);
					}else { //일반색
						panels[i][j].setBackground(Color.GRAY);
					}
				}
			}
			
			int index = 0;
			boolean addTail = false;
			for(XY xy : snake) {
				if(index==0) { //Head
					panels[xy.y][xy.x].setBackground(Color.RED);
					if(map[xy.y][xy.x]==9) {
						map[xy.y][xy.x] = 0;
						makeFruit();
						score += 100;
						addTail = true;
					}
					
				}else { //Body,Tail
					panels[xy.y][xy.x].setBackground(Color.BLUE);
				}
				index++;
			}
			if(addTail==true)
				addTail();
		}
		void addTail() {
			int tailX = snake.get(snake.size()-1).x;
			int tailY = snake.get(snake.size()-1).y;
			int tailX2 = snake.get(snake.size()-2).x;
			int tailY2 = snake.get(snake.size()-2).y;
			
			if(tailX<tailX2) { //왼쪽에 붙임.
				snake.add(new XY(tailX-1,tailY));
			}
			else if(tailX>tailX2) { //오른쪽에 붙임
				snake.add(new XY(tailX+1,tailY));
			}
			else if(tailY<tailY2) { //밑에 붙임
				snake.add(new XY(tailX,tailY-1));
			}
			else if(tailY>tailY2) { //위에 붙임
				snake.add(new XY(tailX,tailY+1));
			}
		}
		
		// 이차배열  { {1,2,3},    GridLayout  1 2 3  LeftTop
		//             {4,5,6},                4 5 6
		// 뱀의 이동 : 오른쪽이동 X+, 위로 이동 Y+  LeftBottom
		boolean checkCollision(int x, int y) {
			if(x<0 || x>19 || y<0 || y>19) { //벽에 부딪힘.
				return true;
			}
			if(map[y][x] == 8) { //폭탄에 충돌함.
				return true;
			}
			//뱀의 Body에 부딪혔는가?
			for(XY xy : snake) {
				if(x == xy.x && y == xy.y) {
					return true;
				}
			}
			return false;
		}
		void moveSnake() {
			XY headXY = snake.get(0);
			int headX = headXY.x;
			int headY = headXY.y;
			
			if(dir==0) { //up
				//충돌체크 : 벽에 부딛혔는가?
				boolean isColl = checkCollision(headX,headY-1);
				if(isColl==true) {
					labelMessage.setText("충돌! 게임종료!");
					timer.stop();
					return;
				}
				snake.add(0, new XY(headX,headY-1));
				snake.remove(snake.size()-1);//꼬리 자름.
				
			} else if(dir==1) { //down
				boolean isColl = checkCollision(headX,headY+1);
				if(isColl==true) {
					labelMessage.setText("충돌! 게임종료!");
					timer.stop();
					return;
				}
				 
				snake.add(0, new XY(headX,headY+1));
				snake.remove(snake.size()-1);//꼬리 자름.
				
			} else if(dir==2) { //left
				boolean isColl = checkCollision(headX-1,headY);
				if(isColl==true) {
					labelMessage.setText("충돌! 게임종료!");
					timer.stop();
					return;
				}
				snake.add(0, new XY(headX-1,headY));
				snake.remove(snake.size()-1);//꼬리 자름.
				
			} else if(dir==3){ //right
				boolean isColl = checkCollision(headX+1,headY);
				if(isColl==true) {
					labelMessage.setText("충돌! 게임종료!");
					timer.stop();
					return;
				}
				snake.add(0, new XY(headX+1,headY));
				snake.remove(snake.size()-1);//꼬리 자름.
				
			}
		}
		
		void makeSnakeList() {
			snake.add(new XY(10,10));//첫번요소 Head
			snake.add(new XY(9,10)); //
			snake.add(new XY(8,10)); //끝번 요소 TAIL
		}
		
		void initUI() {
			this.setLayout(new BorderLayout());
			
			panelNorth = new JPanel();
			panelNorth.setPreferredSize(new Dimension(400,100));
			panelNorth.setBackground(Color.BLACK);
			panelNorth.setLayout(new FlowLayout());
			
			labelTitle = new JLabel("점수:0점 시간:0초");
			labelTitle.setPreferredSize(new Dimension(400,50));
			labelTitle.setFont(new Font("나눔고딕", Font.BOLD,
					20));
			labelTitle.setForeground(Color.WHITE);
			labelTitle.setHorizontalAlignment(JLabel.CENTER);
			panelNorth.add(labelTitle);
			
			labelMessage = new JLabel("과일을 먹으세요!");
			labelMessage.setPreferredSize(new Dimension(400,20));
			labelMessage.setFont(new Font("나눔고딕", Font.BOLD,
					20));
			labelMessage.setForeground(Color.YELLOW);
			labelMessage.setHorizontalAlignment(JLabel.CENTER);
			panelNorth.add(labelMessage);
			
			this.add("North",panelNorth);
			
			panelCenter = new JPanel();
			panelCenter.setLayout(new GridLayout(20,20));
			for(int i=0; i<20; i++) { //행 - 세로
				for(int j=0; j<20; j++) { //열 - 가로
					map[i][j] = 0; //초기화
					panels[i][j] = new JPanel();
					panels[i][j].setPreferredSize(new Dimension(20,20));
					panels[i][j].setBackground(Color.GRAY);
					panelCenter.add(panels[i][j]);
				}
			}
			this.add("Center", panelCenter);
			this.pack();
			
		}
	}
	public static void main(String[] args) {
		new MyFrame("스네이크 게임");
	}

}
