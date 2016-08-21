package shoppingMall.controller;

import shoppingMall.view.MenuView;

public class MenuController implements MainController{
	
	// variable


	// constructor
	public MenuController(){
		
	}
	
	//method
	public void requestMainMenu(){ // 메인메뉴
		
		MenuView menuView = new MenuView();
		menuView.mainMenuView();

	} // End of requestMainMenu()

	public void requestAdminMenu(){ // 관리자메뉴
		
		MenuView menuView = new MenuView();
		menuView.adminMenuView();

	} // End of requestAdminMenu()

	public void requestUserMenu(){ // 유저메뉴
		
		MenuView menuView = new MenuView();
		menuView.UserMenuView();

	} // End of requestUserMenu()
	
}
