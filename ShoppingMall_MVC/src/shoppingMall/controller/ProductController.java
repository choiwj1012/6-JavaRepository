package shoppingMall.controller;

import java.util.ArrayList;

import shoppingMall.dao.ProductDAO;
import shoppingMall.view.AlertView;
import shoppingMall.view.ProductView;
import shoppingMall.view.SelectView;
import shoppingMall.vo.Product;

public class ProductController implements MainController {
	
	// variable
	private ProductDAO productDAO;
	private ProductView productView;
	
	// constructor
	public ProductController(){

		this.productDAO = new ProductDAO();
		this.productView = new ProductView();
	}

	// method
	public void requestAddProduct(){
		
		Product newProduct = productView.addProductView();
		productDAO.addProduct(newProduct);

	} // End of requestAddProduct()


	public void requestDisplayProductList(){

		ArrayList<Product> products = productDAO.selectAllProduct();
		productView.disPlayProductList(products);

	} // End of requestDisplayProductList()


	public void requestUpdateProduct(){
		
		SelectView selectedProduct = new SelectView();
		int selectedProductNum = selectedProduct.selectView();
		Product updateProduct = productView.updateProductView(selectedProductNum);
		productDAO.updateProduct(updateProduct);
		
	} // End of requestUpdateProductInfo()


	public void requestDeleteProduct(){
		
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
