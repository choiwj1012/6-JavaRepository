package shoppingMall.controller;

import shoppingMall.dao.LogInOutDAO;
import shoppingMall.view.AlertView;
import shoppingMall.view.LogInOutView;
import shoppingMall.vo.User;

public class LogInOutController {

	// variable
	private MainController mainController;
	private LogInOutDAO logInOutDAO;

	// constructor
	public LogInOutController(MainController mainController){

		this.mainController = mainController;
		this.logInOutDAO = new LogInOutDAO();

	}
	
	// method
	public LogInOutDAO getLogInOutDAO() {
		return logInOutDAO;
	}

	
	public void requestLogIn(){ // 로그인 요청

		LogInOutView logInOutView = new LogInOutView(mainController);
		User logInUser = logInOutView.logInView();
		
		int UserIdentifiedNumber = logInOutDAO.logIn(logInUser);
		AlertView alertView = new AlertView();

		if(UserIdentifiedNumber == 0){

			mainController.menuController.requestAdminMenu();

		} else if(UserIdentifiedNumber == -1){

			alertView.alert("로그인에 실패하였습니다");

		} else {

			mainController.menuController.requestUserMenu();

		}

	} // End of requestLogIn()


	public User requestCheckUser(){
		
		LogInOutView logInOutView = new LogInOutView(mainController);
		User loginCheckUser = logInOutView.checkLogInUserView();
		return loginCheckUser;
		
	} // End of requestCheckUser()
	
	
	public void requestLogOut(){ // 로그아웃 요청

		LogInOutView logInOutView = new LogInOutView(mainController);
		User loginUser = mainController.userController.getUserDAO().readUserInfo();
		boolean agreeLogOut = logInOutView.logOutView();

		if(agreeLogOut){
			logInOutDAO.logOut(loginUser);
			mainController.cartController.requestLogOut();
			mainController.menuController.requestMainMenu();
		}

	} // End of requestLogOut()


}
