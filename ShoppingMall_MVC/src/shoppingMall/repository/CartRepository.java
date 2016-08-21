package shoppingMall.repository;

import java.util.ArrayList;

import shoppingMall.vo.ProductInCart;

public class CartRepository {

	// 장바구니(카트) 배열
	private ArrayList<ProductInCart> carts = new ArrayList<ProductInCart>();
	
	// 장바구니(카트) 안의 상품 갯수
	private int productNumberInCart;

	// getter and setter
	public ArrayList<ProductInCart> getCarts() {
		return carts;
	}

	public int getProductNumberInCart() {
		return productNumberInCart;
	}

	public void setProductNumberInCart(int productNumberInCart) {
		this.productNumberInCart = productNumberInCart;
	}
	
}
