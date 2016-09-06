package shoppingMall.order.view;

import java.util.Scanner;

import shoppingMall.mainController.MainController;

public class OrderMenuView {

	// variable
	Scanner keyboard;

	// constructor
	public OrderMenuView() {
		
		this.keyboard = new Scanner(System.in);
		
	}

	// method
	// 주문 메뉴
	public void orderMenu(){

		System.out.println("상품 구매 페이지 입니다");

		while(true){
			
			System.out.println("원하시는 항목을 선택해 주세요");
			System.out.println("1. 상품구매  2. 상품전체보기 3. 장바구니 확인 4. 장바구니 수정 5. 나가기");
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1){
				
				// 상품구매
				MainController.getOrderController().requestOrder(); 
				
			} else if(selectedMenu == 2){
				
				// 상품전체보기
				 MainController.getProductController().requestReadProduct();

			} else if(selectedMenu == 3){

				// 장바구니 확인
				MainController.getOrderController().requestOrderList(); 
				
			} else if(selectedMenu == 4){

				// 장바구니 수정
				MainController.getOrderController().requestUpdateOrder(); 

			} else if(selectedMenu == 5){

				// 나가기
				break; 
				
			} else {
				
				System.out.println("잘못입력하셨습니다");
				
			}
			
		}
		
	}

}
