package shoppingMall.product.View;

import java.util.Scanner;

import shoppingMall.mainController.MainController;

public class ProductDeleteView {
	
	// variable
	private Scanner keyboard;
	
	// constructor
	public ProductDeleteView() {
	
		this.keyboard = new Scanner(System.in);
		
	}
	
	// method
	// 상품삭제를 위한 번호요청
	public void productDelete() {
		
		System.out.println("[!]삭제할 제품 번호를 선택 하세요.");
		System.out.println("번호선택 : ");
		int selectedProductNumber = keyboard.nextInt();

		//selectedProductNumber()통해 전달 받은 입력값을 Controller의 requestGetSelectedProductNumber()으로 전달.
		MainController.getProductController().requestGetSelectedProductNumber(selectedProductNumber);

	}

}
