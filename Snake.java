	
	import java.awt.*;
	import java.awt.event.*;
	import java.util.LinkedList;
	import java.util.Random;
	
	import javax.swing.*;
	
	public class Snake {
		
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
			static JLabel labelMessage; //250ms * 40 column
			static JPanel[][] panels = new JPanel[20][20];
			static int[][] map = new int[20][20]; //fruit pos 9, bomb 8
			static LinkedList<XY> snake = new LinkedList<XY>();
			static int dir = 3; //move direction 0:up,1:down
			                    //2:left,3:right
			static int score = 0; //score
			static int time = 0; //play time
			static int timeCount = 0; //count up by 200ms
			static Timer timer = null; //process movement of snake
			                            //judgement(fruit,crash)
			static int timeCountFruit = 0;
			
			public MyFrame(String title) {
				super(title);
				this.setSize(400,500);
				this.setVisible(true);
				this.setDefaultCloseOperation(
						JFrame.EXIT_ON_CLOSE);
				initUI();
				makeSnakeList();
				startTimer(); //1000ms -> 200ms
				setKeyListener(); //check keyboard event
				makeFruit();
			}
			void removeFruit() {
				for(int i=0; i<20; i++) {
					for(int j=0; j<20; j++) {
						if(map[i][j] == 9) {//fruit
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
				map[randX][randY] = 9; //arrange fruit
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
				//Deduplication - When position is position of fruit, bomb, head of snake, retry get position of Bomb
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
					if(isSnakeBody==true) { //is body of snake?
						isRetry = true;//retry
					}else if(map[randX][randY]==9) { //is fruit,
						isRetry = true; //retry
					}else if(map[randX][randY]==8) { //is bomb,
						isRetry = true;	//retry
					}else {
						isRetry = false;//not retry
					}
					
				}
				
				map[randX][randY] = 8;//install bomb
				
			}
			
			void startTimer() {
				//anonymous class + oveerriding
				timer = new Timer(50, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						timeCount++;
						
						if(score < 500) {
							if(timeCount%5==0) { //move per 250ms
								//10 second 40count*5times
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
							if(timeCount%2==0) { //move per 100ms
								//4sec 40count*2times
								if(timeCount%80 == 0) {
									removeFruit();
									makeFruit();
									removeBomb();
									makeBomb();
								}
								moveSnake();
								updateUI();		
							}
						}else {  			//per 50ms
							//2sec 20count
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
			void updateUI() { //display all UI
				labelTitle.setText("Score:"+score+" Time:"+time+"Sec");
				
				for(int i=0; i<20; i++) {
					for(int j=0; j<20; j++) {
						
						if(map[i][j]==9) { //if fruit,
							panels[i][j].setBackground(Color.CYAN);
						}else if(map[i][j]==8) { //if bomb,
							panels[i][j].setBackground(Color.MAGENTA);
						}else { //normal color
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
				
				if(tailX<tailX2) { //add tail to left
					snake.add(new XY(tailX-1,tailY));
				}
				else if(tailX>tailX2) { //add tail to right
					snake.add(new XY(tailX+1,tailY));
				}
				else if(tailY<tailY2) { //add tail to bottom
					snake.add(new XY(tailX,tailY-1));
				}
				else if(tailY>tailY2) { //add tail to top
					snake.add(new XY(tailX,tailY+1));
				}
			}
			
			// Secondard array  { {1,2,3},    GridLayout  1 2 3  LeftTop
			//                    {4,5,6},                4 5 6
			// Movement of Snake : Move to right  X+, Move to Upper Y+  LeftBottom
			boolean checkCollision(int x, int y) {
				if(x<0 || x>19 || y<0 || y>19) { //Hit Wall
					return true;
				}
				if(map[y][x] == 8) { //Hit Bomb
					return true;
				}
				//if snake head hit self body?
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
					//Collision check : Hit the wall?
					boolean isColl = checkCollision(headX,headY-1);
					if(isColl==true) {
						labelMessage.setText("Collision! Game Over!");
						timer.stop();
						return;
					}
					snake.add(0, new XY(headX,headY-1));
					snake.remove(snake.size()-1);//꼬리 자름.
					
				} else if(dir==1) { //down
					boolean isColl = checkCollision(headX,headY+1);
					if(isColl==true) {
						labelMessage.setText("Collision! Game Over!");
						timer.stop();
						return;
					}
					 
					snake.add(0, new XY(headX,headY+1));
					snake.remove(snake.size()-1);//Crop tail.
					
				} else if(dir==2) { //left
					boolean isColl = checkCollision(headX-1,headY);
					if(isColl==true) {
						labelMessage.setText("Collision! Game Over!");
						timer.stop();
						return;
					}
					snake.add(0, new XY(headX-1,headY));
					snake.remove(snake.size()-1);//Crop tail.
					
				} else if(dir==3){ //right
					boolean isColl = checkCollision(headX+1,headY);
					if(isColl==true) {
						labelMessage.setText("Collision! Game Over!");
						timer.stop();
						return;
					}
					snake.add(0, new XY(headX+1,headY));
					snake.remove(snake.size()-1);//Crop tail.
					
				}
			}
			
			void makeSnakeList() {
				snake.add(new XY(10,10));//First item is Head
				snake.add(new XY(9,10)); //
				snake.add(new XY(8,10)); //Last time is Tail
			}
			
			void initUI() {
				this.setLayout(new BorderLayout());
				
				panelNorth = new JPanel();
				panelNorth.setPreferredSize(new Dimension(400,100));
				panelNorth.setBackground(Color.BLACK);
				panelNorth.setLayout(new FlowLayout());
				
				labelTitle = new JLabel("Score:0 Time:0Sec");
				labelTitle.setPreferredSize(new Dimension(400,50));
				//labelTitle.setFont(new Font("나눔고딕", Font.BOLD, 20));
				labelTitle.setForeground(Color.WHITE);
				labelTitle.setHorizontalAlignment(JLabel.CENTER);
				panelNorth.add(labelTitle);
				
				labelMessage = new JLabel("Get Fruit!");
				labelMessage.setPreferredSize(new Dimension(400,20));
				//labelMessage.setFont(new Font("나눔고딕", Font.BOLD, 20));
				labelMessage.setForeground(Color.YELLOW);
				labelMessage.setHorizontalAlignment(JLabel.CENTER);
				panelNorth.add(labelMessage);
				
				this.add("North",panelNorth);
				
				panelCenter = new JPanel();
				panelCenter.setLayout(new GridLayout(20,20));
				for(int i=0; i<20; i++) { //Row
					for(int j=0; j<20; j++) { //Column
						map[i][j] = 0; //initialize
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
			new MyFrame("Snake Game");
		}
	
	}