package day1027.gui;

import java.awt.Button;
import java.awt.Frame;

public class Test extends Frame{
	Button bt;
	//생성자도 손으로 일일이 입력하지 말고, 빈공간에 ctrl + space
	public Test() {
		bt = new Button("나버튼");
		add(bt);
		setVisible(true);
		setSize(300, 400);
	}
	public static void main(String[] args) {
		
	}
}
