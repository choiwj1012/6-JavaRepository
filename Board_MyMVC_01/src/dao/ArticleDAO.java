package dao;

import java.util.ArrayList;

import domain.Article;
import repository.ArticleRepository;

public class ArticleDAO {

	// variable
	ArticleRepository repository;
	
	// constructor
	public ArticleDAO(){
		
		this.repository = new ArticleRepository();
		
	}
	
	public boolean insert(Article article){
		
		boolean success = false;
		
		repository.lastArticlePosition = repository.lastArticlePosition + 1; 
		article.setNumber(repository.lastArticlePosition);
		repository.articles.add(article);
			
		return success;
		
	}
	
	public ArrayList<Article> selectAll(){
		
		ArrayList<Article> articles = null;
		
		articles = repository.articles;
		
		return articles;
		
	}
	
	public Article selectOne(int selectedNum){
		
		Article article = null;
		
		for(int i=0; i<repository.articles.size(); i++){
			if(selectedNum == repository.articles.get(i).getNumber()){
				
				article = repository.articles.get(i);
				return article;
				
			}
		}
		
		return article;
		
	}
	
	public boolean delete(int number){
		
		boolean success = false;
		
		for(int i=0; i<repository.articles.size(); i++){
			if(number == repository.articles.get(i).getNumber()){
				
				repository.articles.remove(i);
				success = true;
				break;
			}
		}
		
		return success;
			
	}
	
	
	
	
	
	
}
