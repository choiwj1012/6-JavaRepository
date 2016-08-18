package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import controller.ArticleController;
import domain.Article;

public class ArticleReadView {

	// variable
	private Scanner keyboard;
	private ArticleController controller;
	
	// constructor
	public ArticleReadView(ArticleController controller){
		
		this.keyboard = new Scanner(System.in);
		this.controller = controller;
		
	}
	
	// method
	public int getNumber(){
		
		int number = 0;
		
		System.out.println("조회할 글번호 : ");
		number = keyboard.nextInt();
		
		return number;
		
	}
	
	
	public void printArticle(Article article){
		
		System.out.println("글번호 : " + article.getNumber());
		System.out.println("글제목 : " + article.getTitle());
		System.out.println("글내용 : " + article.getContent());
		System.out.println("작성자 : " + article.getWriter());
		
		Date date = article.getWriteDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd H:mm:ss");
		String dataStr = dateFormat.format(date);
		
		System.out.println("작성일 : " + dataStr);
		System.out.println("조회수 : " + article.getReadCount());
		
		this.showMenu(article.getNumber());
	}
	
	
	public void showMenu(int number){
		
		System.out.println("[1. 글목록, 2. 글수정, 3. 글삭제]");
		int selectedMenu = keyboard.nextInt();
		
		if(selectedMenu == 1){
			
			controller.requestListArticle();
			
		} else if(selectedMenu == 2){

			controller.requestUpdateArticle(number);
			
		} else if(selectedMenu == 3){
			
			controller.requestDeleteArticle(number);
			
		} else {
			
			System.out.println("메뉴를 다시 선택해주세요");
			
		}
		
	}
	
	
}
