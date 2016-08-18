package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ArticleController;
import domain.Article;

public class ArticleListView {

	// variable
	private Scanner keyboard;
	private ArticleController controller;
	
	// constructor
	public ArticleListView(ArticleController controller){
		
		this.controller = controller;
		this.keyboard = new Scanner(System.in);
	}
	
	// method
	public void listArticle(ArrayList<Article> articles){
		
		System.out.println("번호\t제목\t작성자\t작성일\t조회수");
		
		if(articles.size() == 0){
			
			System.out.println("등록된 글이 없습니다");
			this.showMainMenu();
			
		}
		
		for(int i=0; i<articles.size(); i++){
			
			System.out.print(articles.get(i).getNumber() + "\t");
			System.out.print(articles.get(i).getTitle() + "\t");
			System.out.print(articles.get(i).getWriter() + "\t");
			System.out.print(articles.get(i).getWriteDate() + "\t");
			System.out.println(articles.get(i).getReadCount() + "\t");
			
		}
		
		this.showMainMenu();
		
	} // End of listArticle()
	
	
	private void showMainMenu(){
			
			String[] menu = {"","[1.글쓰기]","[2.글목록]","[3.글선택보기]","[4.글수정]","[5.글삭제]","[6.종료]",""};
			for(int i=0; i<menu.length; i++){
				System.out.println(menu[i]);
			}
			int selectedMenu = keyboard.nextInt();
			
			if(selectedMenu == 1){
				
				controller.requestWriteArticle();
				
			} else if (selectedMenu == 2){
				
				controller.requestReadArticle();
				
			} else if (selectedMenu == 3){
				
			} else if (selectedMenu == 4){
				
			} else if (selectedMenu == 5){
				
			} else if (selectedMenu == 6){
				
				System.out.println("프로그램을 종료합니다.");
				return;
				
			} else {
				
				System.out.println("잘못누르셧습니다.");
				
			}

	} // End of showMainMenu() 
	
}
