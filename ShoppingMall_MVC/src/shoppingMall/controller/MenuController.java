package shoppingMall.controller;

import shoppingMall.view.MenuView;

public class MenuController{
	
	// variable
	MainController mainController;

	// constructor
	public MenuController(MainController mainController){
		
		this.mainController = mainController;
		
	}
	
	//method
	public void requestMainMenu(){ // 메인메뉴
		
		MenuView menuView = new MenuView(mainController);
		menuView.mainMenuView();

	} // End of requestMainMenu()

	public void requestAdminMenu(){ // 관리자메뉴
		
		MenuView menuView = new MenuView(mainController);
		menuView.adminMenuView();

	} // End of requestAdminMenu()

	public void requestUserMenu(){ // 유저메뉴
		
		MenuView menuView = new MenuView(mainController);
		menuView.UserMenuView();

	} // End of requestUserMenu()
	
}
