package shoppingMall.view;

import java.util.Scanner;

import shoppingMall.controller.MainController;
import shoppingMall.vo.User;

public class LogInOutView {
	
	// variable
	Scanner keyboard;
	MainController mainController;
	
	// constructor
	public LogInOutView(MainController mainController){
		
		this.keyboard = new Scanner(System.in);
		this.mainController = mainController;
	}
	
	// method 
	public User logInView(){

		System.out.println("로그인 정보를 입력하세요");

		System.out.println("사용자 ID : ");
		String userID = keyboard.next();

		System.out.println("사용자 PW : ");
		String userPW = keyboard.next();

		User logInUser = new User(userID, userPW);

		return logInUser;

	} // End of logInView()

	
	public User checkLogInUserView(){

		User checkedUser = null;

		System.out.println("본인 정보 수정을 위해서 재 로그인 하셔야 합니다");

		checkedUser = this.logInView();

		return checkedUser;

	} // End of checkLogInUserView()
	
	
	public boolean logOutView(){

		boolean agreeLogOut = false;

		System.out.println("정말로 로그아웃 하십니까? [y] 혹은 [n] 을 누르십시오");
		char yesOrNo = keyboard.next().charAt(0); 

		if(yesOrNo == 'y'){
			agreeLogOut = true;
			return agreeLogOut;
		}

		return agreeLogOut;

	} // End of logOutView()
	
}
