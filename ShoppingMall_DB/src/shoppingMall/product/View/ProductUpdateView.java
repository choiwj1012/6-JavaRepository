package shoppingMall.product.View;

import java.util.Scanner;

import shoppingMall.mainController.MainController;
import shoppingMall.product.vo.Product;

public class ProductUpdateView {

	// variable
	private Scanner keyboard;

	// constructor
	public ProductUpdateView() {

		this.keyboard = new Scanner(System.in);

	}

	// method
	// 상품 업데이트
	public void productUpdate() {

		String productName = null;
		int productPrice = 0;
		String productBrandName = null;
		String productColor = null;
		
		System.out.println("[상품 업데이트 모드]");
		System.out.println("[!]수정할 제품 번호를 선택 하세요.");
		System.out.println("번호선택 : ");
		int selectedProductNumber = keyboard.nextInt();

		while(true){
			
			System.out.println("원하시는 수정내용을 선택하십시오");
			System.out.println("1. 상품이름  2. 상품가격  3. 상품브랜드  4. 상품색상  5. 나가기");
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1){

				System.out.println("수정할 상품이름 : ");
				productName = keyboard.next();
				
			} else if (selectedMenu == 2) {

				System.out.println("수정할 상품가격 : ");
				productPrice = keyboard.nextInt();
				
			} else if (selectedMenu == 3) {

				System.out.println("수정할 상품브랜드 : ");
				productBrandName = keyboard.next();
				 
			} else if (selectedMenu == 4) {

				System.out.println("수정할 상품색상 : ");
				productColor = keyboard.next();
				
			} else if (selectedMenu == 5) {

				break;

			} else {

				System.out.println("선택을 잘못하셨습니다.");

			}

		}

		Product updateProduct = new Product(productName, productPrice, productBrandName, productColor);
		
		MainController.getProductController().requestUpdateProduct(selectedProductNumber, updateProduct);
		
	}

}
