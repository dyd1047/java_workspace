package com.swingmall.home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.swingmall.admin.product.ProductVO;
import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;
import com.swingmall.product.ProductDetail;

public class Home extends Page{
	JPanel p_content; //상품 리스트를 담게 될 패널, 추후 상세보기로 전환 시 이 패널 자체를 들어내버릴것임
	ArrayList<ProductItem> itemList; //생성된 상품 아이템들을 담게될 리스트(ProductItem 클래스 내에서 이벤트를 구현하면 
									//너무 많은 정보를 넘겨야 하므로, 또한 페이지도 아니면서 너무 많은 정보를 가져양 하므로, 효율성 저하)
	
	public Home(ShopMain shopMain) {
		super(shopMain);
		p_content = new JPanel();
		
		//스타일 적용
		this.setBackground(Color.BLACK);
		p_content.setPreferredSize(new Dimension(shopMain.WIDTH-40, shopMain.HEIGHT-150));
		p_content.setBackground(Color.WHITE);
		
		add(p_content);
		
		getProductList();
		p_content.updateUI();
		
		//생성된 아이템들에 대해서 마우스 리스너 연결하기
		for (ProductItem item : itemList) {
			item.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					ProductDetail productDetail = (ProductDetail)getShopMain().getPage()[ShopMain.PRODUCT_DETAIL];
					productDetail.init(item.vo, item.img); //아이템이 보유한 ProductVO 전달
					productDetail.updateUI();
					getShopMain().showPage(ShopMain.PRODUCT_DETAIL); //보여주고 싶은 페이지
				}
			});
		}
	}
	
	//모든 상품 가져오기
	public void getProductList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from product";
		
		try {
			pstmt = getShopMain().getCon().prepareStatement(sql);
			rs = pstmt.executeQuery();
			itemList = new ArrayList<ProductItem>(); //상품 아이템 생성할때마다 리스트에 담기위함
			
			while(rs.next()) {
				//vo 하나를 생성한 후, rs의 데이터를 vo에 옮긴다.
				ProductVO vo = new ProductVO(); //empty 상태
				vo.setProduct_id(rs.getInt("product_id"));
				vo.setSubcategory_id(rs.getInt("subcategory_id"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setBrand(rs.getString("brand"));
				vo.setPrice(rs.getInt("price"));
				vo.setFilename(rs.getString("filename"));
				vo.setDetail(rs.getString("detail"));
				
				itemList.add(getCreateItem(vo));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getShopMain().getDbManager().close(pstmt, rs);
		}
	}
	
	//상품 아이템 카드 생성하기
	public ProductItem getCreateItem(ProductVO vo) {
			ProductItem item = new ProductItem(this, vo, 200, 180);
			p_content.add(item);
			return item; //생성후 반환까지 하자
	}
	
}
