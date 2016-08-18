package controller;

import View.AlertView;
import View.ArticleWriteView;
import dao.ArticleDAO;
import domain.Article;

public class ArticleController {

	// 뷰로부터 콘트롤러에 요청한다
	// 콘트롤러는 대부분 void 리턴값을 가짐
	
	public void requestWriteArticle(){  // 글쓰기 요청에 대응하는 메서드
		
		// 글쓰기 뷰를 호출
		ArticleWriteView writeView = new ArticleWriteView();
		Article article = writeView.writeArticle();
		
		// Dao에서 글쓰기 메서드를 호출
		ArticleDAO dao = new ArticleDAO();
		boolean success = dao.insert(article);
		
		AlertView alertView = new AlertView();
		
		if(success){
			
			alertView.alert("글쓰기 성공");
			
		} else {
			
			alertView.alert("글쓰기 실패");
			
		}
		
	}
	
}
