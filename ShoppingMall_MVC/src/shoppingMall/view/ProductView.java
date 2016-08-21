package shoppingMall.view;

import java.util.ArrayList;
import java.util.Scanner;

import shoppingMall.vo.Product;

public class ProductView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public ProductView(){
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	
	// method
	public void disPlayProductList(ArrayList<Product> products){
		
		System.out.println("상품번호\t상품명\t상품가격\t상품정보");
		for(int i=0; i<products.size(); i++){
			
			System.out.print(products.get(i).getNumber() + "\t");
			System.out.print(products.get(i).getName() + "\t");
			System.out.print(products.get(i).getPrice() + "\t");
			System.out.println(products.get(i).getInformation());
			
		}
		
	} // End of disPlayProductList()
	
	
	public Product addProductView(){
		
		System.out.println("상품등록 화면입니다");
		System.out.println("상품명을 입력하십시오 >");
		String name = keyboard.next();
		
		System.out.println("상품가격을 입력하십시오 >");
		int price = keyboard.nextInt();
		
		System.out.println("상품정보를 입력하십시오 >");
		String information = keyboard.next();
		
		Product newProduct = new Product(name, price, information);
		
		return newProduct;
		
	} // End of addProductView()
	
	
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
	
	
	public Product deleteProductView(int selectedNum){
	
		Product deleteProduct = new Product();
		
		deleteProduct.setNumber(selectedNum);
		
		return deleteProduct;
		
	} // End of deleteProductView()
		
}
