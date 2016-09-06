package view;

import java.util.Scanner;

import controller.ArticleController;
import domain.Article;

public class ArticleUpdateView {
	
	
	// variable
	private ArticleController articleController;
	private Scanner keyboard;
	
	
	// constructor
	public ArticleUpdateView(ArticleController articleController){
		
		this.articleController = articleController;
		this.keyboard = new Scanner(System.in);
		
	}
	
	
	// method
	// 수정을 위한 번호 선택하기
	public void selectNumForUpdateView(){

		System.out.println("수정을 원하시는 글번호를 선택하여 주십시오");
		int selectedNum = keyboard.nextInt();

		articleController.requestUpdateInfo(selectedNum);

	} // End of selectUpdateNumber()
	
	
	// 수정정보 입력받기
	public void updateInfoView(int selectedNum){
		
		System.out.println("글수정 모드입니다");
		System.out.println("수정할 내용을 입력해 주십시오");
		System.out.println("글제목 : ");
		String title = keyboard.next();
		System.out.println("글내용 : ");
		String content = keyboard.next();
		System.out.println("작성자 : ");
		String writer = keyboard.next();
		
		Article updateArticle = new Article(selectedNum, title, content, writer);
		articleController.requestUpdate(updateArticle);
		
	} // End of updateInfoView()
		
}
