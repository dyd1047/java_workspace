package day1116.pubapi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MTMain extends JFrame{
	//서쪽영역
	JPanel p_west;
	JTextField t_name;
	JTextField t_op1;
	JTextField t_op2;
	JTextField t_op3;
	JButton bt;
	
	//센터영역
	Vector data = new Vector(); //이차원 벡터가 될 예정
	Vector<String> columnName = new Vector<String>(); //컬럼 제목 정보를 담는 백터
	JTable table;
	MountainModel model;
	JScrollPane scroll;
	
	/*JTable 연동 시 이차원배령은 생성 시 크기를 정해야 하기 때문에 불편한 점이 많다.
	 * 따라서 컬렉션 프레임웍중 Vector를 지원하는 새성자를 이용*/
	
	public MTMain() {
		init(); //데이터 채우기
		//생성
		p_west = new JPanel();
		t_name = new JTextField();
		t_op1 = new JTextField();
		t_op2 = new JTextField();
		t_op3 = new JTextField();
		bt = new JButton("serch");
		
		table = new JTable(data, columnName); //매개변수로 백터 넣기
		scroll = new JScrollPane(table);
		
		//스타일
		p_west.setPreferredSize(new Dimension(200, 600));
		p_west.setBackground(Color.WHITE);
		t_name.setPreferredSize(new Dimension(190, 30));
		t_op1.setPreferredSize(new Dimension(190, 30));
		t_op2.setPreferredSize(new Dimension(190, 30));
		t_op3.setPreferredSize(new Dimension(190, 30));
		
		//조립
		p_west.add(t_name);
		p_west.add(t_op1);
		p_west.add(t_op2);
		p_west.add(t_op3);
		p_west.add(bt);
		
		add(p_west, BorderLayout.WEST);
		add(scroll);
		
		
		setSize(900, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	//벡터 값을 초기화
	public void init() {
		//데이터 1건 넣어보기
		/*JTable에 벡터를 매개변수로 넣는 방식은 객체지향적인 요즘 개발방식에 맞지 않음
		 * 이유) 벡터안에 벡터를 넣어야 하므로, 이차원배열 방식과 다를바 없음
		 * 따라서 아래와 같이 벡터안에 또 하나의 벡터를 추가*/
		Vector v = new Vector();
		v.add("1");
		v.add("설악산");
		v.add("강원도");
		v.add("3000");
		
		data.add(v); //벡터안의 벡터, 벡터를 넣는것을 강제함..
		
		//컬럼정보 채우기
		columnName.add("ID"); //산 아이디
		columnName.add("이름"); //산 이름
		columnName.add("소재지"); //산 소재지
		columnName.add("높이"); //산 높이
	}
	
	public static void main(String[] args) {
		new MTMain();
	}
}
