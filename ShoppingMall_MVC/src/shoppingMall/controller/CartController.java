package shoppingMall.controller;

import shoppingMall.dao.CartDAO;
import shoppingMall.view.CartView;

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
		
		
		
	} // End of requestPurchase()
	
	
	public void requestDisplayCartList(){
		
		
		
	} // End of requestDisplayCartList()
	
	
	public void requestUpdateCartList(){
		
		
		
	} // End of requestUpdateCartList()
	
	
	public void requestActionPayment(){
		
		
	} // End of requestActionPayment()
	
}
