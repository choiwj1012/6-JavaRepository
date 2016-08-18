package view;

import java.util.Scanner;

import domain.Article;

public class ArticleUpdateView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public ArticleUpdateView() {
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	// method
	public Article updateArticle(){
		
		Article article = null;
		System.out.println("[글 수정 모드]");
		
		System.out.println("제목 : ");
		String title = keyboard.next();
		
		System.out.println("내용 : ");
		String content = keyboard.next();
		
		System.out.println("작성자  : ");
		String writer = keyboard.next();
		
		article = new Article(title, content, writer);
		
		return article;
		
	}
	
}
