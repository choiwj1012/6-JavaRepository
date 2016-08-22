package shoppingMall.controller;

public class MainController {

	// variable
	public MenuController menuController;
	public UserController userController;
	public ProductController productController;
	public CartController cartController;
	
	// constructor
	public MainController() {
	
		menuController = new MenuController(this);
		userController = new UserController(this);
		productController = new ProductController(this);
		cartController = new CartController(this);	
		
	}
	
	
}