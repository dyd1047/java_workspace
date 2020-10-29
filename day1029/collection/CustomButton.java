package day1029.collection;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CustomButton extends JButton implements ActionListener{
	public CustomButton() {
		this.addActionListener(this); //나와 버튼의 리스너 연결
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setBackground(Color.GREEN);
	}

}
