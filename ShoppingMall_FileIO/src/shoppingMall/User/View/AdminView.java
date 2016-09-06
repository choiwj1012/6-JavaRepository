package shoppingMall.User.View;

import java.util.Scanner;

import shoppingMall.mainController.MainController;
import shoppingMall.mainView.MainView;

public class AdminView {
	
	// variable
	Scanner keyboard;
	
	// constructor
	public AdminView(){
		
		this.keyboard = new Scanner(System.in);
		
	}

	// method
	// 관리자 메뉴 
	public void adminView(){
		
		System.out.println("관리자 페이지 입니다");
		
		while(true){
			
			String[] adminMainMenu = {"1. 상품관리","2. 유저관리","3. 게시판관리","4. 주문관리","5. 데이터분석","6. 관리자 로그아웃"};
			
			for(int i=0; i<adminMainMenu.length; i++){
				
				System.out.println(adminMainMenu[i]);
				
			}
			
			System.out.println("원하시는 메뉴를 선택해 주십시오 > " );	
			int selectedMenu = keyboard.nextInt();
			
			if(selectedMenu == 1){ // 상품관리
				
				MainController.getProductController().requestProductMenuView();
				
			} else if(selectedMenu == 2){ // 유저관리
				
				MainController.getUserController().requestUserMenu();
				
				
			} else if(selectedMenu == 3){ // 게시판관리
				
				System.out.println("준비중 입니다");
				
			} else if(selectedMenu == 4){ // 주문관리
				
				System.out.println("준비중 입니다");
				
			} else if(selectedMenu == 5){ // 데이터분석
				
				System.out.println("준비중 입니다");
				
			} else if(selectedMenu == 6){ // 관리자 로그아웃
				
				System.out.println("관리자 메뉴를 종료합니다");
				MainView mainView = new MainView();
				mainView.mainView();
				
			} else {
				
				System.out.println("잘못입력하셨습니다");
				
			}
			
		}
		
	} // End of adminMenuView();
	
}
