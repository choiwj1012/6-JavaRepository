package MainController;

import loginController.LoginController;
import productController.ProductController;
import userController.UserController;

public class Controller {

	
	private static ProgramController programController;
	private static ProductController productController;
	private static UserController userController;
	private static LoginController loginController;
	
	public Controller(){
		
		programController = new ProgramController();
		productController = new ProductController();
		userController = new UserController();
		loginController = new LoginController();
		
	}


	public static ProgramController getProgramController() {
		return programController;
	}


	public static ProductController getProductController() {
		return productController;
	}


	public static UserController getUserController() {
		return userController;
	}


	public static LoginController getLoginController() {
		return loginController;
	}
	
	
}
