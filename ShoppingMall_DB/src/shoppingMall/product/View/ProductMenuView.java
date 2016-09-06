package shoppingMall.product.View;

import java.util.Scanner;

import shoppingMall.mainController.MainController;

public class ProductMenuView {
	
	// variable
	private Scanner keyboard;
	
	// constructor
	public ProductMenuView() {
		
		this.keyboard = new Scanner(System.in);
		
	}
		
	// method
	// 상품관리 메뉴뷰 출력
	public void productMenuView() {
		
		while(true) {
			
			String[] productMenuItem = {"1.상품선택조회","2.상품전체조회","3.상품등록","4.상품수정","5.상품삭제","6.전단계로"};
			
			for(int i = 0 ; i < productMenuItem.length ; i++) {
				System.out.println(productMenuItem[i]);
			}
			
			System.out.println("[상품관리]");
			System.out.println("번호선택 : ");
			int selectedNumber = keyboard.nextInt();
			
			if(selectedNumber == 1) {
				
				//상품조회
				MainController.getProductController().requestSearchProduct();
				
			} else if(selectedNumber == 2) {
				
				//상품전체조회
				MainController.getProductController().requestReadProduct();
				
			} else if (selectedNumber == 3) {
				
				//상품등록
				MainController.getProductController().requestRegisterProduct();
				
			} else if (selectedNumber == 4) {
				
				//상품수정
				MainController.getProductController().requestUpdateProductInfo();
				
			} else if (selectedNumber == 5) {
				
				//상품삭제
				MainController.getProductController().requestDeleteProductView();
				
			} else if (selectedNumber == 6) {
				
				//바로 전 단계 메뉴로 돌아가기
				break;
				
			} else {
				
				System.out.println("[!]없는 번호 입니다.");
				
			}
			
		}//end of while
		
	}

}
