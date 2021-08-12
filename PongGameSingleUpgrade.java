import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

//Online Game - Communication Basic
// TCP/IP Socket - NIO Async 

public class PongGameSingleUpgrade {
	static class MyFrame extends JFrame {
		static class MyPanel extends JPanel { //Canvas for Graphics
			public MyPanel() {
				this.setSize(800, 400);
				this.setBackground(Color.BLACK);
			}
			public void paint(Graphics g) {
				super.paint(g);
				Graphics2D g2d = (Graphics2D)g;
				g2d.setColor(Color.WHITE);
				g2d.fillRect(barLeftPos.x, barLeftPos.y, 20, barHeight);
				g2d.fillRect(barRightPos.x, barRightPos.y, 20, barHeight);
				g2d.setFont(new Font("TimesRoman", Font.BOLD, 50));
				g2d.drawString(scoreLeft + " vs " + scoreRight, 400-50, 50);
				g2d.fillOval(ballPos.x, ballPos.y, 20, 20);
			}
		}
		//variables
		static Timer timer = null;
		static int dir = 0; //0=>Up-Right, 1=>Down-Right, 2=>Up-Left, 3=>Down-Left
		static Point ballPos = new Point(400-10, 200-10);
		//static int ballSpeed = 2; //2px per 1 timer
		static final int BALL_SPEED = 5;
		static float ballSpeedX = BALL_SPEED;
		static float ballSpeedY = BALL_SPEED;
		static int ballWidth = 20;
		static int ballHeight = 20;
		static int barHeight = 80;
		static Point barLeftPos = new Point(50, 200-40);
		static Point barRightPos = new Point(800-50-20, 200-40);
		static int barLeftYTarget = barLeftPos.y; //Target Value - interpolation
		static int barRightYTarget = barRightPos.y; //Target Value - interpolation
		static MyPanel myPanel = null;
		static int scoreLeft = 0;
		static int scoreRight = 0;
		
		public MyFrame(String title) {
			super(title);
			this.setVisible(true);
			this.setSize(800, 400);
			this.setLayout(new BorderLayout());
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			myPanel = new MyPanel();
			this.add( "Center", myPanel);
			
			setKeyListener();
			startTimer();
		}
		public void setKeyListener() {
			this.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) { //Key Event
					if( e.getKeyCode() == KeyEvent.VK_UP ) {
						System.out.println("Pressed Up Key.");
						barLeftYTarget -= 20;
						if(barLeftPos.y < barLeftYTarget) {
							barLeftYTarget = barLeftPos.y - 20;
						}
						barRightYTarget -= 20;
						if(barRightPos.y < barRightYTarget) {
							barRightYTarget = barRightPos.y - 20;
						}
					}
					else if( e.getKeyCode() == KeyEvent.VK_DOWN ) {
						System.out.println("Pressed Down Key.");
						barLeftYTarget += 20;
						if(barLeftPos.y > barLeftYTarget) {
							barLeftYTarget = barLeftPos.y + 20;
						}
						barRightYTarget += 20;
						if(barRightPos.y > barRightYTarget) {
							barRightYTarget = barRightPos.y + 20;
						}
					}
				}
			});
		}
		public void startTimer() {
			timer = new Timer(20, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) { //Timer Event
					if(barLeftPos.y > barLeftYTarget) {
						barLeftPos.y -= 5;
					}else if(barLeftPos.y < barLeftYTarget) {
						barLeftPos.y += 5;
					}
					if(barRightPos.y > barRightYTarget) {
						barRightPos.y -= 5;
					}else if(barRightPos.y < barRightYTarget) {
						barRightPos.y += 5;
					}
					if(dir==0) { //0=>Up-Right
						ballPos.x += ballSpeedX;
						ballPos.y -= ballSpeedY;
					}else if(dir==1) { //1=>Down-Right
						ballPos.x += ballSpeedX;
						ballPos.y += ballSpeedY;
					}else if(dir==2) { //2=>Up-Left
						ballPos.x -= ballSpeedX;
						ballPos.y -= ballSpeedY;
					}else if(dir==3) { //3=>Down-Left
						ballPos.x -= ballSpeedX;
						ballPos.y += ballSpeedY;
					}
					checkCollision();
					myPanel.repaint(); //Re-Draw
				}
			});
			timer.start(); //Start Timer!
		}
		public void setSpeed( Point barPos ) {
			int barCenterY = barPos.y + (barHeight/2); 
			int ballCenterY = ballPos.y + 10;
			
			float offset = Math.abs( barCenterY - ballCenterY);
			//                  0:Center ~ 40:Border  / 40 => 0.0 ~ 1.0
			float offsetRate = (offset * 1.5f) / (barHeight/2);
			if( offsetRate < 0.1f )
				offsetRate = 0.1f;
			if( offsetRate > 1.5f)
				offsetRate = 1.5f;
			ballSpeedY = BALL_SPEED * offsetRate;
			if( ballSpeedY < 1)
				ballSpeedY = 1;
			
		}
		
		public void checkCollision() {
			if(dir==0) { //0=>Up-Right
				if(ballPos.y < 0) {
					dir = 1;
				}
				if(ballPos.x>800-ballWidth) {
					dir = 2;
					scoreLeft += 1;
				}
				if(ballPos.x > barRightPos.x-ballWidth &&
				   (ballPos.y>=barRightPos.y&&ballPos.y<=barRightPos.y + barHeight) 	) {
					dir = 2;
					setSpeed( barRightPos );
				}
			}else if(dir==1) { //1=>Down-Right
				if(ballPos.y > 400-ballHeight-20) {
					dir = 0;
				}
				if(ballPos.x > 800-ballWidth) {
					dir = 3;
					scoreLeft += 1;
				}
				if(ballPos.x > barRightPos.x-ballWidth &&
			       (ballPos.y>=barRightPos.y&&ballPos.y<=barRightPos.y + barHeight) ) {
					dir = 3;
					setSpeed( barRightPos );
				}
			}else if(dir==2) { //2=>Up-Left
				if(ballPos.y < 0) {
					dir = 3;
				}
				if(ballPos.x < 0) {
					dir = 0;
					scoreRight += 1;
				}
				if(ballPos.x < barLeftPos.x+ballWidth &&
					(ballPos.y>=barLeftPos.y&&ballPos.y<=barLeftPos.y + barHeight) ) {
					dir = 0;
					setSpeed( barLeftPos );
				}
			}else if(dir==3) { //3=>Down-Left
				if(ballPos.y > 400-ballHeight-20) {
					dir = 2;
				}
				if(ballPos.x < 0) {
					dir = 1;
					scoreRight += 1;
				}
				if(ballPos.x < barLeftPos.x+ballWidth &&
					(ballPos.y>=barLeftPos.y&&ballPos.y<=barLeftPos.y + barHeight) ) {
					dir = 1;
					setSpeed( barLeftPos );
				}
			}
		}
	}

	public static void main(String[] args) {
		new MyFrame("Pong Game Single");
	}

}
