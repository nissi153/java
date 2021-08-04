package AwtSwing;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

//�̹� ���� ī��� �ٽ� ������ ���ϰ� ó��.
//1�оȿ� 

public class BingoGame {
	static JPanel panelNorth; //��Ʈ��+�̸�
	static JPanel panelCenter;
	static JLabel labelMessage;
	static JButton[] buttons = new JButton[16]; 
	static String[] images = { 
			"fruit01.png","fruit02.png","fruit03.png","fruit04.png",
			"fruit05.png","fruit06.png","fruit07.png","fruit08.png",
			"fruit01.png","fruit02.png","fruit03.png","fruit04.png",
			"fruit05.png","fruit06.png","fruit07.png","fruit08.png",
			};
	static int openCount = 0;//����ī�� �ε���
	static int buttonIndexSave1 = 0; //ù��°ī�� �ε���
	static int buttonIndexSave2 = 0; //�ι�°ī�� �ε���
	static Timer timer;
	static int tryCount = 0; //�õ�Ƚ��
	static int successCount = 0; //���� ī��Ʈ
	
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
					//clip.loop(Clip.LOOP_CONTINUOUSLY);//���ѹݺ�
					clip.start();
				}catch(Exception e) { 
					e.printStackTrace();
				}
			}else {
				System.out.println("������ �����ϴ�.");
			}
		}
		
		public void mixCard() {
			//���´� ���� : �迭�� ù��°���� �������� ����.
			Random rand = new Random();
			for(int i=0; i<1000; i++) { //100�� ���´�
				int random = rand.nextInt(15)+1; //1~15������
				String temp = images[0];
				images[0] = images[random];
				images[random] = temp;
			}
			for(int i=0; i<16; i++)
				System.out.println(images[i]);
		}
		
		public MyFrame(String title) {
			super(title);//��ܿ� ������ Ÿ��Ʋ ǥ��
			this.setLayout(new BorderLayout());
			this.setSize(400,500);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			mixCard();//ī�带 ���´�.
			
			panelNorth = new JPanel();
			panelNorth.setPreferredSize(new Dimension(400,100));
			panelNorth.setBackground(Color.BLUE);
			labelMessage = new JLabel("���� �̹����� ã������."
					+ "�õ�Ƚ�� 0��");
			labelMessage.setPreferredSize(new Dimension(400,100));
			labelMessage.setForeground(Color.WHITE);
			labelMessage.setFont(new Font("�������",Font.BOLD,20));
			labelMessage.setHorizontalAlignment(JLabel.CENTER);
			panelNorth.add(labelMessage);
			this.add("North",panelNorth);
			
			panelCenter = new JPanel();
			panelCenter.setLayout(new GridLayout(4,4));
			panelCenter.setPreferredSize(new Dimension(400,400));
			for(int i=0; i<16; i++) {
				buttons[i] = new JButton();
				buttons[i].setPreferredSize(new Dimension(100,100));
				buttons[i].setIcon(changeImage("question.png") );//��ư�� �̹��� ������,
				buttons[i].addActionListener(this);
				panelCenter.add(buttons[i]);
			}
			this.add("Center", panelCenter);
			this.pack(); //����� ����
			
			playSound("mr-jelly.wav");
			
		}
		public int getButtonIndex(JButton btn) {
			int index = 0;
			for(int i=0; i<16; i++) {
				if(buttons[i] == btn) { //�ּҰ��� ������?
					index = i;
				}
			}
			return index;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			//1�ʵ��� ����, ��ư�� �� ������, �����߻�.
			if(openCount == 2)
				return; //�޼ҵ带 ���� ����.
			
			//��ư�� ������ ��, ��ư ��ü�� �������� ���
			JButton btn = (JButton)e.getSource();
			int index = getButtonIndex(btn);
			btn.setIcon(changeImage(images[index]));
			
			openCount++;
			if(openCount == 1) { //ù��° ���� ī��
				buttonIndexSave1 = index;
				
			}
			else if(openCount == 2) { //�ι�° ���� ī��
				buttonIndexSave2 = index;
				tryCount++;
				labelMessage.setText(
		"���� �̹����� ã������. �õ�Ƚ�� "+ tryCount +"��");
				
				//��ȣ���� �̹��������̸��� ���� ������ ��
				boolean isBingo = 
					checkCard(buttonIndexSave1,buttonIndexSave2);
				if( isBingo ) { //����
					playSound("Bingo.wav");
					openCount = 0;
					successCount++;
					if(successCount == 8) {
						labelMessage.setText(
								"���Ӽ��� �õ�Ƚ�� "+tryCount+"��");
					}
				}else { //����
					playSound("OhNo.wav");
					backToQuestion();
					
				}
			}
		}
		public void backToQuestion() {
			//�͸�Ŭ������ ����, �������̽��� �������̵� �޼ҵ带
			//�ٷ� �����غ���.
			timer = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("timer");
			
					openCount = 0;
					buttons[buttonIndexSave1].setIcon(
							changeImage("question.png"));
					buttons[buttonIndexSave2].setIcon(
							changeImage("question.png"));
					timer.stop(); //�ݺ� �ȵ�.
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
		new MyFrame("�������");
	}
}