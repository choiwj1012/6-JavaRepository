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
	// �α��� ���� �Է�ȭ��
	public Login login(){

		Login login = null;

		System.out.println("[�α��θ���Դϴ�]");

		System.out.print("���̵� : ");
		String userId = keyboard.next();

		System.out.print("��й�ȣ : ");
		String userPassword = keyboard.next();
		
		login = new Login(userId, userPassword);

		return login;

	}

}
