package MainController;

import productController.ProductController;

public class Controller {

	
	private static ProgramController programController;
	private static ProductController productController;
	
	
	public Controller(){
		
		this.programController = new ProgramController();
		this.productController = new ProductController();
		
	}


	public static ProgramController getProgramController() {
		return programController;
	}


	public static ProductController getProductController() {
		return productController;
	}
	
	
}
