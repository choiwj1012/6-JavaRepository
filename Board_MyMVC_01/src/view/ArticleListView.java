package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import domain.Article;

public class ArticleListView {

	public void articleListView(ArrayList<Article> articles) {

		System.out.println("글번호\t글제목\t글작성자\t작성일\t\t\t조회수");

		if(articles.size() == 0){
			System.out.println("\n 글이 하나도 없습니다 \n");
		}

		for(int i=0; i<articles.size(); i++){
			System.out.print(articles.get(i).getNumber() + "\t");
			System.out.print(articles.get(i).getTitle() + "\t");
			System.out.print(articles.get(i).getWriter() + "\t");

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd H:mm:ss");
			String str = dateFormat.format(articles.get(i).getWriteDate());
			System.out.print(str + "\t");
			System.out.println(articles.get(i).getReadCount());
		}

	} // End of articleListView()

	
	public void printSelectView(Article article){

		if(article == null){
			System.out.println("\n 선택하신 글은 없습니다 \n");
			return;
		}

		System.out.println("글번호 : " + article.getNumber());
		System.out.println("글제목 : " + article.getTitle());
		System.out.println("작성자 : " + article.getWriter());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd H:mm:ss");
		String str = dateFormat.format(article.getWriteDate());
		System.out.println("작성일 : " + str + "\t");
		System.out.println("조회수 : " + article.getReadCount());

		article.setReadCount(article.getReadCount() + 1);
		
	} // End of printSelectView()

}
