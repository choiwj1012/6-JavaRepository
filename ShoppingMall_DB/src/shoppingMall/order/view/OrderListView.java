package shoppingMall.order.view;

import java.util.ArrayList;

import shoppingMall.mainController.MainController;
import shoppingMall.order.vo.Order;
import shoppingMall.product.vo.Product;


public class OrderListView {

	
	// 상품 리스트 전체 보기
	public void orderListView(ArrayList<Order> allOrderList, ArrayList<Product> allProductList){
		
		int totalPrice = 0;
		System.out.println("장바구니 상품목록 입니다");
		System.out.println("주문번호\t상품명\t상품브랜드\t상품색상\t상품가격\t상품수량");
		
		if(allOrderList.size() == 0) {
			
			MainController.requestMainAlertView("주문상품이 없습니다");
			
		} else {
			
			for(int i=0; i<allOrderList.size(); i++) {
			
				System.out.print(allOrderList.get(i).getOrderNumber() + "\t");
				
				for(int j=0; j<allProductList.size(); j++) {
				
					if(allOrderList.get(i).getProductNumber() == allProductList.get(j).getProductNumber()) {
						System.out.print(allProductList.get(j).getProductName() + "\t");
						System.out.print(allProductList.get(j).getProductBrandName() + "\t");
						System.out.print(allProductList.get(j).getProductColor() + "\t");
						System.out.print(allProductList.get(j).getProductPrice() + "\t");
						
						totalPrice = totalPrice + (allProductList.get(j).getProductPrice() * allOrderList.get(i).getProductCount());
					}
					
				}
				
				System.out.println(allOrderList.get(i).getProductCount());
			}
			
			//합계 금액
			System.out.println("합계 : " + totalPrice);
		}
		
	}
	
}
