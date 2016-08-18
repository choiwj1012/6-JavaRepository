package repository;

import java.util.ArrayList;

import domain.Article;

public class ArticleRepository {

	// 글배열 선언
	public ArrayList<Article> articles = new ArrayList<Article>();
	
	// 글갯수 변수 선언
	public int lastArticlePosition = 0;
	
}
