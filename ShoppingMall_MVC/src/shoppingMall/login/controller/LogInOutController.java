package shoppingMall.login.controller;

import shoppingMall.login.dao.LogInOutDAO;
import shoppingMall.login.view.LogInOutView;
import shoppingMall.main.controller.MainController;
import shoppingMall.user.vo.User;
import shoppingMall.util.view.AlertView;

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

			mainController.getMenuController().requestAdminMenu();

		} else if(UserIdentifiedNumber == -1){

			alertView.alert("로그인에 실패하였습니다");

		} else {

			mainController.getMenuController().requestUserMenu();

		}

	} // End of requestLogIn()


	public User requestCheckUser(){
		
		LogInOutView logInOutView = new LogInOutView(mainController);
		User loginCheckUser = logInOutView.checkLogInUserView();
		return loginCheckUser;
		
	} // End of requestCheckUser()
	
	
	public void requestLogOut(){ // 로그아웃 요청

		LogInOutView logInOutView = new LogInOutView(mainController);
		User loginUser = mainController.getUserController().getUserDAO().readUserInfo();
		boolean agreeLogOut = logInOutView.logOutView();

		if(agreeLogOut){
			logInOutDAO.logOut(loginUser);
			mainController.getCartController().requestLogOut();
			mainController.getMenuController().requestMainMenu();
		}

	} // End of requestLogOut()


}
