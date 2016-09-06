package shoppingMall.User.View;

import java.util.Scanner;

import shoppingMall.User.Vo.User;
import shoppingMall.mainController.MainController;

public class UserSearchView {
	
	// variable
	private Scanner keyboard;
	
	// constructor
	public UserSearchView(){
		
		keyboard = new Scanner(System.in);
	}

	// method
	// 조회를 위해 유저번호 입력받음
	public void getSearchNumber(){
		
		int getSearchNumber;
		
		System.out.println("조회 목록");
		System.out.println("찾으실 유저의 번호를 입력하시오");
		getSearchNumber = keyboard.nextInt();
		
		MainController.getUserController().requestUserSearchData(getSearchNumber);
		
	}
	
	
	// 유저정보 출력
	public void outputSearchProduct(User selectedUser){
		
		System.out.println("이름\tID\tPW\t나이\t주소\tE-MAIL\t전화번호");
	
			System.out.print(selectedUser.getUserName()+"\t");
			System.out.print(selectedUser.getUserID()+"\t");
			System.out.print(selectedUser.getUserPW()+"\t");
			System.out.print(selectedUser.getUserAge()+"\t");
			System.out.print(selectedUser.getUserAddr()+"\t");
			System.out.print(selectedUser.getUserEmail()+"\t");
			System.out.println(selectedUser.getUserTel());
		
	}
}
