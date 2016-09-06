package shoppingMall.product.vo;

public class Product {
	
	public Product(){
		
	}

	//상품번호
	private int productNumber;
	
	//상품이름
	private String productName;
	
	//상품가격
	private int productPrice;
	
	//상품 브랜드
	private String productBrandName;
	
	//상품 색상
	private String productColor;

	//생성자
	public Product(String productName, int productPrice, String productBrandName, String productColor) {

		this.productName = productName;
		this.productPrice = productPrice;
		this.productBrandName = productBrandName;
		this.productColor = productColor;
		
	}
	
	
	public Product(int productNumber, String productName, int productPrice, String productBrandName, String productColor) {

		this.productNumber = productNumber;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productBrandName = productBrandName;
		this.productColor = productColor;
	
	}
	
	// getter and setter
	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductBrandName() {
		return productBrandName;
	}

	public void setProductBrandName(String productBrandName) {
		this.productBrandName = productBrandName;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
}
