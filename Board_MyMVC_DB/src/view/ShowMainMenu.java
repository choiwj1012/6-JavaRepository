package view;

import java.util.Scanner;

import controller.ArticleController;

public class ShowMainMenu {

	// variable
	private Scanner keyboard;
	private ArticleController articleController;

	// constructor
	public ShowMainMenu(ArticleController articleController){

		this.keyboard = new Scanner(System.in);
		this.articleController = articleController;

	}

	// method
	// 메인메뉴 출력
	public void showMainMenu(){

		System.out.println();
		System.out.println("게시판에 오신것을 환영합니다");

		while(true){
			System.out.println("원하시는 목록을 선택해 주십시오");
			System.out.println("1.글쓰기 2.글전체조회 3.글선택조회 4.글수정하기 5.글삭제하기 6.프로그램종료하기");

			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1){

				articleController.requestWriteView();

			} else if(selectedMenu == 2){

				articleController.requestSelectAll();

			} else if(selectedMenu == 3){

				articleController.selectedNumForRead();

			} else if(selectedMenu == 4){

				articleController.selectedNumForUpdate();

			} else if(selectedMenu == 5){

				articleController.selectedNumForDelete();

			} else if(selectedMenu == 6){

				System.out.println("시스템을 종료합니다");
				System.exit(0);

			} else {

				System.out.println("잘못 입력하셨습니다");

			}
			
		}
		
	} // End of showMainMenu()

}
