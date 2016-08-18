package controller;

import java.util.ArrayList;

import dao.ArticleDAO;
import domain.Article;
import view.AlertView;
import view.ArticleListView;
import view.ArticleReadView;
import view.ArticleUpdateView;
import view.ArticleWriteView;

public class ArticleController {

	// 뷰로부터 콘트롤러에 요청한다
	// 콘트롤러는 대부분 void 리턴값을 가짐
	
	// variable
	ArticleDAO dao;
	
	// constructor
	public ArticleController(){
		
		this.dao = new ArticleDAO();
		
	}
	
	// method
	public void requestWriteArticle(){  // 글쓰기 요청에 대응하는 메서드
		
		// 글쓰기 뷰를 호출
		ArticleWriteView writeView = new ArticleWriteView();
		Article article = writeView.writeArticle();
		
		// Dao에서 글쓰기 메서드를 호출
		boolean success = dao.insert(article);
		
		AlertView alertView = new AlertView();
		
		if(success){
			
			alertView.alert("글쓰기 성공");
			
		} else {
			
			alertView.alert("글쓰기 실패");
			
		}
		
		requestListArticle();
		
	}
	
	
	public void requestListArticle(){ // 글목록 요청에 대응하는 메서드
		
		// 글 목록 DAO 메서드 호출
		ArrayList<Article> articles = dao.selectAll();
		
		// 글목록 View
		ArticleListView listView = new ArticleListView(this);
		listView.listArticle(articles);
		
	}
	
	
	public void requestReadArticle(){ // 글조회 요청에 대응하는 메서드
		
		ArticleReadView readView = new ArticleReadView(this);
		
		// 조회 글 가져오기
		int number = readView.getNumber();
		Article article = dao.selectOne(number);
		
		// 조회 글 보이기
		readView.printArticle(article);
		
	}
	
	
	public void requestUpdateArticle(int number){
		
		// 수정전 article 정보 view
		Article article = dao.selectOne(number);
		ArticleReadView readView = new ArticleReadView(this);
		
		System.out.println("여기까지");
		
		// 수정 view
		ArticleUpdateView updateView = new ArticleUpdateView();
		article = updateView.updateArticle();
		article.setNumber(number);
		
		// Dao 통해 수정
		boolean success = dao.update(article);
		
		AlertView alertView = new AlertView();
		
		if(success){
		
			alertView.alert("글수정 성공");
			
		} else {
			
			alertView.alert("글수정 실패");
			
		}
		
		requestListArticle();
		
	}
	
	
	public void requestDeleteArticle(int number){
		
		// DAO
		boolean success = dao.delete(number);
		AlertView alertView = new AlertView();
		
		if(success){
			
			alertView.alert("글삭제 성공");
			
		} else {
			
			alertView.alert("글삭제 실패");
			
		}
		
		requestListArticle();
				
	}
	
}
