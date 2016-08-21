package shoppingMall.repository;

import java.util.ArrayList;

import shoppingMall.vo.Product;

public class ProductRepository {

	// 상품 배열
	private ArrayList<Product> products = new ArrayList<Product>();
	
	// 상품 번호
	private int lastProductPosition;

	// constructor
	public ProductRepository(){
		
		Product initialProduct = new Product("TV",100000,"티비");
		this.products.add(0, initialProduct);
		this.lastProductPosition = 1;
		
	}
	
	// getter and setter
	public ArrayList<Product> getProduct() {
		return products;
	}

	public int getLastProductPosition() {
		return lastProductPosition;
	}

	public void setLastProductPosition(int lastProductPosition) {
		this.lastProductPosition = lastProductPosition;
	}
	
}
