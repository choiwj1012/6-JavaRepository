package view;

import java.util.Scanner;

import controller.ArticleController;

public class ArticleDeleteView {

	// variable
	private Scanner keyboard;
	private ArticleController articleController;	
	
	// constructor
	public ArticleDeleteView(ArticleController articleController){
		
		this.keyboard = new Scanner(System.in);
		this.articleController = articleController;
		
	}
	
	
	public void selectNumFordeleteView(){
		
		System.out.println("삭제하실 글번호를 선택하십시오");
		int selectedNum = keyboard.nextInt();
		
		articleController.requestDelete(selectedNum);
		
	}
	
}
