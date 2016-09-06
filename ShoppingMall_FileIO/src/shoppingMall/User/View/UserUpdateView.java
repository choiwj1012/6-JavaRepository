package shoppingMall.User.View;

import java.util.Scanner;

import shoppingMall.User.Vo.User;
import shoppingMall.mainController.MainController;

public class UserUpdateView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public UserUpdateView(){

		keyboard = new Scanner(System.in);

	}

	// method
	// 유저정보 수정을 위한 뷰 출력
	public void updateUserView(){


		System.out.println("수정할 값을 입력하세요");

		System.out.println("[이 름: ]");
		String userName = keyboard.next();

		System.out.println("[P W: ]");
		String userPW = keyboard.next();

		System.out.println("[E-MAIL: ]");
		String userEmail = keyboard.next();

		System.out.println("[주 소: ]");
		String userAddr = keyboard.next();

		System.out.println("[전화번호: ]");
		String userTel = keyboard.next();

		User updateUser = new User(null,userPW, userEmail, userName, userAddr, 0, userTel);

		MainController.getUserController().requestUpdateUserData(updateUser);
		
	}

}
