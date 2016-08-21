package shoppingMall.view;

import java.util.Scanner;

import shoppingMall.controller.MainController;
import shoppingMall.vo.User;

public class UserView {

	private Scanner keyboard;

	public UserView(){

		this.keyboard = new Scanner(System.in);

	}


	public User addUserView(){

		while(true) {		

			System.out.println("등록할 사용자 정보를 입력하세요.");

			System.out.print("사용자 ID : ");
			String userID = keyboard.next();

			System.out.print("사용자 PW : ");
			String userPW = keyboard.next();

			System.out.print("사용자 이름 : ");
			String userName = keyboard.next();

			User newUser = new User(userID, userPW, userName);

			return newUser;

		}

	} // End of addUserView()


	public User updateUserInfoView(int userIdentifiedNumber){

		User updateUser = new User();	

		if(userIdentifiedNumber == -1){

			System.out.println("잘못입력하셨습니다. 재로그인 바랍니다");
			MainController.userController.requestUpdateUserInfo();

		} else {

			while(true){


				System.out.println("수정을 원하는 목록을 선택하십시오");
				System.out.println("1. 비밀번호 || 2. 이름 || 3. 취소");
				int selectedNum = keyboard.nextInt();

				if(selectedNum == 1){

					System.out.println("1. 새 비밀번호를 입력하십시오 ");
					String updateUserPW = keyboard.next();
					updateUser.setUserPW(updateUserPW);

				} else if(selectedNum == 2){

					System.out.println("2. 새 이름을 입력하십시오");
					String updateUserName = keyboard.next();	
					updateUser.setUserName(updateUserName);

				} else if(selectedNum == 3){

					return updateUser;

				} else {

					System.out.println("잘못 눌렀군요");

				}

			} // End of while
		}

		return updateUser;

	} // End of updateUserInfoView()


	public User checkLogInUserView(){

		User checkedUser = null;

		System.out.println("본인 정보 수정을 위해서 재 로그인 하셔야 합니다");

		checkedUser = this.logInView();

		return checkedUser;

	}


	public void readUserInfoView(User loginUser){

		System.out.println("당신의 회원정보는 다음과 같습니다");
		System.out.println("아이디 : " + loginUser.getUserID());
		System.out.println("이름 : " + loginUser.getUserName());
		
	} // End of readUserInfoView()


	public boolean withdrawMemberView(User loginUser){

		boolean agreeWithdraw = false;
		
		System.out.println("당신의 회원정보는 다음과 같습니다");
		System.out.println("아이디 : " + loginUser.getUserID());
		System.out.println("이름 : " + loginUser.getUserName());
		System.out.println("정말로 탈퇴하시겠습니까? [y] 혹은 [n] 을 누르십시오");
		char yesOrNo = keyboard.next().charAt(0); 
		
		if(yesOrNo == 'y'){
			agreeWithdraw = true;
			return agreeWithdraw;
		}

		return agreeWithdraw;
		
	} // End of withDrawMemberView()


	public User logInView(){

		System.out.println("로그인 정보를 입력하세요");

		System.out.println("사용자 ID : ");
		String userID = keyboard.next();

		System.out.println("사용자 PW : ");
		String userPW = keyboard.next();

		User logInUser = new User(userID, userPW);

		return logInUser;

	} // End of logInView()


	public boolean logOutView(){

		boolean agreeLogOut = false;
		
		System.out.println("정말로 로그아웃 하십니까? [y] 혹은 [n] 을 누르십시오");
		char yesOrNo = keyboard.next().charAt(0); 
		
		if(yesOrNo == 'y'){
			agreeLogOut = true;
			return agreeLogOut;
		}

		return agreeLogOut;

	} // End of logOutView()

}
