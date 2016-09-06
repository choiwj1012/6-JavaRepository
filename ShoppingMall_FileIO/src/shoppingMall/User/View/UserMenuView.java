package shoppingMall.User.View;

import java.util.Scanner;

import shoppingMall.mainController.MainController;

public class UserMenuView {

	// variable
	Scanner keyboard;
	
	// constructor
	public UserMenuView(){
		
		this.keyboard = new Scanner(System.in);
		
	}

	// method
	// 관리자 메뉴 
	public void userMenuView(){
		
		System.out.println("유저 페이지 입니다");
		
		while(true){
			
			String[] adminMainMenu = {"1. 상품구매", "2. 회원정보관리", "3. 로그 아웃", "4. 탈퇴"};
			
			for(int i=0; i<adminMainMenu.length; i++){
				
				System.out.println(adminMainMenu[i]);
				
			}
			
			System.out.println("원하시는 메뉴를 선택해 주십시오 > " );	
			int selectedMenu = keyboard.nextInt();
			
			if(selectedMenu == 1){ // 상품구매
				
				MainController.getOrderController().requestOrderMenu();
				
			} else if(selectedMenu == 2){ // 회원정보관리
				
				MainController.getUserController().requestUpdateUser();
				
			} else if(selectedMenu == 3){ // 로그아웃
				
				MainController.getLoginController().requestLogOut();
				
			} else if(selectedMenu == 4){ // 회원탈퇴
				
				//MainController.getUserController().requestWithdrawUser();
				MainController.getLoginController().requestLogOut();
				MainController.requestMainView();
				
			}
			
		}
		
	} // End of userMenuView();
	
}
