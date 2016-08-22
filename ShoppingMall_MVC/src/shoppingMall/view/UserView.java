package shoppingMall.view;

import java.util.ArrayList;
import java.util.Scanner;

import shoppingMall.controller.MainController;
import shoppingMall.vo.User;

public class UserView {

	private Scanner keyboard;
	private MainController mainController;
	
	public UserView(MainController mainController){

		this.keyboard = new Scanner(System.in);
		this.mainController = mainController;
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

			System.out.print("전화번호 : ");
			String userTel = keyboard.next();
			
			User newUser = new User(userID, userPW, userName, userTel);

			return newUser;

		}

	} // End of addUserView()


	public void allUserView(ArrayList<User> users){
		
		System.out.println("사용자 번호\t사용자 ID\t사용자 PW\t사용자 이름\t사용자 전화번호\t가입날짜");
		for(int i=0; i<users.size(); i++){
			
			System.out.print(users.get(i).getNumber() + "\t");
			System.out.print(users.get(i).getUserID() + "\t");
			System.out.print(users.get(i).getUserPW() + "\t");
			System.out.print(users.get(i).getUserName() + "\t");
			System.out.print(users.get(i).getUserTel() + "\t");
			System.out.println(users.get(i).getJoinDate());
			
		}
		
	} // End of allUserView()
	
	
	public User updateUserInfoView(int userIdentifiedNumber){

		User updateUser = new User();	

		if(userIdentifiedNumber == -1){

			System.out.println("잘못입력하셨습니다. 재로그인 바랍니다");
			mainController.getUserController().requestUpdateUserInfo();

		} else {

			while(true){


				System.out.println("수정을 원하는 목록을 선택하십시오");
				System.out.println("1. 비밀번호 || 2. 이름 || 3. 전화번호 || 4. 취소");
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

					System.out.println("3. 새 전화번호를 입력하십시오");
					String updateUserTel = keyboard.next();
					updateUser.setUserTel(updateUserTel);

				} else if(selectedNum == 4){

					return updateUser;

				} else {
					
					System.out.println("잘못 눌렀군요");
					
				}

			} // End of while
		}

		return updateUser;

	} // End of updateUserInfoView()

	public void readUserInfoView(User loginUser){

		System.out.println("당신의 회원정보는 다음과 같습니다");
		System.out.println("회원번호 : " + loginUser.getNumber());
		System.out.println("아이디 : " + loginUser.getUserID());
		System.out.println("이름 : " + loginUser.getUserName());
		System.out.println("전화번호 : " + loginUser.getUserTel());
		System.out.println("가입일 : " + loginUser.getJoinDate());
		
	} // End of readUserInfoView()


	public boolean withdrawMemberView(User loginUser){

		boolean agreeWithdraw = false;
		
		System.out.println("당신의 회원정보는 다음과 같습니다");
		System.out.println("회원번호 : " + loginUser.getNumber());
		System.out.println("아이디 : " + loginUser.getUserID());
		System.out.println("이름 : " + loginUser.getUserName());
		System.out.println("전화번호 : " + loginUser.getUserTel());
		System.out.println("가입일 : " + loginUser.getJoinDate());
		System.out.println("정말로 탈퇴하시겠습니까? [y] 혹은 [n] 을 누르십시오");
		char yesOrNo = keyboard.next().charAt(0); 
		
		if(yesOrNo == 'y'){
			agreeWithdraw = true;
			return agreeWithdraw;
		}

		return agreeWithdraw;
		
	} // End of withDrawMemberView()

}
