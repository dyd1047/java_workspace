/*진행 상황을 직관적으로 알 수 있는 프로그래스 바를 활용해보자*/
package day1103.thread;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class ProgressApp extends JFrame{
	JLabel la;
	JProgressBar bar1;
	JProgressBar bar2;
	JProgressBar bar3;
	Thread laThread; //라벨을 증가시킬 쓰레드
	BarThread t1,t2,t3; //바를 증가시킬 쓰레드
	
	int a = 0;
	
	public ProgressApp() {
		la = new JLabel("0", SwingConstants.CENTER);
		bar1 = new JProgressBar();
		bar2 = new JProgressBar();
		bar3 = new JProgressBar();

		laThread = new Thread() {
			@Override
			public void run() {
				while(true) {
					 a++;
					 setLabelValue();
					 try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		//스타일
		la.setPreferredSize(new Dimension(500, 150));
		la.setFont(new Font("Verdana", Font.BOLD|Font.ITALIC, 45));
		bar1.setPreferredSize(new Dimension(500, 70));
		bar2.setPreferredSize(new Dimension(500, 70));
		bar3.setPreferredSize(new Dimension(500, 70));
		
		add(la);
		add(bar1);
		add(bar2);
		add(bar3);
		
		//쓰레드 3개 생성하여 runnable로 진입시키자
		t1 = new BarThread(bar1, 500);
		t2 = new BarThread(bar2, 50);
		t3 = new BarThread(bar3, 200);
		t1.start();
		t2.start();
		t3.start();
		
		setLayout(new FlowLayout());
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		laThread.start(); //쓰레드 동작
	}
	
	//라벨 값 제어
	public void setLabelValue() {
		la.setText(Integer.toString(a));
	}
	
	public static void main(String[] args) {
		new ProgressApp();
	}
}
