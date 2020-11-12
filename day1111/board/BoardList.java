/*게시물 목록 페이지*/
package day1111.board;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BoardList extends JPanel{
	JTable table;
	JScrollPane scroll;
	JButton bt;
	BoardApp boardApp;
	BoardModel boardModel;
	
	public BoardList(BoardApp boardApp) {
		this.boardApp = boardApp;
		table = new JTable(boardModel = new BoardModel());
		scroll = new JScrollPane(table);
		bt = new JButton("Write");
		
		getList();
		
		setLayout(new BorderLayout());
		add(scroll);
		add(bt, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(780, 500));
		setVisible(true);
		
		table.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseReleased(MouseEvent e) {
				//상세보기가 보유한 getDetail() 메서드 호출하기
				BoardDetail boardDetail = (BoardDetail)boardApp.getPages(BoardApp.BOARD_DETAIL);
				String board_id = (String)table.getValueAt(table.getSelectedRow(), 0); //board_id
				boardDetail.getDetail(Integer.parseInt(board_id));
				boardApp.setPage(boardApp.BOARD_DETAIL); //상세보기
			}
		});
		
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//글쓰기 폼의 작성자에, 아이디 넣어두기
				BoardWrite page = (BoardWrite)boardApp.getPages(boardApp.BOARD_WRITE);
				page.t_writer.setText(boardApp.getBoardMember().getM_id());
				//글쓰기 폼 보여주기
				boardApp.setPage(boardApp.BOARD_WRITE);
			}
		});
	}
	
	//게시물 가져오기
	//rs에 담겨진 데이터를 TableModel이 보유한 이차원배열 data에 대입!
	public void getList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from board order by board_id desc"; //order by board_id desc 최신순으로 정
		try {
			//스크롤이 가능하고 (next()능력 + 자유자재로 이동능력), 읽기전용의 rs를 만들기 위한 옵션
			pstmt = boardApp.getCon().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			rs = pstmt.executeQuery();
			rs.last(); //커서를 가장 아래로 이동
			//rs에 들어있는 데이터를 이차원배열로 옮겨심어보자!
			//그러기 위해서는 먼저 이차원 배열을 만들어보자
			String[][] data = new String[rs.getRow()][boardModel.column.length];
			
			rs.beforeFirst();
			int index = 0;
			while(rs.next()) {
				String[] record = new String[boardModel.column.length];
				
				record[0] = rs.getString("board_id");
				record[1] = rs.getString("title");
				record[2] = rs.getString("writer");
				record[3] = rs.getString("regdate");
				record[4] = rs.getString("hit");
				
				//채워진 일차원 배열을 data 이차원배열에 순서대로 담자
				data[index++]=record;
			}
			boardModel.data = data;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
