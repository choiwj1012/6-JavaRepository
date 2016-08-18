package ShoppingMall.DAO;

import java.util.ArrayList;

import ShoppingMall.controllerAndView.MainControllerAndView;
import ShoppingMall.domain.Product;
import ShoppingMall.repository.CartRepository;

public class CartDAO {

	// variable
	CartRepository cartRepository;

	// constructor
	public CartDAO() {

		this.cartRepository = new CartRepository();

	}

	// method
	public boolean purchase(int number) {

		boolean success = false;
		boolean isFind = false;
		Product selectedProduct = null;

		for(int i=0; i<cartRepository.carts.size(); i++){
			if(number == cartRepository.carts.get(i).getNumber()){
		
				cartRepository.carts.get(i).setCount(cartRepository.carts.get(i).getCount() + 1);
				isFind = true;
				break;
				
			}

		}
		
		if(isFind == true){
			success = true;
			return success;
		}
		
		for(int i=0; i<MainControllerAndView.productControllerAndView.productDAO.productRepository.products.size(); i++){
			if(number == MainControllerAndView.productControllerAndView.productDAO.productRepository.products.get(i).getNumber()){

				selectedProduct = MainControllerAndView.productControllerAndView.productDAO.productRepository.products.get(i);
				success = cartRepository.carts.add(selectedProduct);
				break;

			}

		}
		
		return success;

	} // End of purchase()


	public ArrayList<Product> displayCartList() {

		return cartRepository.carts;

	} // End of displayCartList()


	public boolean updateCartList(int selectedCartListNum) {

		boolean success = false;

		for(int i=0; i<cartRepository.carts.size(); i++) {
			if(selectedCartListNum == cartRepository.carts.get(i).getNumber()) {
				cartRepository.carts.remove(i);
				System.out.println("삭제되었습니다.");
				success = true;
				break;
			}
		}

		return success;

	} // End of updateCartList()


	public void resetCart() {

		cartRepository.carts = new ArrayList<Product>();

	} // End of resetCART()

}
