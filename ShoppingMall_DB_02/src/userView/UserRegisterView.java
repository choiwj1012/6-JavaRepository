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
		
		System.out.println("[������ϸ���Դϴ�]");
		
		System.out.print("���̵� : ");
		String userId = keyboard.next();
		
		System.out.print("��й�ȣ : ");
		String userPassword = keyboard.next();
		
		System.out.println("�����̸� : ");
		String userName = keyboard.next();
		
		user = new User(userId, userPassword, userName);
		
		return user;
		
	}
	
}
