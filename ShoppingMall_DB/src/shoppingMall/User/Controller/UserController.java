package shoppingMall.User.Controller;

import java.util.ArrayList;

import shoppingMall.User.Dao.UserDao;
import shoppingMall.User.View.AdminView;
import shoppingMall.User.View.DeleteUserView;
import shoppingMall.User.View.UserListView;
import shoppingMall.User.View.UserManagementMenuView;
import shoppingMall.User.View.UserMenuView;
import shoppingMall.User.View.UserSearchView;
import shoppingMall.User.View.UserSignView;
import shoppingMall.User.View.UserUpdateView;
import shoppingMall.User.Vo.User;
import shoppingMall.mainController.MainController;


public class UserController {

	// variable
	private UserDao userDao;

	// constructor
	public UserController(){

		userDao = new UserDao();

	}


	// method
	// 유저메뉴
	public void requestUserMenu(){

		UserManagementMenuView userMenu = new UserManagementMenuView();
		userMenu.userManagementMenuView();

	}


	// 회원가입
	public void requestUserSignUp(){

		UserSignView userView = new UserSignView();
		userView.userSignUpView();

	}


	// 회원가입 데이터
	public void requestUserData(User userSign){

		boolean success = userDao.userSignUp(userSign);

		if(success){

			MainController.requestMainAlertView("가입에 성공하였습니다.");
			MainController.requestMainView();

		}else{
			
			MainController.requestMainAlertView("동일한 아이디가 존재합니다. 재가입 해주세요");
			
		}

	}


	// 체크중복아이디
	public boolean requestCheckUserId(User newUser) {

		boolean success = false;

		success = userDao.checkUserId(newUser);

		return success;      

	}


	// 유저목록
	public void requestUserList(){

		ArrayList<User> userList = userDao.userList();

		UserListView userListView = new UserListView();
		userListView.userListView(userList); 

	}


	// 유저조회
	public void requestUserSearch(){

		UserSearchView userSearch = new UserSearchView();
		userSearch.getSearchNumber();

	}


	// 유저조회 데이터
	public void requestUserSearchData(int getSearchNumber){

		User selectedUser = userDao.searchUser(getSearchNumber);

		if(selectedUser == null){
			
			MainController.requestMainAlertView("실패");
			return;
		}

		UserSearchView userSearchView = new UserSearchView();
		userSearchView.outputSearchProduct(selectedUser);

	}


	// 유저삭제
	public void requestDeleteUser(){

		DeleteUserView deleteUserView = new DeleteUserView();
		deleteUserView.deleteUserView();

	}


	// 유저삭제 데이터
	public void requestDeleteUserData(int deleteUserNumber){

		User deleteUser = userDao.deleteUser(deleteUserNumber);
		
		if(deleteUser == null){
			
			MainController.requestMainAlertView("삭제되었습니다");
			
		}

	}


	// 유저수정
	public void requestUpdateUser(){

		UserUpdateView userUpdateView = new UserUpdateView();
		userUpdateView.updateUserView();

	}


	// 유저수정데이터
	public void requestUpdateUserData(User updateContent){

		boolean success = userDao.updateUser(updateContent);

		if(success){

			MainController.requestMainAlertView("성공");
			MainController.getUserController().requestUserMenuView();

		}

	}


	// 회원탈퇴
	/*public void requestWithdrawUser(){

		userDao.withdrawUser();
		MainController.requestMainAlertView("탈퇴 되었습니다.");

	}*/


	// 관리자 메인메뉴 호출
	public void requestAdminView(){

		AdminView adminView = new AdminView();
		adminView.adminView();

	}


	// 유저 메인메뉴 호출
	public void requestUserMenuView(){

		UserMenuView userMenuView = new UserMenuView();
		userMenuView.userMenuView();

	}

}




