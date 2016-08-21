package shoppingMall.view;

import java.util.ArrayList;
import java.util.Scanner;

import shoppingMall.controller.MainController;
import shoppingMall.vo.Product;

public class CartView {
	
	// variable
	Scanner keyboard;
	
	// constructor
	public CartView(){
		
		this.keyboard = new Scanner(System.in);
	}

	// method
	public void displayCartListView(ArrayList<Product> carts){

		System.out.println("장바구니 리스트 입니다");
		System.out.println("상품번호\t상품명\t상품가격\t상품정보\t상품갯수");
		
		for(int i=0; i<carts.size(); i++){
			
			System.out.print(carts.get(i).getNumber() + "\t");
			System.out.print(carts.get(i).getName() + "\t");
			System.out.print(carts.get(i).getPrice() + "\t");
			System.out.print(carts.get(i).getInformation() + "\t");
			System.out.println(carts.get(i).getCountProductInCart());
			
		}
		
		System.out.println("메인으로 돌아가시려면 [b]를, 수정하시려면 [m]을, 결제하시려면 [p]를 눌러주세요");
		char mainOrPayment = keyboard.next().charAt(0);
		
		if(mainOrPayment == 'b'){
			
			MainController.menuController.requestUserMenu();
			
		} else if(mainOrPayment == 'm'){
			
			MainController.cartController.requestUpdateCartList();
			
		} else if(mainOrPayment == 'p'){
			
			this.actionPaymentView();
			
		} 
		
	} // End of displayCartListView()


	public void purchaseView(boolean success){
		
		if(success){
			
			System.out.println("상품이 성공적으로 장바구니에 넣어졌습니다");
			
		} else {
			
			System.out.println("그런 상품이 없습니다");
			
		}
		
		System.out.println("계속 주문하시겠습니까? [y] 혹은 [n]을 눌러주세요");
		char yesOrNo = keyboard.next().charAt(0);
		
		if(yesOrNo == 'y'){
			
			MainController.cartController.requestPurchase();
			
		} else if(yesOrNo == 'n'){
			
			MainController.menuController.requestUserMenu();
			
		} else {
			
			System.out.println("잘못 누르셨습니다");
			
		}
			
	} // End of purchaseView()
	
	
	public int selectedCartList(){
		
		System.out.println("수정하실 카트속 상품번호를 선택하세요");
		int selectedCartList = keyboard.nextInt();
		
		return selectedCartList;
		
	}
	
	public int updateCartListView(Product selectedProductInCart){
		
		System.out.println("삭제를 원하시면 1번을, 수량을 조정하시려면 2번을 눌러주세요");
		int selectedNum = keyboard.nextInt();
		
		if(selectedNum == 1){
			
			System.out.println("삭제되었습니다");
			return 0;
			
		} else if(selectedNum == 2){
			
			System.out.println("몇 개로 수정하시겠습니까?");
			int updateNumber = keyboard.nextInt();
			return updateNumber;
			
		} else {
			
			System.out.println("잘못 누르셨습니다");	
			
		}

		return 0;
		
	} // End of updateCartListView()


	public void actionPaymentView(){
		
		while(true) {

			System.out.println("결제 방식을 선택해주세요. (1)CASH (2)CARD (3)NAVER PAY");
			int payTypeChoice=keyboard.nextInt();

			if(payTypeChoice == 1) {

				System.out.println("CASH로 결제되었습니다.");
				System.out.println("이용해 주셔서 감사합니다.");
				System.out.println();
				break;

			} else if(payTypeChoice == 2) {

				System.out.println("CARD로 결제되었습니다.");
				System.out.println("이용해 주셔서 감사합니다.");
				System.out.println();
				break;

			} else if(payTypeChoice == 3) {

				System.out.println("NAVER PAY로 결제되었습니다.");
				System.out.println("이용해 주셔서 감사합니다.");
				System.out.println();
				break;

			} else {

				System.err.println("잘못입력하셨습니다. 다시 입력해주세요.");

			}
		}
		
		// 카트비우기 실행해야함
		
	} // End of actionPaymentView()
	
}
