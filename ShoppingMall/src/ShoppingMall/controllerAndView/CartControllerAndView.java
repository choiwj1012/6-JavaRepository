package ShoppingMall.controllerAndView;

import java.util.ArrayList;
import java.util.Scanner;

import ShoppingMall.DAO.CartDAO;
import ShoppingMall.domain.Product;

public class CartControllerAndView {

	// variable
	public Scanner keyboard = new Scanner(System.in);
	public CartDAO cartDAO;

	// constructor
	public CartControllerAndView() {
		
		this.cartDAO = new CartDAO();
		
	}
	
	// method
	public void purchase() { // 상품구매하기

		MainControllerAndView.productControllerAndView.displayProductList();

		while(true) {
			
			boolean success = false;
			
			System.out.println();
			System.out.print("구매할 상품 번호 : ");
			int number = keyboard.nextInt();
			success = cartDAO.purchase(number);
			
			if(!success){
				System.out.println("그런 상품이 없습니다");
			}
			
			System.out.print("계속 하시겠습니까?(y/n)" );			
			char isContinue = keyboard.next().charAt(0);

			if(isContinue == 'n') {
				break;
			}

		}

		displayCartList(); // 카트리스트로 이동

	} // End of purchase()
	
	
	public void displayCartList() { // 카트리스트 출력

		ArrayList<Product> cart = cartDAO.displayCartList();
		int sum = 0;
		
		if(cart == null){
			System.err.println("아무 상품이 없습니다. 메인메뉴로 돌아갑니다");
			MainControllerAndView.mainMenu();
		}
		
		System.out.println("번호\t상품명\t가격\t수량");
		for(int i = 0; i < cart.size(); i++) {
			System.out.print(cart.get(i).getNumber() + "\t");
			System.out.print(cart.get(i).getName() + "\t");
			System.out.print(cart.get(i).getPrice() + "\t");
			System.out.println(cart.get(i).getCount());

			sum = sum + cart.get(i).getPrice() * cart.get(i).getCount();

		}

		System.out.println("합계 : " + sum);	

		updateCartList(); // 카트리스트 수정메서드 실행

	} // End of displayCartList()
	
	
	public void updateCartList() { // 카트리스트 수정

		boolean success = false;
		
		while(true) {
			
			System.out.println("카트리스트를 수정하시겠습니까? (y/n)");
			char selectedMenu = keyboard.next().charAt(0);

			if(selectedMenu == 'y') {
				
				System.out.println("삭제할 상품 번호를 입력해주세요.");
				int selectedCartListNum = keyboard.nextInt();
				success = cartDAO.updateCartList(selectedCartListNum);
				// displayCartList();
				
				if(!success) {
					System.out.println("카트리스트 수정 실패");
					break;
				}
				
			}else if(selectedMenu == 'n') {
				
				actionPayment();  // 결제메서드 실행
				break;
				
			}
		}

	} // End of updateCartList()
	
	
	public void actionPayment() { // 결제하기

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

		// 카트 비우기
		cartDAO.resetCart();

	} // End of actionPayment()

}
