package com.swingmall.member;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;

public class Login extends Page{
	JPanel p_content;
	JTextField t_id;
	JPasswordField t_pass;
	JLabel la_id;
	JLabel la_pass;
	JButton bt_login;
	JButton bt_regist;

	public Login(ShopMain shopMain) {
		super(shopMain);
		
		p_content = new JPanel();
		t_id = new JTextField();
		t_pass = new JPasswordField();
		la_id = new JLabel("ID");
		la_pass = new JLabel("PASS");
		bt_login = new JButton("Login");
		bt_regist = new JButton("Regist");
		
		//스타일
		this.setBackground(Color.BLACK);
		p_content.setPreferredSize(new Dimension(350, 150));
		p_content.setBackground(Color.BLACK);
		p_content.setBorder(new TitledBorder(new LineBorder(Color.RED, 2), "LOGIN", 0, 0, new Font("Verdaba", Font.BOLD, 20), Color.WHITE));
		t_id.setPreferredSize(new Dimension(280, 25));
		t_pass.setPreferredSize(new Dimension(280, 25));
		la_id.setPreferredSize(new Dimension(40, 25));
		la_pass.setPreferredSize(new Dimension(40, 25));
		la_id.setForeground(Color.WHITE);
		la_pass.setForeground(Color.WHITE);
		bt_login.setBackground(Color.WHITE);
		bt_login.setFocusPainted(false);
		bt_regist.setBackground(Color.WHITE);
		bt_regist.setFocusPainted(false);
		
		//조립
		p_content.add(la_id);
		p_content.add(t_id);
		p_content.add(la_pass);
		p_content.add(t_pass);
		p_content.add(bt_login);
		p_content.add(bt_regist);
		
		add(p_content);
		
		//회원가입 버튼과 리스너 연결
		bt_regist.addActionListener((e)->{
			getShopMain().showPage(shopMain.MEMBER_REGIST);
		});
		
		//로그인 버튼과 리스너 연결
		bt_login.addActionListener((e)->{
			ShopMember vo = new ShopMember();
			vo.setMid(t_id.getText());
			vo.setPass(new String(t_pass.getText()));
			validCheck(vo);
		});
		
		//키보드리스너 연결
		t_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					ShopMember vo = new ShopMember();
					vo.setMid(t_id.getText());
					vo.setPass(new String(t_pass.getText()));
					validCheck(vo);
				}
			}
		});
		t_pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					ShopMember vo = new ShopMember();
					vo.setMid(t_id.getText());
					vo.setPass(new String(t_pass.getText()));
					validCheck(vo);
				}
			}
		});
	}
	
	//유효성 체크(입력하지 않은 필드가 있는지 여부에 따른 피드백)
	public void validCheck(ShopMember shopMember) {
		if(shopMember.getMid().length() < 1) { //문자열의 길이가 0이라면
			JOptionPane.showMessageDialog(this, "아이디를 입력해주세요.");
		}else if(shopMember.getPass().length() < 1) {
			JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요.");
		}else {
			login(shopMember);
		}
	}
	
	//회원 로그인 처리 메서드 정의: 로그인 성공 후 Home을 보여줄 예정임
	//아래의 메서드가 ShopMember를 반환하므로, 만일 로그인 실패한 경우에는
	//null을 반환
	public ShopMember login(ShopMember shopMember) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShopMember vo = null; //로그인 성공 후 회원의 모든 정보를 담게될 VO
		
		String sql = "select * from shop_member where mid = ? and pass = ?";
		
		try {
			pstmt = getShopMain().getCon().prepareStatement(sql);
			pstmt.setString(1, shopMember.getMid());
			pstmt.setString(2, shopMember.getPass());
			rs = pstmt.executeQuery();
			
			//참이면, 회원이 존재하는 것이므로 로그인으로 인정해주자
			//회원정보를 vo에 옮겨닮자
			if(rs.next()) {
				vo = new ShopMember();
				vo.setMember_id(rs.getInt("member_id"));
				vo.setMid(rs.getString("mid"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setEmail(rs.getString("email"));
				JOptionPane.showMessageDialog(this, "로그인 되었습니다.");
				//Home 보여주기
				getShopMain().showPage(ShopMain.HOME);
				//버튼의 라벨을 로그아웃으로 전환
				getShopMain().navi[4].setText("Logout");
				t_id.setText("");
				t_pass.setText("");
				getShopMain().setHasSession(true); //로그인 상태임을 알 수 있는 값 true
			}else {
				JOptionPane.showMessageDialog(this, "로그인 정보가 올바르지 않습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getShopMain().getDbManager().close(pstmt, rs);
		}
		return vo;
	}
	
	//로그아웃 처리
	//1. hasSession의 값을 false 2. 버튼의 텍스트 login으로 3. 페이지는 Home으로
	public void logout() {
		getShopMain().setHasSession(false);
		getShopMain().navi[4].setText("Login");
		getShopMain().showPage(ShopMain.HOME);
	}

}
