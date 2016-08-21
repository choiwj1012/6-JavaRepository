package shoppingMall.controller;

import java.util.ArrayList;

import shoppingMall.dao.CartDAO;
import shoppingMall.view.AlertView;
import shoppingMall.view.CartView;
import shoppingMall.view.SelectView;
import shoppingMall.vo.Product;

public class CartController implements MainController{

	// variable
	private CartDAO cartDAO;
	private CartView cartView;
	
	// constructor
	public CartController(){
		
		this.cartDAO = new CartDAO();
		this.cartView = new CartView();
		
	}
	
	// method
	public void requestPurchase(){
		
		MainController.productController.requestDisplayProductList();
		SelectView selectedProduct = new SelectView();
		int selectedProductNum = selectedProduct.selectView();
		boolean success = cartDAO.purchase(selectedProductNum);
		cartView.purchaseView(success);
			
	} // End of requestPurchase()
	
	
	public void requestDisplayCartList(){
		
		ArrayList<Product> carts = cartDAO.selectCartListAll();
		cartView.displayCartListView(carts);
		
	} // End of requestDisplayCartList()
	
	
	public void requestUpdateCartList(){
		
		int selectedCartList = cartView.selectedCartList();
		Product selectedProductInCart = cartDAO.selectOneProductInCart(selectedCartList);
		int countProductInCart = cartView.updateCartListView(selectedProductInCart);
		cartDAO.updateCartList(selectedProductInCart, countProductInCart);
			
	} // End of requestUpdateCartList()
	
}
