package dao;

import java.util.ArrayList;

import domain.Article;
import repository.ArticleRepository;

public class ArticleDAO {
	
	// variable
	ArticleRepository repository;
	
	// constructor
	public ArticleDAO(){
		
		repository = new ArticleRepository();
		System.out.println("새로운 DAO가 생성되었습니다");
		
	}

	
	// method
	public boolean insert(Article article){
		
		boolean success = false;
		
		repository.setLastArticlePosition(repository.getLastArticlePosition() + 1);
		article.setNumber(repository.getLastArticlePosition());
		
		// ArrayList<Article> articles = repository.getArticles(); 
		// articles.add(article); 
		success = repository.getArticles().add(article);
		
		return success;
		
	}
	
	
	public ArrayList<Article> selectAll(){
		
		ArrayList<Article> articles = repository.getArticles();
		return articles;
		
		// ArticleRepository repository = new ArticleRepository();
		// return repository.getArticles();
		
		// return new ArticleRepository().getArticles();
		
	}
	
	
	public Article selectOne(int number){
		
		Article article = null;
		
		for(int i=0; i<repository.getArticles().size(); i++){
			if(number == repository.getArticles().get(i).getNumber()){
				repository.getArticles().get(i).setReadCount(repository.getArticles().get(i).getReadCount() + 1);
				article = repository.getArticles().get(i); 
				break;
				
			}
		}
		
		return article;
	}
	
	
	public boolean update(Article article){
		
		boolean success = false;
		
		for(int i=0; i<repository.getArticles().size(); i++){
			if(article.getNumber() == repository.getArticles().get(i).getNumber()){
				
				repository.getArticles().get(i).setTitle(article.getTitle());
				repository.getArticles().get(i).setContent(article.getContent());
				repository.getArticles().get(i).setWriter(article.getWriter());
				success = true;
				break;
			}
				
		}
		
		
		return success;
	
	}
	
	
	public boolean delete(int number){
		
		boolean success = false;
		
		for(int i=0; i<repository.getArticles().size(); i++){
			if(number == repository.getArticles().get(i).getNumber()){
				
				repository.getArticles().remove(i);
				success = true;
				break;
			}
				
		}
		
		return success;
		
	}
	
}
