package view;

import java.util.Scanner;

import domain.Article;

public class ArticleUpdateView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public ArticleUpdateView(){
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	// method
	public void articleUpdateView(Article article){
		
		while(true){
			
			System.out.println("수정하고싶은 메뉴를 선택하세요");
			System.out.println("1. 글제목 || 2. 글내용 || 3. 작성자 || 4. 그만수정하기");
			int selectedMenu = keyboard.nextInt();
			
			if(selectedMenu == 1){
				
				System.out.println("수정하고 싶은 글제목을 입력하십시오");
				String title = keyboard.next();
				article.setTitle(title);
				
			} else if(selectedMenu == 2){
				
				System.out.println("수정하고 싶은 글내용을 입력하십시오");
				String content = keyboard.next();
				article.setContent(content);
				
			} else if(selectedMenu == 3){
				
				System.out.println("수정하고 싶은 작성자를 입력하십시오");
				String writer = keyboard.next();
				article.setWriter(writer);
				
			} else if(selectedMenu == 4){
				
				System.out.println("수정을 종료합니다.");
				break;
				
			} else {
				
				System.out.println("잘못선택하셨습니다.");
				
			}
		
		} // End of while
		
	} // End of articleUpdateView()
	
}
