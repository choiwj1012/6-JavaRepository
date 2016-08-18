package controller;

import java.util.ArrayList;

import dao.ArticleDAO;
import domain.Article;
import view.AlertView;
import view.ArticleListView;
import view.ArticleUpdateView;
import view.ArticleWriteView;
import view.SelectNumView;
import view.ShowMainMenu;

public class ArticleController {

	// variable
	ArticleDAO articleDAO;
	Article article;
	
	// constructor
	public ArticleController(){
		
		this.articleDAO = new ArticleDAO();

	}
	
	// method
	public void requestShowMainMenu(){
		
		ShowMainMenu showMainMenu = new ShowMainMenu(this);
		showMainMenu.showMainMenu();
		
	} // End of requestShowMainMenu()
	
	
	public void requestListArticle(){
		
		ArrayList<Article> articles = null;
		articles = articleDAO.selectAll(); // 모든 배열 받기
		ArticleListView listView = new ArticleListView();
		listView.articleListView(articles); // 모든 배열 출력하기
			
	} // End of requestListArticle()
	
	
	public void requestWriteArticle(){
		
		boolean success = false;
		ArticleWriteView writeView = new ArticleWriteView();
		article = writeView.articleWriteView(); // 글 작성
		success = articleDAO.insert(article); // 작성한 글 배열에 삽입
		
		AlertView alertView = new AlertView();
		
		if(success){
			
			alertView.alertView("글생성 성공");
			
		} else {
			
			alertView.alertView("글생성 실패");
			
		}
		
		requestListArticle();
		
	} // End of requestWriteArticle()
	
	
	public void requestReadArticle(){
		
		SelectNumView selectArticleNum = new SelectNumView();
		int selectedNum = selectArticleNum.selectArticleNum(); // 선택한 숫자 받기
		article = articleDAO.selectOne(selectedNum); // 선택한 숫자에 해당하는 배열 받기
		
		ArticleListView listView = new ArticleListView(); 
		listView.printSelectView(article); //선택된 배열 출력하기
		
	} // End of requestReadArticle()
	
	
	public void requestUpdateArticle(){
		
		SelectNumView selectArticleNum = new SelectNumView();
		int selectedNum = selectArticleNum.selectArticleNum(); // 선택한 숫자 받기
		article = articleDAO.selectOne(selectedNum); // 선택한 숫자에 해당하는 배열 받기
		
		ArticleUpdateView update = new ArticleUpdateView();
		update.articleUpdateView(article); //선택된 배열 출력하기
		
	} // End of requestUpdateArticle()
	
	
	public void requestDeleteArticle(){
		
		SelectNumView selectArticleNum = new SelectNumView();
		int selectedNum = selectArticleNum.selectArticleNum(); // 선택한 숫자 받기
		
		boolean success = articleDAO.delete(selectedNum); // 선택된 배열 삭제
		AlertView alertView = new AlertView();
		
		if(success){
	
			alertView.alertView("삭제 성공");
	
		} else {
			
			alertView.alertView("삭제 실패");
			
		}
		
	} // End of requestDeleteArticle()
	
}
