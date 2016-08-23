import shoppingMall.main.controller.MainController;

public class Main {
	
	public static void main(String[] args) {
		
		MainController mainController = new MainController();
		
		mainController.getMenuController().requestMainMenu(); // 메인 메뉴 호출
		
	}
	
}
