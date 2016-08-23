package shoppingMall.product.view;

import java.util.Scanner;

import shoppingMall.product.vo.Product;

public class UpdateProductView {

	// variable
	Scanner keyboard;
	
	// constructor
	public UpdateProductView() {
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	// method
	public Product updateProductView(int selectedNum){
		
		Product updateProduct = new Product();
		
		while(true){
			
			System.out.println("수정하고싶은 메뉴를 선택하십시오");
			System.out.println("1. 상품명 || 2. 상품가격 || 3. 상품정보 || 4. 종료");
			int selectedMenu = keyboard.nextInt();
			updateProduct.setNumber(selectedNum);
			
			if(selectedMenu == 1){
				
				System.out.println("상품명 > ");
				String name = keyboard.next();
				updateProduct.setName(name);	
				
			} else if(selectedMenu == 2){
				
				System.out.println("상품가격 > ");
				int price = keyboard.nextInt();
				updateProduct.setPrice(price);
				
			} else if(selectedMenu == 3){
				
				System.out.println("상품정보 >");
				String information = keyboard.next();
				updateProduct.setInformation(information);
				
			} else if(selectedMenu == 4){
				
				break;
				
			} else {
				
				System.out.println("잘못 눌렀습니다. 다시 입력하세요");
				
			}
			
		}
		
		return updateProduct;
		
	} // End of updateProductView()

}
