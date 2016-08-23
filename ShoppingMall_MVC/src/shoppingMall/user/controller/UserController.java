package shoppingMall.user.controller;

import java.util.ArrayList;

import shoppingMall.main.controller.MainController;
import shoppingMall.user.dao.UserDAO;
import shoppingMall.user.view.UserView;
import shoppingMall.user.vo.User;
import shoppingMall.util.view.AlertView;

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
	public UserDAO getUserDAO() {
		return userDAO;
	}

	
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
		User checkedUser = mainController.getLogInOutController().requestCheckUser();
		int userIdentifiedNumber = mainController.getLogInOutController().getLogInOutDAO().logIn(checkedUser);
		User updateUser = userView.updateUserInfoView(userIdentifiedNumber);
		userDAO.updateUserInfo(updateUser, userIdentifiedNumber);	
			
	} // End of requestUpdateUserInfo()

	
	public void requestAllUserList(){
		
		ArrayList<User> users = userDAO.selectAllUser();
		UserView userView = new UserView(mainController);
		userView.allUserView(users);
		
	} // End of requestAllUserList()
	
	
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
			mainController.getMenuController().requestMainMenu();
		}
		
	} // End of requestWithDrawMember()

}
