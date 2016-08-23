package shoppingMall.product.controller;

import java.util.ArrayList;

import shoppingMall.main.controller.MainController;
import shoppingMall.product.dao.ProductDAO;
import shoppingMall.product.view.AddProductView;
import shoppingMall.product.view.DeleteProductView;
import shoppingMall.product.view.DisplayProductList;
import shoppingMall.product.view.SelectOneProductView;
import shoppingMall.product.view.UpdateProductView;
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
		
		AddProductView selectAllProductView = new AddProductView();
		Product newProduct = selectAllProductView.addProductView();
		productDAO.addProduct(newProduct);

	} // End of requestAddProduct()


	public void requestDisplayProductList(){ // 등록된 상품전체보이기 요청

		DisplayProductList displayProductList = new DisplayProductList();
		ArrayList<Product> allProducts = productDAO.selectAllProduct();
		displayProductList.disPlayProductList(allProducts);

	} // End of requestDisplayProductList()
	
	
	public void requestSelectOneProduct(){
		
		SelectOneProductView selectOneProductView = new SelectOneProductView();
		
		
	} // End of requestSelectOneProduct()


	public void requestUpdateProduct(){ // 상품수정하기 요청
		
		UpdateProductView updateProductView = new UpdateProductView();
		SelectView selectedProduct = new SelectView();
		int selectedProductNum = selectedProduct.selectView();
		Product updateProduct = updateProductView.updateProductView(selectedProductNum);
		productDAO.updateProduct(updateProduct);
		
	} // End of requestUpdateProductInfo()


	public void requestDeleteProduct(){ // 상품 삭제하기 요청
		
		DeleteProductView deleteProductView = new DeleteProductView();
		SelectView selectedProduct = new SelectView();
		int selectedProductNum = selectedProduct.selectView();
		Product deleteProduct = deleteProductView.deleteProductView(selectedProductNum);
		boolean success = productDAO.deleteProduct(deleteProduct);
		
		AlertView alert = new AlertView();
		if(success){
		
			alert.alert("삭제 성공");
			
		} else {
			
			alert.alert("삭제 실패");
			
		}
		
	} // End of requestDeleteProduct()

}
