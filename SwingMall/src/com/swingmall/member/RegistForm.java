package com.swingmall.member;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;

public class RegistForm extends Page{
	JPanel p_content; //로그인폼과 동일한 목적
	JTextField t_mid;
	JPasswordField t_pass;
	JTextField t_name;
	JTextField t_phone;
	JTextField t_email;
	JLabel la_mid;
	JLabel la_pass;
	JLabel la_name;
	JLabel la_phone;
	JLabel la_email;
	JButton bt_regist;

	public RegistForm(ShopMain shopMain) {
		super(shopMain);
		
		p_content = new JPanel();
		t_mid = new JTextField();
		t_pass = new JPasswordField();
		t_name = new JTextField();
		t_phone = new JTextField();
		t_email = new JTextField();
		
		la_mid = new JLabel("ID");
		la_pass = new JLabel("Pass");
		la_name = new JLabel("Name");
		la_phone = new JLabel("Phone");
		la_email = new JLabel("Email");
		bt_regist = new JButton("Regist");
		
		//스타일
		this.setBackground(Color.BLACK);
		p_content.setPreferredSize(new Dimension(450, 400));
		p_content.setBackground(Color.BLACK);
		p_content.setBorder(new TitledBorder(new LineBorder(Color.RED, 2), "REGIST", 0, 0, new Font("Verdaba", Font.BOLD, 20), Color.WHITE));
		
		Dimension d1 = new Dimension(350, 25);
		t_mid.setPreferredSize(d1);
		t_pass.setPreferredSize(d1);
		t_name.setPreferredSize(d1);
		t_phone.setPreferredSize(d1);
		t_email.setPreferredSize(d1);
		
		Dimension d2 = new Dimension(40, 50);
		la_mid.setPreferredSize(d2);
		la_pass.setPreferredSize(d2);
		la_name.setPreferredSize(d2);
		la_phone.setPreferredSize(d2);
		la_email.setPreferredSize(d2);
		
		la_mid.setForeground(Color.WHITE);
		la_pass.setForeground(Color.WHITE);
		la_name.setForeground(Color.WHITE);
		la_phone.setForeground(Color.WHITE);
		la_email.setForeground(Color.WHITE);
		
		bt_regist.setBackground(Color.WHITE);
		bt_regist.setFocusPainted(false);
		
		//조립
		p_content.add(la_mid);
		p_content.add(t_mid);
		p_content.add(la_pass);
		p_content.add(t_pass);
		p_content.add(la_name);
		p_content.add(t_name);
		p_content.add(la_phone);
		p_content.add(t_phone);
		p_content.add(la_email);
		p_content.add(t_email);
		p_content.add(bt_regist);
		
		add(p_content);
		
		bt_regist.addActionListener((e)->{
			if(checkId(t_mid.getText())) {
				JOptionPane.showMessageDialog(this, "중복된 아이디 입니다.\n다른 아이디를 사용하세요.");
			}else {
				ShopMember vo = new ShopMember();
				vo.setMid(t_mid.getText()); //아이디 넣기
				vo.setPass(new String(t_pass.getPassword())); //비밀번호 넣기
				vo.setName(t_name.getText()); //이름 넣기
				vo.setPhone(t_phone.getText()); //전화번호 넣기
				vo.setEmail(t_email.getText()); //이메일 넣기
				
				int result = regist(vo);
				
				if(result == 0) {
					JOptionPane.showMessageDialog(this, "등록실패");
				}else {
					JOptionPane.showMessageDialog(this, "회원가입 성공");
				}
			}
		});
	}
	
	//회원존재여부 체크
	//반환값이 true가 나오면, 회원가입 진행시키면 안됨.
	public boolean checkId(String mid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		
		String sql = "select * from shop_member where mid = ?"; //회원테이블에 등록된 아이디가 있는지 여부에 대한 쿼리
		
		try {
			pstmt = getShopMain().getCon().prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			flag = rs.next(); //레코드가 존재하면 true, 아니면 false 대입됨
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getShopMain().getDbManager().close(pstmt, rs);
		}
		return flag;
	}
	
	//회원 등록
	public int regist(ShopMember shopMember) {
		//멤버변수 자동 초기화와는 달리, 메서드의 지역변수는 컴파일러가 초기화하지 않으므로, 반드시 개발자가 초기화해야 한다.
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "insert into shop_member(member_id, mid, pass, name, phone, email)";
		sql += " values(seq_shop_member.nextval, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = getShopMain().getCon().prepareStatement(sql);
			//바인드변수 대입
			pstmt.setString(1, shopMember.getMid());
			pstmt.setString(2, shopMember.getPass());
			pstmt.setString(3, shopMember.getName());
			pstmt.setString(4, shopMember.getPhone());
			pstmt.setString(5, shopMember.getEmail());
			
			result = pstmt.executeUpdate(); //쿼리 수행
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getShopMain().getDbManager().close(pstmt);
		}
		return result;
	}

}
