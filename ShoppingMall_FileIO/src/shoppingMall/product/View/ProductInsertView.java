package shoppingMall.product.View;

import java.util.Scanner;

import shoppingMall.product.vo.Product;

public class ProductInsertView {
	
	// variable
	private Scanner keyboard;
	
	// constructor
	public ProductInsertView() {
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	// method
	// 상품등록을 위한 정보받기
	public Product productInsertView() {
				
		System.out.println("[제품등록 모드]");
		System.out.println("------------------------------");
		
		System.out.print("제품명 : ");
		String productName = keyboard.next();
		
		System.out.print("제품가격 : ");
		int productPrice = keyboard.nextInt();

		System.out.print("제품브랜드 : ");
		String productBrandName = keyboard.next();
		
		System.out.print("제품컬러 : ");
		String productColor = keyboard.next();
		System.out.println();
		
		Product newProduct = new Product(productName, productPrice, productBrandName, productColor);
		
		return newProduct;
		
	}
	
}
