package view;

import java.util.Scanner;

import controller.ArticleController;

public class ShowMainMenu {
	
	// variable
	private Scanner keyboard;
	private ArticleController controller;
	
	// constructor
	public ShowMainMenu(ArticleController controller){
		
		this.keyboard = new Scanner(System.in);
		this.controller = controller;
		
	}
	
	// method
	public void showMainMenu(){
		
		System.out.println("||| 게시판에 오신것을 환영합니다 |||\n");
		controller.requestListArticle();
	
		while(true){
		
			String[] mainMenu = {"원하시는 번호를 선택하십시오", "1. 글쓰기", "2. 글전체보기", "3. 글조회하기", "4. 글수정하기", "5. 글삭제하기", "0. 종료하기"};
			for(int i=0; i<mainMenu.length; i++){
				System.out.println(mainMenu[i]);
			}
			
			int selectedMenu = keyboard.nextInt();
			
			if(selectedMenu == 1){
				
				controller.requestWriteArticle();
				
			} else if(selectedMenu == 2){
				
				controller.requestListArticle();
				
			} else if(selectedMenu == 3){
				
				controller.requestReadArticle();
				
			} else if(selectedMenu == 4){
				
				controller.requestUpdateArticle();
				
			} else if(selectedMenu == 5){
				
				controller.requestDeleteArticle();
				
			} else if(selectedMenu == 0){
				
				System.out.println("게시판을 종료합니다");
				System.exit(0);
				
			} else {
				
				System.out.println("잘못누르셨습니다.");
				
			}
			
		}
	}
	
}
