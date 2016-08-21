package shoppingMall.dao;

import java.util.ArrayList;

import shoppingMall.repository.CartRepository;
import shoppingMall.repository.ProductRepository;
import shoppingMall.vo.Product;

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
	public boolean purchase(int selectedProductNum){

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
				success = cartRepository.getCarts().add(selectedProduct);
				break;

			}

		}

		return success;

	} // End of purchase()


	public ArrayList<Product> selectCartListAll(){

		ArrayList<Product> carts = cartRepository.getCarts();

		return carts;

	} // End of displayCartList()

	public Product selectOneProductInCart(int selectedCartList){

		Product selectedProductInCart = null;

		for(int i=0; i<cartRepository.getCarts().size(); i++){
			if(selectedCartList == cartRepository.getCarts().get(i).getNumber()){

				selectedProductInCart = cartRepository.getCarts().get(i);
				break;

			}	
		}

		return selectedProductInCart;

	}

	public void updateCartList(Product selectedProductInCart, int countProductInCart){

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

	public void resetCart(){



	} // End of resetCart()

}
