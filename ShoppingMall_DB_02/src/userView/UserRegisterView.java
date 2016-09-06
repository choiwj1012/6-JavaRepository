package userView;

import java.util.Scanner;

import userVo.User;

public class UserRegisterView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public UserRegisterView(){
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	// method
	public User regist(){
		
		User user = null;
		
		System.out.println("[유저등록모드입니다]");
		
		System.out.print("아이디 : ");
		String userId = keyboard.next();
		
		System.out.print("비밀번호 : ");
		String userPassword = keyboard.next();
		
		System.out.println("유저이름 : ");
		String userName = keyboard.next();
		
		user = new User(userId, userPassword, userName);
		
		return user;
		
	}
	
}
