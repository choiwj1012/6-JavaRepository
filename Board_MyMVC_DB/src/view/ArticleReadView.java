package view;

import java.util.Scanner;

import controller.ArticleController;
import domain.Article;

public class ArticleReadView {

	// variable
	private Scanner keyboard;
	private ArticleController articleController;

	// constructor
	public ArticleReadView(ArticleController articleController){

		this.keyboard = new Scanner(System.in);
		this.articleController = articleController;

	}


	// method
	// 글번호 선택
	public void selectedNumForReadView(){

		System.out.println("조회를 원하시는 글번호를 선택하여 주십시오");
		int selectedNum = keyboard.nextInt();

		articleController.requestSelectNumForRead(selectedNum);

	} // End of selectNumber()

	
	// 선택된 글번호 출력하기
	public void selectArticleView(Article selectedArticle){

		System.out.println("글번호\t글제목\t글내용\t작성자\t작성일\t조회수");

		System.out.println("글번호 : " + selectedArticle.getArticleNumber());
		System.out.println("글제목 : " + selectedArticle.getTitle());
		System.out.println("글내용 : " + selectedArticle.getContent());
		System.out.println("작성자 : " + selectedArticle.getWriter());
		System.out.println("작성일 : " + selectedArticle.getWriteDate());
		System.out.println("조회수 : " + selectedArticle.getReadCount());

	} // End of selectArticleView()


}
