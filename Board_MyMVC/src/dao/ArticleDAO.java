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
	
	// method
	public boolean insert(Article article){ // 작성된 글 배열에 삽입
		
		boolean success = false;
		
		repository.lastArticlePosition = repository.lastArticlePosition + 1; // 글 갯수 1 증가
		article.setNumber(repository.lastArticlePosition); // article 인스턴스에 번호 저장
		repository.articles.add(article); // article 인스턴스 배열에 저장
			
		return success;
		
	} // End of insert()
	
	
	public ArrayList<Article> selectAll(){
		
		ArrayList<Article> articles = null;
		
		articles = repository.articles; // 배열 전체를 articles에 넣음
		
		return articles; // 배열전체를 내보냄
		
	} // End of selectAll()
	
	
	public Article selectOne(int selectedNum){
		
		Article article = null;
		
		for(int i=0; i<repository.articles.size(); i++){
			if(selectedNum == repository.articles.get(i).getNumber()){
				
				article = repository.articles.get(i); // 선택된 배열객체를 article에 넣음
				return article; // 선택된 article 내보냄
				
			}
		}
		
		return article;
		
	} // End of selectOne()
	
	
	public boolean delete(int number){
		
		boolean success = false;
		
		for(int i=0; i<repository.articles.size(); i++){
			if(number == repository.articles.get(i).getNumber()){
				
				repository.articles.remove(i); // 선택된 배열 삭제
				success = true;
				break;
			}
		}
		
		return success;
			
	} // End of delete()
	
}
