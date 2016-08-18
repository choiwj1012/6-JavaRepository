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
