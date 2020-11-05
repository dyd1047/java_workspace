/*스윙 컴포넌트 중, 이차원 구조의 데이터(표)를 표현하기에 최적화된 JTable을 사용해본다.
 * */
package day1105.db;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableApp extends JFrame{
	JTable table;
	JScrollPane scroll;
	
	String[] column = {"번호","이름","연락처","주소","성별"};
	String[][] data = {
			{"1", "Batman", "011","godam","male"},
			{"2", "superman", "012","cripton","male"},
			{"3", "wonderwoman", "013","amazone","female"}
	};
	
	public TableApp() {
		table = new JTable(data, column); //row 3, col 5
		scroll = new JScrollPane(table);
		
		setLayout(new FlowLayout());
		add(scroll); //CENTER
		
		//마우스 이벤트 구현
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("초옥이?");
				int col = table.getSelectedColumn(); //유저가 선택한 컬럼 index
				int row = table.getSelectedRow(); //유저가 선택한 row
				System.out.println("좌표 ("+row+","+col+")초옥이!!");
				String value = (String)table.getValueAt(row, col);
				System.out.println(value);
			}
		});
		setVisible(true);
		setSize(500, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TableApp();
	}
}
