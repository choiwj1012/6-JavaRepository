package shoppingMall.product.view;

import java.util.ArrayList;

import shoppingMall.product.vo.Product;

public class DisplayProductList {
	
	// method
	public void disPlayProductList(ArrayList<Product> products){
		
		System.out.println("상품번호\t상품명\t상품가격\t상품정보");
		
		if(products.size() == 0){
			
			System.out.println("\n상품이 없습니다\n");
		
		} else {	
			
			for(int i=0; i<products.size(); i++){
				
				System.out.print(products.get(i).getNumber() + "\t");
				System.out.print(products.get(i).getName() + "\t");
				System.out.print(products.get(i).getPrice() + "\t");
				System.out.println(products.get(i).getInformation());
				
			}	
			
		}
		
	} // End of disPlayProductList()

}
