package view;

import java.util.Scanner;

import controller.ArticleController;
import domain.Article;

public class ArticleWriteView {

	// variable
	Scanner keyboard;
	ArticleController articleController;
	
	// constructor
	public ArticleWriteView(ArticleController articleController){
		
		this.keyboard = new Scanner(System.in);
		this.articleController = articleController;
	}
	
	// 글쓰기를 위한 정보입력
	public void writeView(){
		
		System.out.println("글쓰기 모드 입니다");
		
		System.out.println("제목 입력 : ");
		String title = keyboard.next();
		
		System.out.println("글내용 입력 : ");
		String content = keyboard.next();
		
		System.out.println("작성자 입력 : ");
		String writer = keyboard.next();
		
		Article newArticle = new Article(title, content, writer);
		
		articleController.writeInfo(newArticle);
		
	} // End of writeView()
	
}
