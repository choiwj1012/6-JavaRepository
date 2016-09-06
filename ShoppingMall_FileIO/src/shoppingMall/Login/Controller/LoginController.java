package shoppingMall.Login.Controller;

import shoppingMall.Login.Dao.LoginDao;
import shoppingMall.Login.View.LoginView;
import shoppingMall.Login.Vo.Login;
import shoppingMall.mainController.MainController;

public class LoginController {

	// variable
	private LoginDao loginDao;

	// constructor
	public LoginController(){

		loginDao = new LoginDao();

	}

	// method
	// 로그인뷰 요청
	public void requestLogin(){

		LoginView loginView = new LoginView();
		loginView.loginView();

	}


	// 로그인 데이터 확인요청
	public void requestLoginData(Login login){

		int loginUserNumber = loginDao.login(login);

		if(loginUserNumber == 1){

			MainController.requestMainAlertView("관리자로그인성공");
			MainController.getUserController().requestAdminView();

		}else if(loginUserNumber == -1){

			MainController.requestMainAlertView("로그인 실패");

		} else {

			MainController.requestMainAlertView("유저 로그인 성공");
			MainController.getUserController().requestUserMenuView();

		}

	}


	// 로그아웃 요청
	public void requestLogOut(){

		boolean success = loginDao.logOut();
		
		if(success){

			MainController.requestMainAlertView("로그아웃 되었습니다.");
			MainController.requestMainView();

		}

	}


	// 로그인 상태 체크 요청
	public boolean requestLoginCheck(){

		boolean success = loginDao.checkLogin();

		if(!success){

			MainController.requestMainAlertView("로그인 되어있지 않습니다.");

		}

		return success;

	}

}