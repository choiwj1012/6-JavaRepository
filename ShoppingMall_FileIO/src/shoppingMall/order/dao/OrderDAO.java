package shoppingMall.order.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import shoppingMall.order.vo.Order;
import shoppingMall.product.vo.Product;

public class OrderDAO {
	
	// variable
	private File file;
	
	// constructor
	public OrderDAO(){
		
		file = new File("order.txt");
		
		try{
			
			boolean newFile = file.createNewFile();
			
			if(newFile){
				System.out.println("생성성공");
			}else{
				System.out.println("이미존재");
			}
			
		} catch(IOException e) {
			
			System.out.println("연결 실패");
			e.printStackTrace();
			
		}
		
	}


	// method
	// 요청 번호 주문 리스트에 넣기
	public boolean order(Order selectedOrder){

		boolean success = false;
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try{
		
			fileWriter = new FileWriter(file, true);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			int orderNumber = lastOrderNumber() + 1;
			selectedOrder.setOrderNumber(orderNumber);
			
			bufferedWriter.write(selectedOrder.getOrderNumber() + ",");
			bufferedWriter.write(selectedOrder.getProductNumber() + ",");
			bufferedWriter.write(selectedOrder.getProductCount() + "\r\n");
			
			System.out.println("주문 등록 완료");
						
		} catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다");
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("파일을 쓸 수 없습니다");
			e.printStackTrace();
		} finally {
			
			try{
				bufferedWriter.close();
				fileWriter.close();	
				System.out.println("IO자원 닫기 성공");
			} catch(IOException e) {
				System.out.println("IO자원 닫기 실패");
				e.printStackTrace();
			}
			
		}
		
		success = true;
		
		return success;
	}

	
	// 선택 주문한 상품이 존재하는지 확인
	public boolean checkOrderProduct(Order selectedOrder, ArrayList<Product> allProductList){
		
		boolean isFind = false;
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			for(int i = 0; i<allProductList.size(); i++){
				if(selectedOrder.getProductNumber() == allProductList.get(i).getProductNumber()){
					
					isFind = true;
					return isFind;
					
				}
			}	
			
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try{
				bufferedReader.close();
				fileReader.close();
			} catch(IOException e){}
		}
		
		return isFind;
		
	}
	
	
	// 선택한 상품이 장바구니에 이미 존재하는지 확인
	public boolean checkOrderProductInCart(Order selectedOrder){
		
		boolean isFindInOrder = false;
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try{
			
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			while(true){
			
				String orderString = bufferedReader.readLine();
				
				if(orderString == null){
					break;
				}
				
				StringTokenizer stringTokenizer = new StringTokenizer(orderString, ",");
				
				if(stringTokenizer.hasMoreTokens()){
			
					stringTokenizer.nextToken();
					int productNumber = Integer.parseInt(stringTokenizer.nextToken());
					stringTokenizer.nextToken();
					
					if(productNumber == selectedOrder.getProductNumber()){
						isFindInOrder = true;
						return isFindInOrder;
					}
			
				}
					
			} 
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try{
				bufferedReader.close();
				fileReader.close();
			} catch(IOException e) {}
			
		}
		
		return isFindInOrder;
		
	}
	
	
	// 주문 리스트 전체 요청
	public ArrayList<Order> selectAll(){

		ArrayList<Order> orders = new ArrayList<Order>();
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try{
			
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			while(true){
				
				String orderString = bufferedReader.readLine();
				
				if(orderString == null){
					break;
				}
				
				StringTokenizer stringTokenizer = new StringTokenizer(orderString, ",");
				
				if(stringTokenizer.hasMoreTokens()){
					
					int orderNumber = Integer.parseInt(stringTokenizer.nextToken());
					int productNumber = Integer.parseInt(stringTokenizer.nextToken()); 
					int productCount = Integer.parseInt(stringTokenizer.nextToken());
					
					Order order = new Order(orderNumber, productNumber, productCount);
					orders.add(order);
				}
				
			}
			
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			
			try{
				
				bufferedReader.close();
				fileReader.close();
				
			} catch(IOException e) {
				
			}
			
		}
		
		return orders;
		
	}

	
	// 주문 리스트 수정 요청
	public void updateOrder(Order updateOrder){

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		ArrayList<Order> orders = selectAll();
		
		for(int i=0; i<orders.size(); i++){
			if(updateOrder.getOrderNumber() == orders.get(i).getOrderNumber()){
			
				if(updateOrder.getProductCount() == -1){
					orders.remove(i);
					break;
				}
				
				orders.get(i).setProductCount(updateOrder.getProductCount());
			}
		}
		
		try{
			
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
		
			for(int i=0; i<orders.size(); i++){
				bufferedWriter.write(orders.get(i).getOrderNumber() + ",");
				bufferedWriter.write(orders.get(i).getProductNumber() + ",");
				bufferedWriter.write(orders.get(i).getProductCount() + "\r\n");
			}
	
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			
			try{
				bufferedWriter.close();
				fileWriter.close();
			} catch(IOException e) {}
			
		}
		
	}
	
	// 주문 번호
	public int lastOrderNumber(){
		
		int lastOrderNumber = 0;
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try{
			
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			while(true){
				
				String userString = bufferedReader.readLine();
				
				if(userString == null){
					break;
				}
				
				StringTokenizer stringTokenizer = new StringTokenizer(userString, ",");
				
				if(stringTokenizer.hasMoreTokens()){
					
					lastOrderNumber = Integer.parseInt(stringTokenizer.nextToken());
					stringTokenizer.nextToken();
					stringTokenizer.nextToken();
					
				}
					
			}
			
		} catch(IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				bufferedReader.close();
				fileReader.close();
				
			} catch (IOException e) {}
			
		}
		
		return lastOrderNumber;
		
	}

}
