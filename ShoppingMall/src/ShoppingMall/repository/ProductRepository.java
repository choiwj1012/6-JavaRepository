package ShoppingMall.repository;

import java.util.ArrayList;

import ShoppingMall.domain.Product;

public class ProductRepository {
		
	// 상품 배열 리스트
	public ArrayList<Product> products = new ArrayList<Product>();
	
	// 상품 숫자 카운팅
	public int lastProductNumber = 0;
	
}
