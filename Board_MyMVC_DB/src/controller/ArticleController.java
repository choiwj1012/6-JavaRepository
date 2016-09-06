package controller;

import java.util.ArrayList;

import dao.ArticleDAO;
import domain.Article;
import view.AlertView;
import view.ArticleDeleteView;
import view.ArticleListView;
import view.ArticleReadView;
import view.ArticleUpdateView;
import view.ArticleWriteView;
import view.ShowMainMenu;

public class ArticleController {


	// variable
	private ArticleDAO articleDAO;


	// constructor
	public ArticleController(){

		this.articleDAO = new ArticleDAO();

	}


	// method
	// 메인메뉴 출력
	public void requestShowMainMenu(){

		requestSelectAll();
		ShowMainMenu showMainMenu = new ShowMainMenu(this);
		showMainMenu.showMainMenu();

	} // End of requestShowMainMenu()


	// 글쓰기
	public void requestWriteView(){

		ArticleWriteView articleWriteView = new ArticleWriteView(this);
		articleWriteView.writeView();

	} // End of requestWriteView()


	// 글쓴 정보를 받아서 dao로 넘김
	public void writeInfo(Article newArticle){

		boolean success = articleDAO.write(newArticle);
		AlertView alert = new AlertView();

		if(success){
			alert.alertView("글쓰기에 성공하였습니다");
		}else{
			alert.alertView("글쓰기에 실패하였습니다");
		}

	} // End of writeInfo()


	// 글전체 조회
	public void requestSelectAll(){

		ArrayList<Article> articles = articleDAO.selectAll();
			
		ArticleListView articleListView = new ArticleListView();
		articleListView.listView(articles);
		
		AlertView alert = new AlertView();
		if(articles.size() == 0){
			alert.alertView("글이 없습니다");
		}
		
	} // End of requestSelectAll()


	// 조회를 위한 글번호 선택
	public void selectedNumForRead(){

		ArticleReadView articleNumView = new ArticleReadView(this);
		articleNumView.selectedNumForReadView();

	} // End of selectedNumForRead()


	// 글선택 조회
	public void requestSelectNumForRead(int selectedNum){

		Article selectedArticle = articleDAO.selectOne(selectedNum);
		ArticleReadView articleNumView = new ArticleReadView(this);
		articleNumView.selectArticleView(selectedArticle);

	} // End of requestSelectNumForRead()


	// 수정을 위한 글번호 선택
	public void selectedNumForUpdate(){

		ArticleUpdateView articleNumView = new ArticleUpdateView(this);
		articleNumView.selectNumForUpdateView();

	} // End of selectedNumForUpdate()


	// 수정을 위한 정보 받기
	public void requestUpdateInfo(int selectedNum){

		ArticleUpdateView articleNumView = new ArticleUpdateView(this);
		articleNumView.updateInfoView(selectedNum);

	} // End of requestUpdateInfo()


	// 수정한 정보 dao로 넘기기
	public void requestUpdate(Article updateArticle){

		boolean success = articleDAO.update(updateArticle);

		AlertView alert = new AlertView();

		if(success){
			alert.alertView("정상적으로 수정되었습니다");
		}else{
			alert.alertView("수정에 실패하였습니다");
		}

	} // End of requestUpdate()


	// 삭제을 위한 글번호 선택
	public void selectedNumForDelete(){

		ArticleDeleteView articleNumView = new ArticleDeleteView(this);
		articleNumView.selectNumFordeleteView();

	} // End of selectedNumForUpdate()


	// 글삭제
	public void requestDelete(int selectedNum){

		boolean success = articleDAO.delete(selectedNum);

		AlertView alert = new AlertView();

		if(success){
			alert.alertView("정상적으로 삭제되었습니다");
		}else{
			alert.alertView("삭제에 실패하였습니다");
		}

	} // End of requestUpdate()

}
