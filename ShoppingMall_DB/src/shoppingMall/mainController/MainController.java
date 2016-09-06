package shoppingMall.mainController;

import shoppingMall.Login.Controller.LoginController;
import shoppingMall.User.Controller.UserController;
import shoppingMall.mainView.MainAlertView;
import shoppingMall.mainView.MainView;
import shoppingMall.order.controller.OrderController;
import shoppingMall.product.controller.ProductController;

public class MainController {

	// variable
	 private static UserController userController;
	 private static ProductController productController;
	 private static OrderController orderController;
	 private static LoginController loginController;	
	
	// constructor
	public MainController(){

		userController = new UserController();
		productController = new ProductController();
		orderController = new OrderController();
		loginController = new LoginController();

	}

	// getter and setter
	public static UserController getUserController() {
		return userController;
	}

	public static ProductController getProductController() {
		return productController;
	}

	public static LoginController getLoginController() {
		return loginController;
	}

	public static OrderController getOrderController(){
		return orderController;
	}
	
	//method
	// 최초 메인메뉴 호출
	public static void requestMainView(){
		
		MainView mainView = new MainView();
		mainView.mainView();
		
	}
	
	
	// 메세지 메뉴 호출
	public static void requestMainAlertView(String message){
		
		MainAlertView mainAlertView = new MainAlertView();
		mainAlertView.alert(message);
		
	}
	
	
	// 시스템 종료 
	public static void systemExit(){
		
		System.exit(0);
		
	}
	
}