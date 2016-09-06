package view;

import java.util.ArrayList;

import domain.Article;

public class ArticleListView {

	// 글목록 전체 출력
	public void listView(ArrayList<Article> articles){
		
		System.out.println("글번호\t글제목\t글내용\t작성자\t작성일\t\t조회수");
		
		for(int i=0; i<articles.size(); i++){
			
			System.out.print(articles.get(i).getArticleNumber() + "\t");
			System.out.print(articles.get(i).getTitle() + "\t");
			System.out.print(articles.get(i).getContent() + "\t");
			System.out.print(articles.get(i).getWriter() + "\t");
			System.out.print(articles.get(i).getWriteDate() + "\t");
			System.out.println(articles.get(i).getReadCount());
			
		}
		
	} // End of listView()
	
}
