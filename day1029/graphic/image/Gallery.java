package day1029.graphic.image;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gallery extends JFrame{
	JLabel l_title;
	JPanel p_north;
	DetailImages p_center;
	JPanel p_south;
	JPanel p_east;
	JButton bt_prev;
	JButton bt_next;
	String dir = "D:/User/yong/LN/workspace/athome/workspace-HTML/java_workspace/SeProject/res/travel2/";
	String[] path = {
			"aa.jpg", "ab.jpg", "ax.jpg", "bm.jpg", "et.jpg", "kg.jpg", "mx.jpg"
		};
	ThumbImages[] thumb = new ThumbImages[path.length];
	
	public Gallery() {
		//생성
		l_title = new JLabel("파일명");
		p_north = new JPanel();
		p_center = new DetailImages();
		p_south = new JPanel();
		p_east = new JPanel();
		bt_prev = new JButton("이전 버튼");
		bt_next = new JButton("다음 버튼");
		
		for (int i = 0; i < thumb.length; i++) {
			thumb[i] = new ThumbImages(dir+path[i], p_center);
			p_east.add(thumb[i]);
		}
		
		//조립
		p_north.add(l_title);
		p_south.add(bt_prev);
		p_south.add(bt_next);
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		add(p_south, BorderLayout.SOUTH);
		add(p_east, BorderLayout.EAST);
		
		
		setSize(800, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Gallery();
	}
}
