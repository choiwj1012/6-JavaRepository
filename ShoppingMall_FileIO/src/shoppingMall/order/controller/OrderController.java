package shoppingMall.order.controller;

import java.util.ArrayList;

import shoppingMall.mainController.MainController;
import shoppingMall.order.dao.OrderDAO;
import shoppingMall.order.view.OrderListView;
import shoppingMall.order.view.OrderMenuView;
import shoppingMall.order.view.SelectProductNumber;
import shoppingMall.order.view.UpdateOrderView;
import shoppingMall.order.vo.Order;
import shoppingMall.product.vo.Product;

public class OrderController {

	// variable
	OrderDAO orderDAO;

	// constructor
	public OrderController(){

		this.orderDAO = new OrderDAO();

	}

	// method
	// 주문 요청
	public void requestOrderMenu(){

		OrderMenuView orderMenuView = new OrderMenuView();
		orderMenuView.orderMenu();

	}


	public void requestOrder(){

		// 상품목록 요청
		MainController.getProductController().requestReadProduct();
		
		// 구매상품 선택
		SelectProductNumber selectProductNumber = new SelectProductNumber(); 
		Order selectedOrder = selectProductNumber.selectProductNumber();
		
		// 전체상품리스트 요청
		ArrayList<Product> allProductList = MainController.getProductController().requestAllProductList();
		
		// 선택한 상품이 존재하는시 확인
		boolean isFind = orderDAO.checkOrderProduct(selectedOrder,allProductList);
		
		// 선택한 상품이 장바구니에 이미 존재하는지 확인
		boolean isFindInOrder = orderDAO.checkOrderProductInCart(selectedOrder);
		
		if(!isFind){
			
			MainController.requestMainAlertView("선택하신 상품은 존재하지 않습니다.");
			
		} else {
			
			if(isFindInOrder){
				
				System.out.println("이미 존재하는 상품입니다");
				System.out.println("수정하시려면 수정하기를 눌러주세요");
				
			} else {
				
				boolean success = orderDAO.order(selectedOrder);
				
				if(success){
					
					MainController.requestMainAlertView("상품이 성공적으로 장바구니에 담겨졌습니다");	
					
				} else{
					
					MainController.requestMainAlertView("상품이 장바구니에 담겨지지 않았습니다");
					
				}
					
			}
								
		}

	}


	// 주문 리스트 요청
	public void requestOrderList(){

		ArrayList<Order> allOrderList = orderDAO.selectAll();
		ArrayList<Product> allProductList = MainController.getProductController().requestAllProductList();

		OrderListView orderListView = new OrderListView();
		orderListView.orderListView(allOrderList, allProductList);

	}


	// 주문 리스트 수정 요청
	public void requestUpdateOrder(){

		UpdateOrderView orderUpdateView = new UpdateOrderView();
		Order updateOrder = orderUpdateView.orderUpdate();
		orderDAO.updateOrder(updateOrder);

	}

}
