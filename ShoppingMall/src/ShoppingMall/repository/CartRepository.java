package ShoppingMall.repository;

import java.util.ArrayList;

import ShoppingMall.domain.Product;

public class CartRepository {
		
	// 상품 배열 리스트
	public ArrayList<Product> carts = new ArrayList<Product>();
	
	// 카트 상품 번호
	public int lastCartNumber = 0;
	
}
