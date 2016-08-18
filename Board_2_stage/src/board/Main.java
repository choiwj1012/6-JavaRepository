package board;

import java.util.Scanner;

public class Main {

	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args){
		
		
		Article[] articles = new Article[Article.MAX_ARTICLE_COUNT]; // 배열 선언
		int lastArticlePosition = 0;
		
		boolean exit = false;
		while(!exit){
			
			String[] mainMenu = {"메인 메뉴 목록", "1. 게시글 쓰기", "2. 게시글 목록", "3. 게시글 조회", "4. 게시글 수정", "5. 프로그램 종료"};
			for(int i=0; i<mainMenu.length; i++){
				System.out.println(mainMenu[i]);
			}
			
			int selectedMenu = keyboard.nextInt();
			
			if(selectedMenu == 1){
				System.out.println("게시글 쓰기 모드");
				
				if(lastArticlePosition == Article.MAX_ARTICLE_COUNT){
					
					System.out.println("저장소에 빈 공간이 없습니다");
				
				} else {
				
					System.out.println("제  목 : ");
					String title = keyboard.next();
					System.out.println("내  용 : ");
					String content = keyboard.next();
					System.out.println("작성자 : ");
					String writer = keyboard.next();
					
					articles[lastArticlePosition] = new Article(title, content, writer);
					articles[lastArticlePosition].setNumber(lastArticlePosition + 1);
					lastArticlePosition = lastArticlePosition + 1;
					
				}
				
			} else if(selectedMenu == 2){
				System.out.println("게시글 목록 모드");
				System.out.println("번호\t제목\t작성자\t조회수");
				
				if(lastArticlePosition==0){
				
					System.out.println("등록된 글이 없습니다");
				
				} else {
					
					for(int i=(lastArticlePosition-1); i>-1; i--){
						System.out.print(articles[i].getNumber() + "\t");
						System.out.print(articles[i].getTitle() + "\t");
						System.out.print(articles[i].getContent() + "\t");
						System.out.println(articles[i].getReadCount());
					}
				}
				
			} else if(selectedMenu == 3){
				System.out.println("게시글 조회 모드");
				
				if(lastArticlePosition == 0){
					System.out.println("등록된 글이 없습니다");
				} else {
					System.out.print("조회 번호 : ");
					int number = keyboard.nextInt();
					
					boolean isFind = false;
					for(int i=0; i<lastArticlePosition; i++){
						if(number == articles[i].getNumber()){
							articles[i].setReadCount(articles[i].getReadCount() + 1);
							
							System.out.println("번  호 : " + articles[i].getNumber());
							System.out.println("제  목 : " + articles[i].getTitle());
							System.out.println("내  용 : " + articles[i].getContent());
							System.out.println("작성자 : " + articles[i].getWriter());
							System.out.println("조회수 : " + articles[i].getReadCount());
							
							isFind = true;
							break;
						}
					}
					
					if(isFind == false){
						System.out.println("조회한 글이 없습니다");
					}
				
				}
				
			} else if(selectedMenu == 4){
				System.out.println("게시글 수정 모드");
				
				if(lastArticlePosition == 0){
					System.out.println("등록된 글이 없습니다");
				} else {
					
					System.out.println("조회 번호 : ");
					int number = keyboard.nextInt();
					
					boolean isFind = false;
					for(int i=0; i<lastArticlePosition; i++){
						if(number == articles[i].getNumber()){
							articles[i].setReadCount(articles[i].getReadCount() + 1);
							
							while(true){
								System.out.println("수정 항목 선택");
								System.out.println("1. 제목");
								System.out.println("2. 내용");
								System.out.println("3. 작성자");
								System.out.println("4. 취소");
								
								int updateMenu = keyboard.nextInt();
								
								if(updateMenu == 1){
									System.out.println("제목 수정 모드");
									System.out.print("수정할 제목 : ");
									String title = keyboard.next();
									articles[i].setTitle(title);
								} else if(updateMenu == 2){
									System.out.println("내용 수정 모드");
									System.out.println("수정할 제목 : ");
									String content = keyboard.next();
									articles[i].setContent(content);
								} else if(updateMenu == 3){
									System.out.println("작성자 수정 모드");
									System.out.println("수정할 작성자 : ");
									String writer = keyboard.next();
									articles[i].setWriter(writer);
								} else if(updateMenu == 4){
									System.out.println("수정 취소 ");
									break;
								} else {
									System.out.println("수정 할목을 다시 선택해 주세요");
								}
								
							}
							isFind = true;
							break;
						}
					}
					
					if(isFind == false){
						System.out.println("조회한 글이 없습니다");
					}
					
				}
				
			} else if(selectedMenu == 5){
				exit = true;
			
			} else {
				System.out.println("메뉴를 다시 선택해 주세요");
			
			}
			
		}
		
		System.out.println("프로그램 종료");
	}
	
}
