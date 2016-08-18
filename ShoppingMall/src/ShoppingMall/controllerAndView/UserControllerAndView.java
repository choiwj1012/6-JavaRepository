package ShoppingMall.controllerAndView;

import java.util.Scanner;

import ShoppingMall.DAO.UserDAO;
import ShoppingMall.domain.User;

public class UserControllerAndView {

	// variable
	public Scanner keyboard = new Scanner(System.in);
	public UserDAO userDao;

	// constructor
	public UserControllerAndView(){

		this.userDao = new UserDAO();
		
	}
	
	// method
	public void insertAdminUser() { // 관리자 계정 생성
		
		// 관리자 아이디 : admin, 비밀번호 : 1111, 이름 : 관리자
		User adminUser = new User("admin","1111","관리자");
		
		// 생성한 유저(관리자) 객체 데이터베이스로 넘김
		userDao.insertAdminUser(adminUser);

	} // insertAdminUser() end

	
	
	public void insertUserInUserList() { // 유저등록
		
		while(true) {		
			
			System.out.println("등록할 사용자 정보를 입력하세요.");
			
			System.out.print("사용자 ID : ");
			String id = keyboard.next();
			
			System.out.print("사용자 PW : ");
			String pw = keyboard.next();
			
			System.out.print("사용자 이름 : ");
			String name = keyboard.next();

			User newUser = new User(id, pw, name);
			boolean success = userDao.insertUserInUserList(newUser);
			
			if(!success) {
				
				System.err.println("이미 아이디가 존재합니다.");
				
			} else {
				
				break;
				
			}
			
		}

	} // insertUserInUserList() end
	
	
	public void login() { // 로그인
		
		System.out.println("로그인 정보를 입력하세요.");
		
		System.out.print("사용자 ID : ");
		String id = keyboard.next();
		
		System.out.print("사용자 PW : ");
		String pw = keyboard.next();
		
		User user = new User(id, pw);
		user = userDao.login(user);

		if(user != null) {
			
			if(user.getId().equals("admin")) {
				
				MainControllerAndView.adminMenu();
				
			} else {
				
				System.out.println("환영합니다! " + user.getName() + "님");
				MainControllerAndView.mainMenu();
				
			}
			
		} else {
			
			System.err.println("아이디 또는 비밀번호가 맞지 않습니다.");
			
		}

	} // login() end
	
	
	public void updateUserInformation() { // 유저정보변경

		checkUserInfo(); // 유저정보변경을 위한 재확인
		boolean exit = false;

		while(!exit) {
			System.out.println("수정하고 싶은 메뉴를 입력하세요. (1) 이름 (2) 비밀번호 (3) 나가기");
			int selectedMenu = keyboard.nextInt();

			switch(selectedMenu) {

			case 1: 

				System.out.println("수정할 이름을 입력해주세요.");
				String updateUserName = keyboard.next();
				userDao.updateUserInformation(updateUserName, selectedMenu);
				break;

			case 2: 

				System.out.println("수정할 비밀번호를 입력해주세요.");
				String updateUserPw = keyboard.next();
				userDao.updateUserInformation(updateUserPw, selectedMenu);
				break;

			case 3: 

				System.out.println("메뉴로 돌아갑니다.");
				exit = true;
				MainControllerAndView.mainMenu();
				break;

			default:

				System.err.println("잘못입력하셨습니다. 다시 입력해주세요.");

			}

		}

	} // End of updateUserInformation()

	
	public void viewUserInformation() { // 유저정보확인하기
		
		User loginUser = userDao.viewUserInformation();

		System.out.println("이름\tId");
		System.out.print(loginUser.getName() + "\t" + loginUser.getId() + "\n");
		System.out.println();

	} // End of viewUserInformation()

	
	public void checkUserInfo() { // 정보변경을 위한 유저정보 재확인
	
		while(true) {
			
			System.out.println("정보변경을 위해 개인정보를 재확인합니다");
			System.out.print("사용자 ID : ");
			String id = keyboard.next();
			
			System.out.print("사용자 PW : ");
			String pw = keyboard.next();

			User user = new User(id, pw);
			user = userDao.login(user);

			if(user == null) {
				System.err.println("아이디 또는 비밀번호가 맞지 않습니다.");
				System.out.println("나가시려면 [q]를 누르십시오");
				System.out.println("다시 입력하시려면 아무키나 누르고 엔터치십시오");
				
				char exit = keyboard.next().charAt(0);

				if(exit == 'q'){
					MainControllerAndView.mainMenu();	
				} 
	
			}
			
			break;
		}

	} // End of checkUserInfo


	public void withdrawMember() { // 회원탈퇴

		boolean exit = false;
		while(!exit) {

			viewUserInformation();

			System.out.println("정말 탈퇴하시겠습니까? (y/n)");
			char selectedMenu = keyboard.next().charAt(0);

			switch(selectedMenu) {

			case 'y':
				userDao.withdrawMember();
				System.out.println("탈퇴되었습니다. 시작메뉴로 돌아갑니다");
				System.out.println();
				MainControllerAndView.showStartMenu();
				break;

			case 'n': 

				System.out.println("메뉴로 돌아갑니다.");
				MainControllerAndView.mainMenu();
				break;	

			default:

				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");

			}
			
		} // End of while
		
	} // End of withdrawMember()
	
	
	public void userReset(){
		
		userDao.resetLoginUserNumber(); // 로그아웃 하였으므로 로그인한 유저 번호 초기화
		
	} // End of userReset()	

} 