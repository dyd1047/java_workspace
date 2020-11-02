package day1102.event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowApp extends JFrame{
	
	public WindowApp() {
		this.addWindowListener(new MyWinAdapter(){

			@Override
			public void windowClosing(WindowEvent e) { //창에 의해 프로그램 종료될 때
				System.out.println("창 닫힘");
				System.exit(0);//프로세스 종료
			}
		});
		
		setSize(300,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowApp();
	}

}
