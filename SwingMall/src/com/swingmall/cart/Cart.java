/*장바구니 페이지를 정의한다.*/
package com.swingmall.cart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;

public class Cart extends Page{
	JPanel p_wrapper;
	JPanel bt_container; //버튼을 묶어둘 컨테이너
	JButton bt_pay; //결제단계로 가기
	JButton bt_del; //장바구니 비우기
	
	//장바구니 역할을 컬렉션 프레임웍 객체를 선언
	HashMap<Integer, CartVO> cartList;

	public Cart(ShopMain shopMain) {
		super(shopMain);
		
		
		cartList = new HashMap<Integer, CartVO>();
		
		bt_container = new JPanel();
		bt_pay = new JButton("Buy");
		bt_del = new JButton("Cancle");
		
		//스타일
		this.setPreferredSize(new Dimension(ShopMain.WIDTH, ShopMain.HEIGHT-100));
		this.setLayout(new BorderLayout());
		bt_container.setPreferredSize(new Dimension(ShopMain.WIDTH, 100));
		bt_container.setBackground(Color.WHITE);
		bt_pay.setBackground(Color.BLACK);
		bt_del.setBackground(Color.BLACK);
		bt_pay.setForeground(Color.WHITE);
		bt_del.setForeground(Color.WHITE);
		bt_pay.setFocusPainted(false);
		bt_del.setFocusPainted(false);
		
		getCartList();
		
		bt_container.add(bt_pay);
		bt_container.add(bt_del);
		add(bt_container, BorderLayout.SOUTH);
		
	}
	
	//장바구니에 넣기
	public void addCart(CartVO vo) { //상품 1건을 장바구니에 추가하기
		cartList.put(vo.getProduct_id(), vo); //key와 값을 저장
	}
	
	//장바구니 삭제하기
	public void removeCart(int product_id) { //상품 1건을 장바구니에서 제거하기
		cartList.remove(product_id);
	}
	
	//장바구니 비우기
	public void removeAll() { //모든 상품을 장바구니에서 제거하기
		
	}
	
	//장바구니 변경
	public void updateCart(CartVO vo) {
		//해시맵에 들어있는 객체 중 해당 객체를 찾아내어 vo 교체
		CartVO obj = cartList.get(vo.getProduct_id()); //검색
		obj = vo; //기존 해시맵이 가지고 있던 vo를 찾아내어 주소 변경
	}
	
	//장바구니 목록 가져오기 (주의 : 맵은 순서가 없는 집합이므로 먼저 일렬로 늘어뜨려야 한다. 그 후 접근)
	public void getCartList() {
		Set<Integer> set = cartList.keySet(); //키들을 set으로 반환받는다.. 즉 맵은 한 번에 일렬로 늘어서는 것이 아니라, set으로 먼저
								//key를 가져와야 함
		Iterator<Integer> it = set.iterator();
		//add()하기 전에 기존에 붙어있던 모든 컴포넌트는 제거
		if(p_wrapper != null) { //존재한다면 기존꺼 지우기
			this.remove(p_wrapper);
		}
		
		//동적으로 새로 생성
		p_wrapper = new JPanel();
		p_wrapper.setPreferredSize(new Dimension(ShopMain.WIDTH, ShopMain.HEIGHT-100));
		p_wrapper.setBackground(Color.WHITE);
		
		while(it.hasNext()) { //요소가 있는 동안
			int key = it.next(); //요소를 추출
			CartVO vo = cartList.get(key);
			//디자인을 표현하는 CartItem에 CartVO의 정보를 채워넣자
			CartItem item = new CartItem(vo);
			
			item.bt_del.addActionListener((e)->{
				if(JOptionPane.showConfirmDialog(Cart.this, "장바구니에서 삭제하시겠습니까?") == JOptionPane.OK_OPTION) {
					removeCart(vo.getProduct_id());
					updateUI();
					getCartList();
				}
			});
			
			item.bt_update.addActionListener((e)->{
				if(JOptionPane.showConfirmDialog(Cart.this, "장바구니를 업데이트하시겠습니까?") == JOptionPane.OK_OPTION) {
					int ea = Integer.parseInt(item.t_ea.getText());
					vo.setEa(ea); //변경된 갯수를 vo에 반영한 후에 전달
					updateCart(vo);
					updateUI();
					getCartList();
				}
			});
			
			p_wrapper.add(item);
		}
		add(p_wrapper);
	}

}
