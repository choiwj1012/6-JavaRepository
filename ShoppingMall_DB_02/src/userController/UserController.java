package userController;

import MainController.Controller;
import userDao.UserDao;
import userView.UserRegisterView;
import userVo.User;

public class UserController {

	private UserDao userDao;
	
	public UserController() {
	
		userDao = new UserDao();
		
	}
	
	// ȸ�� ���(����) ��û�� ó���ϴ� �޼���
	public void requestRegister(){
		
		// ȸ�� ����� ���ؼ� ȸ�� ������ �Է��ϴ� ȭ�� ǥ��(��, ȸ�� ��ȣ�� �ý��ۿ��� �ڵ� ���������� �������� �ʴ´�)
		UserRegisterView userRegisterView = new UserRegisterView();
		User newUser = userRegisterView.regist();
		
		// ������ ȸ�� ������ ȸ�� ���̺��� ��� (insert)
		userDao.register(newUser);
		
		// ��ǰ ��Ʈ�ѷ��� ��ǰ ��� ǥ�� ȭ������ �̵�
		Controller.getProductController().requestSelectList();
		
	}
	
	
}