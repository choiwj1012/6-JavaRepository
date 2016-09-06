package loginController;

import MainController.Controller;
import loginDao.LoginDao;
import loginView.LoginView;
import loginVo.Login;
import mainView.AlertView;

public class LoginController {

	private LoginDao loginDao;
	
	public LoginController(){
		
		this.loginDao = new LoginDao();
		
	}
	
	// �α��� ��û�� ó���ϴ� �޼���
	public void requestLogin(){
		
		// ���̵�� �н����带 �Է��ϴ� ȭ�鿡�� �α��� ����(Login)ȹ��
		LoginView loginView = new LoginView();
		Login newLogin = loginView.login();
		
		// ȹ���� �α��� ������ ���� ȸ�� ���̺����� �α��� ������ �ش��ϴ� ȸ���� �ִ��� üũ
		boolean success = loginDao.login(newLogin);
		
		if(success){
			new AlertView().alert("�α��� ����");
		} else {
			new AlertView().alert("�α��� ����");	
		}
		
		// ��ǰ ��Ʈ�ѷ��� ��ǰ ��� ���⸦ ��û��
		new AlertView().alert("��ǰ ��Ʈ�ѷ��� ��ǰ ��� ���⸦ ��û");
		Controller.getProductController().requestSelectList();
		
	}
	
	
	// ���� �α��� ����(�α׿�, �α׾ƿ�)(LoginRepository.getLogin() != null, �α׾ƿ� == null)
	public boolean requestCheckLogin(){
		
		boolean success = loginDao.checkLogin();
		
		return success;
		
	}
	
	// �α׾ƿ� ��û�� ó���ϴ� �޼���
	public void requestLogout() {

		loginDao.logout();
		
	}
	
}