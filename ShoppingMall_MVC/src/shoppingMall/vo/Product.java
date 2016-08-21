package shoppingMall.vo;

public class Product {

	// variable
	private int number;		// 상품번호		
	private String name;	// 상품이름		 
	private int price;		// 상품가격		 
	private String information;     // 상품정보
	private int countProductInCart;	// 장바구니(카트)에 개별 상품의 담겨진 숫자
		
	
	// constructor
	public Product() {
	
	}
	
	public Product(String name, int price, String information) {	
		
		this.number = 1;
		this.name = name;
		this.price = price;
		this.information = information;
	
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}
	
	public int getCountProductInCart() {
		return countProductInCart;
	}

	public void setCountProductInCart(int countProductInCart) {
		this.countProductInCart = countProductInCart;
	}
	
}
