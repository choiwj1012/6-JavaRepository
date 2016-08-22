package shoppingMall.controller;

import java.util.ArrayList;

import shoppingMall.dao.CartDAO;
import shoppingMall.view.CartView;
import shoppingMall.view.SelectView;
import shoppingMall.vo.Product;

public class CartController{

	// variable
	private MainController mainController;
	private CartDAO cartDAO;
	
	// constructor
	public CartController(MainController mainController){
		
		this.mainController = mainController;
		this.cartDAO = new CartDAO();
		
	}
	
	// method
	public void requestPurchase(){ // 구매하기 요청
		
		mainController.productController.requestDisplayProductList();
		SelectView selectedProduct = new SelectView();
		int selectedProductNum = selectedProduct.selectView();
		boolean success = cartDAO.purchase(selectedProductNum);
		CartView cartView = new CartView(mainController);
		cartView.purchaseView(success);
			
	} // End of requestPurchase()
	
	
	public void requestDisplayCartList(){ // 장바구니 전체목록 보이기 요청
		
		ArrayList<Product> carts = cartDAO.selectCartListAll();
		CartView cartView = new CartView(mainController);
		cartView.displayCartListView(carts);
		
	} // End of requestDisplayCartList()
	
	
	public void requestUpdateCartList(){ // 장바구니 수정 요청
		
		CartView cartView = new CartView(mainController);
		int selectedCartList = cartView.selectedCartList();
		Product selectedProductInCart = cartDAO.selectOneProductInCart(selectedCartList);
		int countProductInCart = cartView.updateCartListView(selectedProductInCart);
		cartDAO.updateCartList(selectedProductInCart, countProductInCart);
			
	} // End of requestUpdateCartList()
	
	public void requestLogOut(){
	
		cartDAO.logOut();
		
	} 
	
}
