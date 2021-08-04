package AwtSwing;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

//이미 열린 카드는 다시 누르지 못하게 처리.
//1분안에 

public class BingoGame {
	static JPanel panelNorth; //컨트롤+이름
	static JPanel panelCenter;
	static JLabel labelMessage;
	static JButton[] buttons = new JButton[16]; 
	static String[] images = { 
			"fruit01.png","fruit02.png","fruit03.png","fruit04.png",
			"fruit05.png","fruit06.png","fruit07.png","fruit08.png",
			"fruit01.png","fruit02.png","fruit03.png","fruit04.png",
			"fruit05.png","fruit06.png","fruit07.png","fruit08.png",
			};
	static int openCount = 0;//열린카드 인덱스
	static int buttonIndexSave1 = 0; //첫번째카드 인덱스
	static int buttonIndexSave2 = 0; //두번째카드 인덱스
	static Timer timer;
	static int tryCount = 0; //시도횟수
	static int successCount = 0; //빙고 카운트
	
	static ImageIcon changeImage(String filename) {
		ImageIcon icon = new ImageIcon("./img/"+filename);
		Image originImage = icon.getImage();
		Image changedImage = 
	originImage.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		ImageIcon icon_new = new ImageIcon(changedImage);
		return icon_new;
	}
	
	static class MyFrame extends JFrame 
		implements ActionListener
	{
		static void playSound(String filename) {
			// ./wav/aaa.wav
			File file = new File( "./wav/"+filename );
			if( file.exists() ) {
				try { 
					AudioInputStream stream = 
							AudioSystem.getAudioInputStream(file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					//clip.loop(Clip.LOOP_CONTINUOUSLY);//무한반복
					clip.start();
				}catch(Exception e) { 
					e.printStackTrace();
				}
			}else {
				System.out.println("파일이 없습니다.");
			}
		}
		
		public void mixCard() {
			//섞는다 셔플 : 배열의 첫번째값과 랜덤값을 섞음.
			Random rand = new Random();
			for(int i=0; i<1000; i++) { //100번 섞는다
				int random = rand.nextInt(15)+1; //1~15까지만
				String temp = images[0];
				images[0] = images[random];
				images[random] = temp;
			}
			for(int i=0; i<16; i++)
				System.out.println(images[i]);
		}
		
		public MyFrame(String title) {
			super(title);//상단에 윈도우 타이틀 표시
			this.setLayout(new BorderLayout());
			this.setSize(400,500);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			mixCard();//카드를 섞는다.
			
			panelNorth = new JPanel();
			panelNorth.setPreferredSize(new Dimension(400,100));
			panelNorth.setBackground(Color.BLUE);
			labelMessage = new JLabel("같은 이미지를 찾으세요."
					+ "시도횟수 0번");
			labelMessage.setPreferredSize(new Dimension(400,100));
			labelMessage.setForeground(Color.WHITE);
			labelMessage.setFont(new Font("나눔고딕",Font.BOLD,20));
			labelMessage.setHorizontalAlignment(JLabel.CENTER);
			panelNorth.add(labelMessage);
			this.add("North",panelNorth);
			
			panelCenter = new JPanel();
			panelCenter.setLayout(new GridLayout(4,4));
			panelCenter.setPreferredSize(new Dimension(400,400));
			for(int i=0; i<16; i++) {
				buttons[i] = new JButton();
				buttons[i].setPreferredSize(new Dimension(100,100));
				buttons[i].setIcon(changeImage("question.png") );//버튼에 이미지 넣을때,
				buttons[i].addActionListener(this);
				panelCenter.add(buttons[i]);
			}
			this.add("Center", panelCenter);
			this.pack(); //빈공간 제거
			
			playSound("mr-jelly.wav");
			
		}
		public int getButtonIndex(JButton btn) {
			int index = 0;
			for(int i=0; i<16; i++) {
				if(buttons[i] == btn) { //주소값이 같은가?
					index = i;
				}
			}
			return index;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			//1초동안 쉴때, 버튼을 또 누르면, 오류발생.
			if(openCount == 2)
				return; //메소드를 빠져 나감.
			
			//버튼이 눌렸을 때, 버튼 객체를 가져오는 방법
			JButton btn = (JButton)e.getSource();
			int index = getButtonIndex(btn);
			btn.setIcon(changeImage(images[index]));
			
			openCount++;
			if(openCount == 1) { //첫번째 누른 카드
				buttonIndexSave1 = index;
				
			}
			else if(openCount == 2) { //두번째 누른 카드
				buttonIndexSave2 = index;
				tryCount++;
				labelMessage.setText(
		"같은 이미지를 찾으세요. 시도횟수 "+ tryCount +"번");
				
				//번호안의 이미지파일이름이 서로 같은지 비교
				boolean isBingo = 
					checkCard(buttonIndexSave1,buttonIndexSave2);
				if( isBingo ) { //성공
					playSound("Bingo.wav");
					openCount = 0;
					successCount++;
					if(successCount == 8) {
						labelMessage.setText(
								"게임성공 시도횟수 "+tryCount+"번");
					}
				}else { //실패
					playSound("OhNo.wav");
					backToQuestion();
					
				}
			}
		}
		public void backToQuestion() {
			//익명클래스를 통해, 인터페이스의 오버라이드 메소드를
			//바로 구현해보자.
			timer = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("timer");
			
					openCount = 0;
					buttons[buttonIndexSave1].setIcon(
							changeImage("question.png"));
					buttons[buttonIndexSave2].setIcon(
							changeImage("question.png"));
					timer.stop(); //반복 안됨.
				}
			});
			timer.start();
		}
		public boolean checkCard(int index1, int index2) {
			if(index1 == index2)
				return false;
			if( images[index1].equals(images[index2])) {
				return true;
			}else {
				return false;
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		new MyFrame("빙고게임");
	}
}