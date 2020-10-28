package day1027.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Chatting extends JFrame{
	JButton bt;
	
	public Chatting() {
		bt = new JButton("전송");
		
		setLayout(new BorderLayout());
		
		setSize(500, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Chatting();
	}
}
