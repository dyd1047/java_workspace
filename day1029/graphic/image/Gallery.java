package day1029.graphic.image;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gallery extends JFrame implements ActionListener{
	JLabel l_title;
	JPanel p_north;
	DetailImages p_center;
	JPanel p_south;
	JPanel p_west;
	JButton bt_prev;
	JButton bt_next;
	String dir = "D:/User/yong/LN/workspace/athome/workspace-HTML/java_workspace/SeProject/res/travel2/";
	String[] path = {
			"aa.jpg", "ab.jpg", "ax.jpg", "bm.jpg", "et.jpg", "kg.jpg", "mx.jpg"
		};
	ThumbImages[] thumb = new ThumbImages[path.length];
	int a = 0;
	
	public Gallery() {
		//생성
		l_title = new JLabel("파일명");
		p_north = new JPanel();
		p_center = new DetailImages();
		p_south = new JPanel();
		p_west = new JPanel();
		bt_prev = new JButton("이전 버튼");
		bt_next = new JButton("다음 버튼");
		
		p_west.setLayout(new BoxLayout(p_west, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < thumb.length; i++) {
			a = i;
			thumb[a] = new ThumbImages(dir+path[a], p_center);
			p_west.add(thumb[a]);
		}
		
		//조립
		p_north.add(l_title);
		p_south.add(bt_prev);
		p_south.add(bt_next);
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		add(p_south, BorderLayout.SOUTH);
		add(p_west, BorderLayout.WEST);
		
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		setSize(800, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == bt_prev) {
				thumb[a] = new ThumbImages(dir+path[a], p_center);
				System.out.println("이전");
		}else if(obj == bt_next) {
			
		}
	}
	
	public static void main(String[] args) {
		new Gallery();
	}

}
