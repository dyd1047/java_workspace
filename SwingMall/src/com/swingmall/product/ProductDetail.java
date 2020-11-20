package com.swingmall.product;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.swingmall.admin.product.ProductVO;
import com.swingmall.cart.Cart;
import com.swingmall.cart.CartVO;
import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;

public class ProductDetail extends Page{
	public JPanel p_content; //상세내용을 담게 될 패널
	JPanel p_wrapper;
	public JPanel p_can; //큰 상품이미지 그려질 패널
	JLabel la_can_title;
	JPanel p_option; //옵션 선택 영역
	JLabel la_brand; //브랜드
	JLabel la_tbrand; //브랜드 타이틀
	JLabel la_product_name; //상품명 라벨
	JLabel la_tproduct_name; //상품명 라벨 타이틀
	JLabel la_price; //상품 가격
	JLabel la_tprice; //상품 가격 타이틀
	
	JLabel la_color; //상품 가격
	Choice ch_color; //색상 옵션
	JLabel la_size; //상품 가격
	Choice ch_size; //사이즈 옵션
	
	JButton bt_buy; //구매하기 버튼
	JButton bt_cart; //장바구니 버튼
	private ProductVO vo;
	private Image img;
	
	//상세페이지 호출 시 상품 1개의 정보는 vo에, 그려질 이미지는 img로 전달받자
	public ProductDetail(ShopMain shopMain) {
		super(shopMain);
		p_content = new JPanel();
		p_wrapper = new JPanel();
		p_can = new JPanel() {
			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, p_can);
			}
		};
		la_can_title = new JLabel("Detail Product Image");
		p_option = new JPanel();
		la_brand = new JLabel();
		la_product_name = new JLabel();
		la_price = new JLabel();
		la_tbrand = new JLabel("Brand");
		la_tproduct_name = new JLabel("Product Name");
		la_tprice = new JLabel("Price");
		
		la_color = new JLabel("Color");
		ch_color = new Choice();
		la_size = new JLabel("Size");
		ch_size = new Choice();
		
		//옵션 채우기
		ch_color.add("red");
		ch_color.add("black");
		ch_color.add("white");
		
		ch_size.add("S");
		ch_size.add("M");
		ch_size.add("L");
		
		bt_buy = new JButton("Buy");
		bt_cart = new JButton("Cart");
		
		//스타일 적용
		this.setBackground(Color.BLACK);
		p_content.setPreferredSize(new Dimension(ShopMain.WIDTH-40, ShopMain.HEIGHT-150));
		p_can.setPreferredSize(new Dimension(500, 550));
		p_content.setBackground(Color.WHITE);
		p_wrapper.setBackground(Color.WHITE);
		p_option.setBackground(Color.WHITE);
		
		Dimension d = new Dimension(400, 30);
		
		la_tbrand.setPreferredSize(d);
		la_brand.setPreferredSize(d);
		la_brand.setBorder(new LineBorder(Color.BLACK, 1));
		la_tproduct_name.setPreferredSize(d);
		la_product_name.setPreferredSize(d);
		la_product_name.setBorder(new LineBorder(Color.BLACK, 1));
		la_tprice.setPreferredSize(d);
		la_price.setPreferredSize(d);
		la_price.setBorder(new LineBorder(Color.BLACK, 1));
		la_color.setPreferredSize(d);
		la_size.setPreferredSize(d);
		ch_color.setPreferredSize(new Dimension((ShopMain.WIDTH)/3, 30));
		ch_size.setPreferredSize(new Dimension((ShopMain.WIDTH)/3, 30));
		bt_buy.setPreferredSize(new Dimension(200, 30));
		bt_cart.setPreferredSize(new Dimension(200, 30));
		la_can_title.setFont(new Font("Verdana", Font.BOLD, 20));
		p_option.setBorder(new TitledBorder(new LineBorder(Color.RED,2), "Select Detail Product"));
		
		//조립
		p_content.setLayout(new GridLayout(1, 2));
		p_wrapper.setLayout(new FlowLayout());
		
		//p_content 구성하기
		p_option.add(la_tbrand);
		p_option.add(la_brand);
		p_option.add(la_tproduct_name);
		p_option.add(la_product_name);
		p_option.add(la_tprice);
		p_option.add(la_price);
		p_option.add(la_color);
		p_option.add(ch_color);
		p_option.add(la_size);
		p_option.add(ch_size);
		p_option.add(bt_buy);
		p_option.add(bt_cart);
		
		p_wrapper.add(la_can_title);
		p_wrapper.add(p_can);
		
		p_content.add(p_wrapper);
		p_content.add(p_option);
		
		add(p_content);
		
		//장바구니 페이지 열기
		bt_cart.addActionListener((e)->{
			registCart(); //장바구니에 상품 추가하기
			
			//장바구니에 정보가 담겼다고 알려주고, 장바구니 이동 여부를 확인해야 함
			int ans = JOptionPane.showConfirmDialog(ProductDetail.this, "장바구니에 상품이 담겼습니다.\n장바구니로 이동하시겠습니까?");
			if(ans == JOptionPane.OK_OPTION) {
				getShopMain().showPage(ShopMain.CART);
			}
		});
	}
	
	//상세페이지가 보여질 때 데이터를 채워넣는 메서드 (생성자에서 하면 디자인 처리에 타이밍적인 제한이 많다.)
	public void init(ProductVO vo, Image img) {
		this.vo = vo; //멤버변수에 현재 보고있는 상품 vo를 주입
		la_brand.setText(vo.getBrand()); //브랜드 채워넣기
		la_product_name.setText(vo.getProduct_name());
		la_price.setText(Integer.toString(vo.getPrice()));
		this.img = img;
		this.img = this.img.getScaledInstance(500, 550, Image.SCALE_SMOOTH);
	}
	
	//장바구니에 등록(DB로 보관하지 않고, 오직 메모리상으로 저장할 예정)
	public void registCart() {
		Cart cartPage = (Cart)getShopMain().getPage()[ShopMain.CART];
		CartVO cartVo = new CartVO(); //Empty vo 생성
		cartVo.setProduct_id(vo.getProduct_id()); //현재 보고있는 상품을 이용하여 CartVO에 채우기
		cartVo.setBrand(vo.getBrand());
		cartVo.setProduct_name(vo.getProduct_name());
		cartVo.setPrice(vo.getPrice());
		cartVo.setFilename(vo.getFilename());
		cartVo.setColor(ch_color.getSelectedItem()); //선택한 색상
		cartVo.setSize(ch_size.getSelectedItem()); //선택한 사이즈
		cartVo.setEa(1); //장바구니에 담을때는 기본이 1개임
		
		cartPage.addCart(cartVo); //장바구니에 상품 1건 추가하기
		cartPage.getCartList(); //장바구니 목록 구성하기
	}

	public ProductVO getVo() {
		return vo;
	}

	public void setVo(ProductVO vo) {
		this.vo = vo;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	
}
