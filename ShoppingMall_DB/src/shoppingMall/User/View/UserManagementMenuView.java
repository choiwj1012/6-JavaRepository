package shoppingMall.User.View;

import java.util.Scanner;

import shoppingMall.mainController.MainController;

public class UserManagementMenuView {

	// variable
	private Scanner keyboard;

	// constructor
	public UserManagementMenuView(){

		this.keyboard = new Scanner(System.in);

	}


	// method
	// 유저관리메뉴 출력
	public void userManagementMenuView(){

		while(true){

			System.out.println("유저관리메뉴");
			System.out.println("1.유저리스트 2.유저조회 3.유저삭제 4.나가기");
			int selectUserManagementMemu = keyboard.nextInt();

			if(selectUserManagementMemu == 1){

				System.out.println("유저 리스트메뉴 입니다.");
				MainController.getUserController().requestUserList();

			}else if(selectUserManagementMemu == 2){

				System.out.println("유저 조회메뉴 입니다.");
				MainController.getUserController().requestUserSearch();

			}else if(selectUserManagementMemu == 3){

				System.out.println("유저 삭제 메뉴입니다.");
				MainController.getUserController().requestDeleteUser();

			}else if(selectUserManagementMemu == 4){
				
				break;
			
			}else{
				
				System.out.println("선택하신 번호가 없습니다.");
			}
			
		}
		
	}
	
}
