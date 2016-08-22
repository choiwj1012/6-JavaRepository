package shoppingMall.controller;

import java.util.ArrayList;

import shoppingMall.dao.ProductDAO;
import shoppingMall.view.AlertView;
import shoppingMall.view.ProductView;
import shoppingMall.view.SelectView;
import shoppingMall.vo.Product;

public class ProductController {
	
	// variable
	private MainController mainController;
	private ProductDAO productDAO;
	
	// constructor
	public ProductController(MainController mainController){

		this.mainController = mainController;
		this.productDAO = new ProductDAO();
	}

	// method
	public void requestAddProduct(){
		
		ProductView productView = new ProductView();
		Product newProduct = productView.addProductView();
		productDAO.addProduct(newProduct);

	} // End of requestAddProduct()


	public void requestDisplayProductList(){

		ProductView productView = new ProductView();
		ArrayList<Product> products = productDAO.selectAllProduct();
		productView.disPlayProductList(products);

	} // End of requestDisplayProductList()


	public void requestUpdateProduct(){
		
		ProductView productView = new ProductView();
		SelectView selectedProduct = new SelectView();
		int selectedProductNum = selectedProduct.selectView();
		Product updateProduct = productView.updateProductView(selectedProductNum);
		productDAO.updateProduct(updateProduct);
		
	} // End of requestUpdateProductInfo()


	public void requestDeleteProduct(){
		
		ProductView productView = new ProductView();
		SelectView selectedProduct = new SelectView();
		int selectedProductNum = selectedProduct.selectView();
		Product deleteProduct = productView.deleteProductView(selectedProductNum);
		boolean success = productDAO.deleteProduct(deleteProduct);
		
		AlertView alert = new AlertView();
		if(success){
		
			alert.alert("삭제 성공");
			
		} else {
			
			alert.alert("삭제 실패");
			
		}
		
	} // End of requestDeleteProduct()

}
