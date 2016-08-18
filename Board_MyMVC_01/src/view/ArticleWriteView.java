package view;

import java.util.Scanner;

import controller.ArticleController;
import domain.Article;

public class ArticleWriteView {

	// variable 
	private Scanner keyboard;
	private ArticleController controller;
	
	// constructor
	public ArticleWriteView(ArticleController controller){
		
		this.keyboard = new Scanner(System.in);
		this.controller = controller;
	}
	
	
	public Article articleWriteView(){
		
		System.out.println("글을 작성할 수 있는 메뉴입니다.");
		System.out.println("1. 제목을 입력하십시오");
		String title = keyboard.next();
		System.out.println("2. 내용을 입력하십시오");
		String content = keyboard.next();
		System.out.println("3. 작성자를 입력하십시오");
		String writer = keyboard.next();
		
		Article article = new Article(title, content, writer);
		
		return article;
	}
	
}
