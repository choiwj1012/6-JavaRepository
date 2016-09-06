package shoppingMall.product.View;

import java.util.Scanner;

import shoppingMall.mainController.MainController;

public class ProductSearchView {
	
	// variable 
	private Scanner keyboard;
	
	// constructor
	public ProductSearchView() {
	
		this.keyboard = new Scanner(System.in);
		
	}
	
	// method
	// 상품검색
	public void productSearch() {

		System.out.println("[상품검색 모드]");
		System.out.println("[!]검색할 제품 번호를 선택 하세요.");
		System.out.println("번호입력 : ");
		int searchProductNumber = keyboard.nextInt();
		
		MainController.getProductController().requestSearchProductNumber(searchProductNumber);
		
	}

}
