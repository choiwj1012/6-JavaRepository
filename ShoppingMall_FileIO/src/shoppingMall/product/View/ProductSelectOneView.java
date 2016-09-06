package shoppingMall.product.View;

import shoppingMall.product.vo.Product;

public class ProductSelectOneView {

	// method
	// 선택된 상품에 대한 정보 출력
	public void selectOneProduct(Product searchProduct) {

		System.out.println("---------------------------------------");
		System.out.println("상품번호\t상품이름\t상품가격\t상품브랜드\t상품색상");

		System.out.print(searchProduct.getProductNumber() + "\t");
		System.out.print(searchProduct.getProductName() + "\t");
		System.out.print(searchProduct.getProductPrice() + "\t");
		System.out.print(searchProduct.getProductBrandName() + "\t");
		System.out.print(searchProduct.getProductColor());
		
		System.out.println();
		System.out.println("---------------------------------------");
		
	}

}
