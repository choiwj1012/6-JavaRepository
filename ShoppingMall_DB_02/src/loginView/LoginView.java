package loginView;

import java.util.Scanner;

import loginVo.Login;

public class LoginView {
	
	// variable
	private Scanner keyboard;

	// constructor
	public LoginView(){

		this.keyboard = new Scanner(System.in);

	}

	// method
	// 로그인 정보 입력화면
	public Login login(){

		Login login = null;

		System.out.println("[로그인모드입니다]");

		System.out.print("아이디 : ");
		String userId = keyboard.next();

		System.out.print("비밀번호 : ");
		String userPassword = keyboard.next();
		
		login = new Login(userId, userPassword);

		return login;

	}

}
