package shoppingMall.product.view;

import java.util.Scanner;

import shoppingMall.product.vo.Product;

public class AddProductView {
	
	// variable
	private Scanner keyboard;

	// constructor
	public AddProductView(){

		this.keyboard = new Scanner(System.in);

	}
	
	// method
	public Product addProductView(){

		System.out.println("상품등록 화면입니다");
		System.out.println("상품명을 입력하십시오 >");
		String name = keyboard.next();

		System.out.println("상품가격을 입력하십시오 >");
		int price = keyboard.nextInt();

		System.out.println("상품정보를 입력하십시오 >");
		String information = keyboard.next();

		Product newProduct = new Product(name, price, information);

		return newProduct;

	} // End of addProductView()

}
