package shoppingMall.main;

import shoppingMall.controller.MainController;

public class Main {
	
	public static void main(String[] args) {
		
		MainController mainController = new MainController();
		
		mainController.menuController.requestMainMenu(); // 메인 메뉴 호출
		
	}
	
}
