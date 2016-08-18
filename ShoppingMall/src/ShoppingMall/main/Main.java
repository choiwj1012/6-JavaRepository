package ShoppingMall.main;

import ShoppingMall.controllerAndView.MainControllerAndView;

public class Main {

	public static void main(String[] args) {
		
		new MainControllerAndView().createAdminAndProduct();
		MainControllerAndView.showStartMenu();
		
	}

}
