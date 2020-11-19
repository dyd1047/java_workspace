package com.swingmall.member;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;
import com.swingmall.product.ProductDetail;

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
		p_content.setPreferredSize(new Dimension(330, 125));
		p_content.setBackground(Color.BLACK);
		t_id.setPreferredSize(new Dimension(280, 25));
		t_pass.setPreferredSize(new Dimension(280, 25));
		la_id.setPreferredSize(new Dimension(40, 25));
		la_pass.setPreferredSize(new Dimension(40, 25));
		la_id.setForeground(Color.WHITE);
		la_pass.setForeground(Color.WHITE);
		
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
	}

}
