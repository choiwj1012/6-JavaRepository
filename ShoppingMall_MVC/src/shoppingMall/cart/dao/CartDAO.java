package shoppingMall.cart.dao;

import java.util.ArrayList;

import shoppingMall.cart.repository.CartRepository;
import shoppingMall.product.repository.ProductRepository;
import shoppingMall.product.vo.Product;

public class CartDAO {

	// variable
	ProductRepository productRepository;
	CartRepository cartRepository;

	// constructor
	public CartDAO(){

		this.cartRepository = new CartRepository();
		this.productRepository = new ProductRepository();

	}

	// method
	public boolean purchase(int selectedProductNum){ // 유저 제품 구매 후 장바구니에 담는 메서드

		boolean success = false;
		boolean isFind = false;
		Product selectedProduct = null;

		for(int i=0; i<cartRepository.getCarts().size(); i++){
			if(selectedProductNum == cartRepository.getCarts().get(i).getNumber()){

				cartRepository.getCarts().get(i).setCountProductInCart(cartRepository.getCarts().get(i).getCountProductInCart() + 1);
				isFind = true;
				break;

			}

		}

		if(isFind == true){
			success = true;
			return success;
		}

		for(int i=0; i<productRepository.getProduct().size(); i++){
			if(selectedProductNum == productRepository.getProduct().get(i).getNumber()){
				
				selectedProduct = productRepository.getProduct().get(i);
				selectedProduct.setCountProductInCart(selectedProduct.getCountProductInCart() + 1);
				success = cartRepository.getCarts().add(selectedProduct);
				break;

			}

		}

		return success;

	} // End of purchase()


	public ArrayList<Product> selectCartListAll(){ // 장바구니 안 목록 전체 선택

		ArrayList<Product> carts = cartRepository.getCarts();

		return carts;

	} // End of displayCartList()

	
	public Product selectOneProductInCart(int selectedCartList){ // 장바구니 목족 중 유저가 선택한 상품 선택

		Product selectedProductInCart = null;

		for(int i=0; i<cartRepository.getCarts().size(); i++){
			if(selectedCartList == cartRepository.getCarts().get(i).getNumber()){

				selectedProductInCart = cartRepository.getCarts().get(i);
				break;

			}	
		}

		return selectedProductInCart;

	} // End of selectOneProductInCart

	
	public void updateCartList(Product selectedProductInCart, int countProductInCart){ // 카트 리스트 수정

		if(countProductInCart == 0){
			
			for(int i=0; i<cartRepository.getCarts().size(); i++){
				if(selectedProductInCart.getNumber() == cartRepository.getCarts().get(i).getNumber()){
					cartRepository.getCarts().get(i).setCountProductInCart(0);
					cartRepository.getCarts().remove(i);
				}
			}
			
		} else {
			
			for(int i=0; i<cartRepository.getCarts().size(); i++){
				if(selectedProductInCart.getNumber() == cartRepository.getCarts().get(i).getNumber()){
					cartRepository.getCarts().get(i).setCountProductInCart(countProductInCart);
				}
			}
				
		}

	} // End of updateCartList()
	
	public void logOut(){
		
		for(int i=0; i<cartRepository.getCarts().size(); i++){
			cartRepository.getCarts().remove(0);	
		}
		
	} // End of logOut()

}
