package shoppingMall.product.controller;

import java.util.ArrayList;

import shoppingMall.main.controller.MainController;
import shoppingMall.product.dao.ProductDAO;
import shoppingMall.product.view.ProductView;
import shoppingMall.product.vo.Product;
import shoppingMall.util.view.AlertView;
import shoppingMall.util.view.SelectView;

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
	public void requestAddProduct(){ // 상품등록 요청
		
		ProductView productView = new ProductView();
		Product newProduct = productView.addProductView();
		productDAO.addProduct(newProduct);

	} // End of requestAddProduct()


	public void requestDisplayProductList(){ // 등록된 상품전체보이기 요청

		ProductView productView = new ProductView();
		ArrayList<Product> products = productDAO.selectAllProduct();
		productView.disPlayProductList(products);

	} // End of requestDisplayProductList()


	public void requestUpdateProduct(){ // 상품수정하기 요청
		
		ProductView productView = new ProductView();
		SelectView selectedProduct = new SelectView();
		int selectedProductNum = selectedProduct.selectView();
		Product updateProduct = productView.updateProductView(selectedProductNum);
		productDAO.updateProduct(updateProduct);
		
	} // End of requestUpdateProductInfo()


	public void requestDeleteProduct(){ // 상품 삭제하기 요청
		
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
