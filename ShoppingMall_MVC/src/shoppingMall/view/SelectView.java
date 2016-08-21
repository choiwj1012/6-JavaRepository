package shoppingMall.view;

import java.util.Scanner;

public class SelectView {
	
	// variable
	Scanner keyboard;
	
	// constructor
	public SelectView(){
		
		this.keyboard = new Scanner(System.in);
		
	}
	

	// method
	public int selectView(){

		int selectedNum = 0; 

		System.out.println("원하시는 상품번호를 입력해 주세요");
		selectedNum = keyboard.nextInt();

		return selectedNum;

	} // End of selectView()
	
}
