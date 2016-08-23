package shoppingMall.product.view;

import java.util.Scanner;

public class SelectOneProductView {

	private Scanner keyboard;
	
	public SelectOneProductView(){
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	public int getSelectedProductNumber(){
		
		int selectedProductNumber = 0;
		
		System.out.println("제품 상세정보 조회");
		System.out.println("상세정보를 볼 제품번호를 입력하십시오");
		
		
		return selectedProductNumber;
		
	}
	
}
