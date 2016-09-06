package shoppingMall.order.repository;

import java.util.ArrayList;

import shoppingMall.order.vo.Order;

public class OrderRepository {

	// 주문으로 담겨진 상품의 리스트 배열
	private static ArrayList<Order> orderList = new ArrayList<Order>(); 
	
	// 상품 리스트의 갯수
	private static int lastOrderNumber;

	// getter and setter
	public static ArrayList<Order> getOrderList() {
		return orderList;
	}

	public static void setOrderList(ArrayList<Order> orderList) {
		OrderRepository.orderList = orderList;
	}

	public static int getLastOrderNumber() {
		return lastOrderNumber;
	}

	public static void setLastOrderNumber(int lastOrderNumber) {
		OrderRepository.lastOrderNumber = lastOrderNumber;
	}
		
}
