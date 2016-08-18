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
		articles = articleDAO.selectAll();
		ArticleListView listView = new ArticleListView(this);
		listView.articleListView(articles);
			
	} // End of requestListArticle()
	
	public void requestWriteArticle(){
		
		boolean success = false;
		ArticleWriteView writeView = new ArticleWriteView(this);
		article = writeView.articleWriteView();
		success = articleDAO.insert(article);
		
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
		int selectedNum = selectArticleNum.selectArticleNum(); // 선택한 숫자 받음
		article = articleDAO.selectOne(selectedNum); // 해당하는 배열 찾음
		ArticleListView listView = new ArticleListView(this);
		listView.printSelectView(article); // 그 배열을 출력함
		
	} // End of requestReadArticle()
	
	public void requestUpdateArticle(){
		
		ArticleUpdateView update = new ArticleUpdateView(this);
		SelectNumView selectArticleNum = new SelectNumView();
		int selectedNum = selectArticleNum.selectArticleNum();
		article = articleDAO.selectOne(selectedNum);
		update.articleUpdateView(article);
		
	} // End of requestUpdateArticle()
	
	public void requestDeleteArticle(){
		
		SelectNumView selectArticleNum = new SelectNumView();
		int selectedNum = selectArticleNum.selectArticleNum();
		
		boolean success = articleDAO.delete(selectedNum);
		AlertView alertView = new AlertView();
		
		if(success){
	
			alertView.alertView("삭제 성공");
	
		} else {
			
			alertView.alertView("삭제 실패");
			
		}
		
	} // End of requestDeleteArticle()
	
}
