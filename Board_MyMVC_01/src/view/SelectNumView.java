package view;

import java.util.Scanner;

public class SelectNumView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public SelectNumView(){
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	
	// method
	public int selectArticleNum(){

		System.out.println("수정할 글 번호를 선택하십시오");
		int selectedNum = keyboard.nextInt();
		return selectedNum;

	}
}
