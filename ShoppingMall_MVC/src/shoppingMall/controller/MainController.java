package shoppingMall.controller;

public class MainController {

	// variable
	private MenuController menuController;
	private UserController userController;
	private ProductController productController;
	private CartController cartController;
	private LogInOutController logInOutController;
	
	// constructor
	public MainController() {
	
		menuController = new MenuController(this);
		userController = new UserController(this);
		productController = new ProductController(this);
		cartController = new CartController(this);	
		logInOutController = new LogInOutController(this); 
		
	}
	
	// getter and setter
	public MenuController getMenuController() {
		return menuController;
	}

	public UserController getUserController() {
		return userController;
	}

	public ProductController getProductController() {
		return productController;
	}

	public CartController getCartController() {
		return cartController;
	}

	public LogInOutController getLogInOutController() {
		return logInOutController;
	}

}
