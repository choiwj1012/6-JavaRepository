package shoppingMall.repository;

import java.util.ArrayList;

import shoppingMall.vo.Product;

public class CartRepository {

	// 장바구니(카트) 배열
	private ArrayList<Product> carts = new ArrayList<Product>();
	
	// 장바구니(카트) 안의 상품 갯수
	private int productNumberInCart;

	// getter and setter
	public ArrayList<Product> getCarts() {
		return carts;
	}

	public int getProductNumberInCart() {
		return productNumberInCart;
	}

	public void setProductNumberInCart(int productNumberInCart) {
		this.productNumberInCart = productNumberInCart;
	}
	
}
