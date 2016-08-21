package shoppingMall.controller;

import java.util.ArrayList;

import shoppingMall.dao.ProductDAO;
import shoppingMall.view.AlertView;
import shoppingMall.view.ProductView;
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
		
		int selectedNum = productView.selectView();
		Product updateProduct = productView.updateProductView(selectedNum);
		productDAO.updateProduct(updateProduct);
		
	} // End of requestUpdateProductInfo()


	public void requestDeleteProduct(){

		int selectedNum = productView.selectView();
		Product deleteProduct = productView.deleteProductView(selectedNum);
		boolean success = productDAO.deleteProduct(deleteProduct);
		
		AlertView alert = new AlertView();
		if(success){
		
			alert.alert("삭제 성공");
			
		} else {
			
			alert.alert("삭제 실패");
			
		}
		
	} // End of requestDeleteProduct()

}
