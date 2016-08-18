package repository;

import java.util.ArrayList;

import domain.Article;

public class ArticleRepository {

	// 글 객체 배열
	private ArrayList<Article> articles;
	
	// 글 갯수
	private int lastArticlePosition;
	
	// constructor
	public ArticleRepository() {
	
		this.articles = new ArrayList<Article>();
		System.out.println("새로운 리파지토리가 생성되었습니다");
		
	}

	// getter and setter
	public int getLastArticlePosition() {
		return lastArticlePosition;
	}

	public void setLastArticlePosition(int lastArticlePosition) {
		this.lastArticlePosition = lastArticlePosition;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}
	
}
