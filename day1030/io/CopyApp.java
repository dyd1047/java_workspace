package day1030.io;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CopyApp extends JFrame implements ActionListener{
	JLabel la1;
	JLabel la2;
	JTextField t1;
	JTextField t2;
	JButton bt;
	
	public CopyApp() {
		la1 = new JLabel("원본");
		la2 = new JLabel("복사본");
		t1 = new JTextField();
		t2 = new JTextField();
		bt = new JButton("copy");
		
		setLayout(new FlowLayout());
		la1.setPreferredSize(new Dimension(100, 50));
		la2.setPreferredSize(new Dimension(100, 50));
		t1.setPreferredSize(new Dimension(200, 50));
		t2.setPreferredSize(new Dimension(200, 50));
		bt.setPreferredSize(new Dimension(150, 40));
		
		add(la1);
		add(t1);
		add(la2);
		add(t2);
		add(bt);
		
		bt.addActionListener(this);
		
		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg1 = t1.getText();
		String msg2 = t2.getText();
		if (obj == bt) {
			FileCopy2 fileCopy = new FileCopy2(msg1, msg2);
			JOptionPane.showInternalMessageDialog(this, "복사가 완료되었습니다.");
		}
	}
	
	public static void main(String[] args) {
		new CopyApp();
	}

}
