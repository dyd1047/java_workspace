package day1103.game;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GameWindow extends JFrame{
	GamePanel gamePanel; //실제 게임이 그려질 패널
	JMenuBar bar;
	JMenu control;
	JMenuItem item_restart, item_start, item_pause, item_exit;
//	GameWindow gameWindow;
	
	public GameWindow() {
//		gameWindow = new GameWindow();
		gamePanel = new GamePanel();
		bar = new JMenuBar();
		control = new JMenu("게임 설정");
		item_restart = new JMenuItem("게임 재시작");
		item_start = new JMenuItem("게임 시작");
		item_pause = new JMenuItem("pause");
		item_exit = new JMenuItem("게임 종료");
		
		control.add(item_restart);
		control.add(item_start);
		control.add(item_pause);
		control.add(item_exit);
		bar.add(control);
		setJMenuBar(bar);
		
		setLayout(new FlowLayout());
		add(gamePanel);
		
		pack(); //윈도우 안에 있는 내용물까지 줄어듦
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//윈도우와 리스너 연결
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				gamePanel.moveKey(e.getKeyCode());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				gamePanel.stopKey(e.getKeyCode());				
			}
		});
		
		//메뉴와 리스너 연결
		item_restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				if(gamePanel.stop == true) {
//					gamePanel.stop = false;
//				}else if(gamePanel.stop == false) {
//					gamePanel.stop = true;
//					gamePanel.loopThread.start();
//				}
				JOptionPane.showMessageDialog(gamePanel, "아직 개발중입니다.");
			}
		});
		item_start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gamePanel.flag=true;
			}
		});
		item_pause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gamePanel.flag=false;
			}
		});
		item_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(GameWindow.this, "정말 끝내시려구요?")==JOptionPane.OK_OPTION)
				gamePanel.flag=false;
				System.exit(0); //프로세스 종료
			}
		});
	}
	
	public static void main(String[] args) {
		new GameWindow();
	}
}
