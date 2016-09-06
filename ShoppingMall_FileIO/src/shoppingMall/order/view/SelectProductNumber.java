package shoppingMall.order.view;

import java.util.Scanner;

import shoppingMall.order.vo.Order;

public class SelectProductNumber {

	// variable
	Scanner keyboard;
	
	// constructor
	public SelectProductNumber() {

		this.keyboard = new Scanner(System.in);
		
	}
	
	// method
	// 유저가 주문하고자 하는 상품 번호 선택
	public Order selectProductNumber(){
		
		Order order = new Order();
		
		System.out.println("주문을 원하시는 상품 번호를 선택하여 주십시오");
		int selectedProductNumber = keyboard.nextInt();
		order.setProductNumber(selectedProductNumber);
		
		System.out.println("주문하실 상품의 수량을 선택하여 주십시오");
		int selectedProductCount = keyboard.nextInt();
		order.setProductCount(selectedProductCount);
		
		return order;
		
	}
		
}
