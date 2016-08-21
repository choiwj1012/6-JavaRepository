package shoppingMall.vo;

public class ProductInCart extends Product {

	// 장바구니(카트)에 개별 상품의 담겨진 숫자
	int countProductInCart;

	public int getCountProductInCart() {
		return countProductInCart;
	}

	public void setCountProductInCart(int countProductInCart) {
		this.countProductInCart = countProductInCart;
	}
	
}
