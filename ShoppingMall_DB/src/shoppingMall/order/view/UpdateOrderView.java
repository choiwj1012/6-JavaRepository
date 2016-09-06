package shoppingMall.order.view;

import java.util.Scanner;

import shoppingMall.order.vo.Order;

public class UpdateOrderView {

	// variable
	Scanner keyboard;

	// constructor
	public UpdateOrderView(){

		this.keyboard = new Scanner(System.in);

	}


	// method
	// 주문한 상품 수정하기
	public Order orderUpdate(){

		Order orderUpdate = new Order();
		System.out.println("수정하실 장바구니의 주문번호를 선택해주세요");
		int selectedProductNum = keyboard.nextInt();
		orderUpdate.setOrderNumber(selectedProductNum);
		
		while(true){
			
			System.out.println("1.수량 조정하기 || 2.주문 삭제하기 || 3. 나가기");
			int selectedMenu = keyboard.nextInt();
			int orderCount = 0;

			if(selectedMenu == 1){

				System.out.println("조정하실 수량을 입력하십시오");
				orderCount = keyboard.nextInt();
				orderUpdate.setProductCount(orderCount);

			} else if(selectedMenu == 2){

				System.out.println("주문 삭제 되었습니다");
				orderUpdate.setProductCount(-1);
				return orderUpdate;

			} else if(selectedMenu == 3){
				
				break;
				
			} else {

				System.out.println("잘못 입력하셨습니다");

			}
		}
		
		return orderUpdate;
		
	}


}
