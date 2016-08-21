package shoppingMall.controller;

import shoppingMall.dao.UserDAO;
import shoppingMall.view.AlertView;
import shoppingMall.view.UserView;
import shoppingMall.vo.User;

public class UserController{
	
	// variable
	private UserDAO userDAO;
	private UserView userView;
	
	// constructor
	public UserController(){
		
		this.userDAO = new UserDAO();
		this.userView = new UserView();
		
	}

	// method
	public void requestAddUser(){
		
		UserView userView = new UserView();
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

	
	public void requestUpdateUserInfo(){
		
		User checkedUser = userView.checkLogInUserView();
		int userIdentifiedNumber = userDAO.logIn(checkedUser);	
		User updateUser = userView.updateUserInfoView(userIdentifiedNumber);
		userDAO.updateUserInfo(updateUser, userIdentifiedNumber);	
			
	} // End of requestUpdateUserInfo()

	
	public void requestReadUserInfo(){
		
		User loginUser = userDAO.readUserInfo();
		userView.readUserInfoView(loginUser);
		
	} // End of requestReadUserInfo()

	
	public void requestWithdrawMember(){

		User loginUser = userDAO.readUserInfo();
		boolean agreeWithdraw = userView.withdrawMemberView(loginUser);
		
		if(agreeWithdraw){
			userDAO.withDrawMember(loginUser);
			MainController.menuController.requestMainMenu();
		}
		
	} // End of requestWithDrawMember()

	
	public void requestLogIn(){
		
		UserView userView = new UserView();
		User logInUser = userView.logInView();
		
		int UserIdentifiedNumber = userDAO.logIn(logInUser);
		AlertView alertView = new AlertView();
		
		if(UserIdentifiedNumber == 0){
			
			MainController.menuController.requestAdminMenu();
			
		} else if(UserIdentifiedNumber == -1){
			
			alertView.alert("로그인에 실패하였습니다");
			
		} else {
			
			MainController.menuController.requestUserMenu();
			
		}
		
	} // End of requestLogIn()

	
	public void requestLogOut(){
		
		User loginUser = userDAO.readUserInfo();
		boolean agreeLogOut = userView.logOutView();
		
		if(agreeLogOut){
			userDAO.logOut(loginUser);
			MainController.menuController.requestMainMenu();
		}
		
	} // End of requestLogOut()

}
