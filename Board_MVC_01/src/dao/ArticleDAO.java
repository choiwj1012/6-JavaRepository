package dao;

import domain.Article;
import repository.ArticleRepository;

public class ArticleDAO {

	public boolean insert(Article article){
		
		boolean success = false;
		
		ArticleRepository repository = new ArticleRepository();
		repository.setLastArticlePosition(repository.getLastArticlePosition() + 1);
		article.setNumber(repository.getLastArticlePosition());
		
		/* ArrayList<Article> articles = repository.getArticles(); 
		 * articles.add(article); */
		success = repository.getArticles().add(article);
		
		return success;
		
	}
	
}
