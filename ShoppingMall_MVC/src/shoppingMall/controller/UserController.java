package shoppingMall.controller;

import shoppingMall.dao.UserDAO;
import shoppingMall.view.AlertView;
import shoppingMall.view.UserView;
import shoppingMall.vo.User;

public class UserController{
	
	// variable
	private MainController mainController;
	private UserDAO userDAO;
	
	// constructor
	public UserController(MainController mainController){
		
		this.mainController = mainController;
		this.userDAO = new UserDAO();
		
	}

	// method
	public void requestAddUser(){ // 유저 등록하기 요청
		
		UserView userView = new UserView(mainController);
		User newUser = userView.addUserView();
		boolean success = userDAO.addUser(newUser);
		
		AlertView alertView = new AlertView();
		if(success){
			
			alertView.alert("성공적으로 가입되었습니다");
			alertView.alert("로그인 후 서비스 이용가능합니다");
			
		} else {
			
			alertView.alert("동일한 아이디가 존재합니다");
			
		}
		
	} // End of requestAddUser()

	
	public void requestUpdateUserInfo(){ // 유저정보 수정하기 요청
		
		UserView userView = new UserView(mainController);
		User checkedUser = userView.checkLogInUserView();
		int userIdentifiedNumber = userDAO.logIn(checkedUser);	
		User updateUser = userView.updateUserInfoView(userIdentifiedNumber);
		userDAO.updateUserInfo(updateUser, userIdentifiedNumber);	
			
	} // End of requestUpdateUserInfo()

	
	public void requestReadUserInfo(){ // 유저정보 읽기 요청
		
		UserView userView = new UserView(mainController);
		User loginUser = userDAO.readUserInfo();
		userView.readUserInfoView(loginUser);
		
	} // End of requestReadUserInfo()

	
	public void requestWithdrawMember(){ // 회원탈퇴 요청

		UserView userView = new UserView(mainController);
		User loginUser = userDAO.readUserInfo();
		boolean agreeWithdraw = userView.withdrawMemberView(loginUser);
		
		if(agreeWithdraw){
			userDAO.withDrawMember(loginUser);
			mainController.menuController.requestMainMenu();
		}
		
	} // End of requestWithDrawMember()

	
	public void requestLogIn(){ // 로그인 요청
		
		UserView userView = new UserView(mainController);
		User logInUser = userView.logInView();
		
		int UserIdentifiedNumber = userDAO.logIn(logInUser);
		AlertView alertView = new AlertView();
		
		if(UserIdentifiedNumber == 0){
			
			mainController.menuController.requestAdminMenu();
			
		} else if(UserIdentifiedNumber == -1){
			
			alertView.alert("로그인에 실패하였습니다");
			
		} else {
			
			mainController.menuController.requestUserMenu();
			
		}
		
	} // End of requestLogIn()

	
	public void requestLogOut(){ // 로그아웃 요청
		
		UserView userView = new UserView(mainController);
		User loginUser = userDAO.readUserInfo();
		boolean agreeLogOut = userView.logOutView();
		
		if(agreeLogOut){
			userDAO.logOut(loginUser);
			mainController.menuController.requestMainMenu();
		}
		
	} // End of requestLogOut()

}
