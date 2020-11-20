package com.swingmall.home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.swingmall.admin.product.ProductVO;
import com.swingmall.product.ProductDetail;

public class ProductItem extends JPanel{
	JPanel p_can;
	JLabel la_brand; //브랜드
	JLabel la_tbrand; //브랜드 타이틀
	JLabel la_product_name; //상품명 라벨
	JLabel la_tproduct_name; //상품명 라벨 타이틀
	JLabel la_price; //상품 가격
	JLabel la_tprice; //상품 가격 타이틀
	Image img;
	ProductVO vo;
	Home home;
	ProductDetail productDetail;
	
	public ProductItem(Home home, ProductVO vo, int width, int height) {
		this.home = home;
		this.vo = vo;
		try {
			URL url = new URL(vo.getFilename());
			img = ImageIO.read(url); //원본크기의 이미지가 오므로, 크기 조절이 필요
			img = img.getScaledInstance(width, height/2, Image.SCALE_SMOOTH);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		p_can = new JPanel() {
			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, p_can);
			}
		};
		la_brand = new JLabel(vo.getBrand());
		la_product_name = new JLabel(vo.getProduct_name());
		la_price = new JLabel(Integer.toString(vo.getPrice()));
		la_tbrand = new JLabel("Brand");
		la_tproduct_name = new JLabel("Name");
		la_tprice = new JLabel("Price");
		
		//스타일 적용
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(width, height));
		p_can.setPreferredSize(new Dimension(width, height/2));
		
		la_brand.setPreferredSize(new Dimension(width-50, (height/2)/4));
		la_product_name.setPreferredSize(new Dimension(width-50, (height/2)/4));
		la_price.setPreferredSize(new Dimension(width-50, (height/2)/4));
		la_tbrand.setPreferredSize(new Dimension(40, (height/2)/4));
		la_tproduct_name.setPreferredSize(new Dimension(40, (height/2)/4));
		la_tprice.setPreferredSize(new Dimension(40, (height/2)/4));
		
		add(p_can);
		add(la_tbrand);
		add(la_brand);
		add(la_tproduct_name);
		add(la_product_name);
		add(la_tprice);
		add(la_price);
		
	}
}
