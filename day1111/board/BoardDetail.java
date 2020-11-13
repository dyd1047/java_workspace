package day1111.board;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BoardDetail extends JPanel{
	JTextField t_title;
	JTextField t_writer;
	JTextArea content;
	JScrollPane scroll;
	
	JButton bt_edit; //수정
	JButton bt_del; //삭제
	JButton bt_list;
	BoardApp boardApp;
	Board board; //수정, 삭제시에도 이 안에 들어있는 정보들을 활용하기 위해
					//지역변수로 선언하지 않고, 멤버변수로 선언
	
	int board_id;
	
	public BoardDetail(BoardApp boardApp) {
		this.boardApp = boardApp;
		t_title = new JTextField();
		t_writer = new JTextField();
		content = new JTextArea();
		scroll = new JScrollPane(content);
		bt_edit = new JButton("Edit");
		bt_del = new JButton("Delete");
		bt_list = new JButton("List");
		
		//스타일
		t_title.setPreferredSize(new Dimension(780, 35));
		t_writer.setPreferredSize(new Dimension(780, 35));
		scroll.setPreferredSize(new Dimension(780, 300));
		
		//조립
		add(t_title);
		add(t_writer);
		add(scroll);
		add(bt_edit);
		add(bt_del);
		add(bt_list);
		
		setPreferredSize(new Dimension(780, 500));
		setVisible(true);
		
		bt_edit.addActionListener((e)->{
			update();
		});
		
		bt_del.addActionListener((e)->{
			if(JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?", "confirm", JOptionPane.YES_NO_OPTION) == 0) {
				int result = delete();
				if(result == 0) {
					JOptionPane.showMessageDialog(this, "삭제에 실패하였습니다.");
				}else {
					JOptionPane.showMessageDialog(this, "삭제가 완료되었습니다.");
					BoardList boardList = (BoardList)boardApp.getPages(boardApp.BOARD_LIST);
					boardList.getList(); //리스트 갱신
					boardApp.setPage(boardApp.BOARD_LIST);
				}
			}
		});
		
		bt_list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BoardList boardList = (BoardList)boardApp.getPages(boardApp.BOARD_LIST);
				boardList.getList(); //리스트 갱신
				boardApp.setPage(boardApp.BOARD_LIST);
			}
		});
	}
	
	//조회수 증가
	public void updateHit() {
		PreparedStatement pstmt = null;
		String sql = "update board set hit = hit+1 where board_id = "+board_id;
		try {
			pstmt = boardApp.getCon().prepareStatement(sql);
			int result = pstmt.executeUpdate();
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
		}
	}
	
	//한 건 가져오기!
	public void getDetail(int board_id) {
		this.board_id = board_id;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from board where board_id = "+board_id;
		try {
			pstmt = boardApp.getCon().prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//커서를 한칸 전진
			if(rs.next()) {
				board = new Board(); //create Empty object
				board.setBoard_id(rs.getInt("board_id"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit")); //조회수는 숫자다!
				
				//데이터 채우기!
				t_title.setText(board.getTitle()); //제목
				t_writer.setText(board.getWriter()); //작성자
				content.setText(board.getContent()); //상세보기
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//수정하기
	public void update() {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String[] sql = {"update board set title = '"+t_title.getText()+"' where board_id = "+board_id
		, "update board set content = '"+content.getText()+"' where board_id = "+board_id};
		if(JOptionPane.showConfirmDialog(this, "정말 수정하시겠습니까?", "confirm", JOptionPane.YES_NO_OPTION) == 0) {
			try {
				for (int i = 0; i < sql.length; i++) {
					pstmt = boardApp.getCon().prepareStatement(sql[i]);
					result = pstmt.executeUpdate();
				}
				if(result == 0) {
					JOptionPane.showMessageDialog(this, "게시글 수정에 실패하였습니다.");
				}else {
						JOptionPane.showMessageDialog(this, "수정이 완료되었습니다.");
						BoardList boardList = (BoardList)boardApp.getPages(boardApp.BOARD_LIST);
						boardList.getList();
						boardApp.setPage(boardApp.BOARD_LIST);
				}
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
			}
		}
		
	}
	
	//삭제하기
	public int delete() {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "delete from board where board_id = '"+board_id+"'";
		
		try {
			pstmt = boardApp.getCon().prepareStatement(sql);
			result = pstmt.executeUpdate();
			
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
		}
		
		return result;
	}
}
