package shoppingMall.Login.View;

import java.util.Scanner;

import shoppingMall.Login.Vo.Login;
import shoppingMall.mainController.MainController;


public class LoginView {
	
	// variable
	private Scanner keyboard;
	
	// constructor
	public LoginView(){
		
		keyboard = new Scanner(System.in);
		
	}

	// method
	// 로그인 입력창
	public void loginView(){

		System.out.println("로그인");
		
		System.out.println("[I D: ]");
		String ID = keyboard.next();
		
		System.out.println("[P W: ]");
		String PW = keyboard.next();
		
		Login login = new Login(ID,PW);
		
		MainController.getLoginController().requestLoginData(login);
		
	}


}
