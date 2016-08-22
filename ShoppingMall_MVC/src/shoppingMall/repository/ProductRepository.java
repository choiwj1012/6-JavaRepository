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
		
		// 기본적으로 생성되는 상품 3가지 등록
		Product initialProduct = new Product("TV",100000,"티비");
		initialProduct.setNumber(1);
		this.products.add(0, initialProduct);
		
		initialProduct = new Product("Phone",200000,"핸드폰");
		this.products.add(1, initialProduct);
		initialProduct.setNumber(2);
		
		initialProduct = new Product("Vacuum",300000,"청소기");
		this.products.add(2, initialProduct);
		initialProduct.setNumber(3);
		
		this.lastProductPosition = 3;
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
