package shoppingMall.order.vo;

public class Order {

	// variable
	// 주문 번호
	private int orderNumber;
	
	// 주문한 상품번호
	private int productNumber;
	
	// 주문한 상품수량
	private int productCount;
	
	// constructor
	public Order(){
		
		this.productCount = 1;
		
	}
	
	public Order(int orderNumber, int productNumber, int productCount){
		
		this.orderNumber = orderNumber;
		this.productNumber = productNumber;
		this.productCount = productCount;
		
	}

	// getter and setter
	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
		
}
