package shoppingMall.mainView;

import java.util.Scanner;

import shoppingMall.mainController.MainController;

public class MainView {

	// variable
	Scanner keyboard;

	// constructor
	public MainView(){

		this.keyboard = new Scanner(System.in);

	}

	//메인메뉴 (회원가입,로그인)관리
	public void mainView(){

		System.out.println("[ 7조 쇼핑몰에 오신걸 환영합니다 ]");
		System.out.println("팀장 : 최 원재 " + "팀원 : 김 하늘, 엄 윤길");
		System.out.println("------------------------------");
		System.out.println("[메인메뉴]");

		boolean isFind = false;

		while(!isFind){

			String[] mainMenu = {"1. 회원가입", "2. 로그인", "0. 시스템종료"};

			for(int i = 0; i < mainMenu.length; i++) {
				System.out.println(mainMenu[i]);
			}

			System.out.println();
			System.out.print("메뉴선택 : ");
			int selectedNumber = keyboard.nextInt();
			System.out.println();
			System.out.println("------------------------------");

			if(selectedNumber == 1) {

				System.out.println("[반갑습니다.신규 회원 이시군요.고객님과의 인연을 소중하게 생각합니다.]");
				MainController.getUserController().requestUserSignUp();

			} else if (selectedNumber == 2) {

				System.out.println("[기존 고객님 이시군요.]");
				MainController.getLoginController().requestLogin();

			} else if (selectedNumber == 0) {

				System.out.println("[시스템을 종료 합니다.]" + "\n" + "[이용해 주셔서 감사합니다.]");
				MainController.systemExit();

			} else {

				System.out.println("[!]잘못된 입력 입니다.");
				System.out.println();

			}

		}

	} // end of requestMainMenuView()

}
