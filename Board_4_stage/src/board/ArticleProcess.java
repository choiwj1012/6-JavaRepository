package board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ArticleProcess {
	private Scanner keyboard = new Scanner(System.in);
	Article article = new Article();

	public void write() {

		System.out.println("게시글 쓰기 모드");			

		if(ArticleRepository.lastArticlePosition == ArticleRepository.MAX_ARTICLE_COUNT) {
			System.out.println("저장소에 빈공간이 없습니다.");
		} else {
			//게시글 정보 : 번호(자동), 제목, 내용, 작성자, 조회수(자동)
			System.out.print("제    목 : ");
			String title = keyboard.next();
			System.out.print("내    용 : ");
			String content = keyboard.next();
			System.out.print("작 성 자 : ");
			String writer = keyboard.next();

			ArticleRepository.articles[ArticleRepository.lastArticlePosition] = new Article(title, content, writer, new Date());
			ArticleRepository.articles[ArticleRepository.lastArticlePosition].setNumber(ArticleRepository.lastArticlePosition + 1);

			ArticleRepository.lastArticlePosition = ArticleRepository.lastArticlePosition + 1;		
		}

	}

	public void list() {

		System.out.println("게시글 목록 모드");				
		System.out.println("번호\t제목\t작성자\t작성시간\t\t\t조회수");
		if(ArticleRepository.lastArticlePosition == 0) {
			System.out.println("등록된 글이 없습니다.");
		} else {
			for(int i = 0 ; i < ArticleRepository.lastArticlePosition ; i++) {
				System.out.print(ArticleRepository.articles[i].getNumber() + "\t");
				System.out.print(ArticleRepository.articles[i].getTitle() + "\t");
				System.out.print(ArticleRepository.articles[i].getWriter() + "\t");
				String dateStr = time(i);
				System.out.print(dateStr + "\t");
				System.out.println(ArticleRepository.articles[i].getReadCount());
			}
		}

	}

	public void read() {

		System.out.println("게시글 조회 모드");

		if(ArticleRepository.lastArticlePosition == 0) {
			System.out.println("등록된 글이 없습니다.");
		} else {
			System.out.print("조회 번호 : ");
			int number = keyboard.nextInt();

			boolean isFind = false;
			for(int i = 0 ; i < ArticleRepository.lastArticlePosition ; i++) {
				if(number == ArticleRepository.articles[i].getNumber()) {
					ArticleRepository.articles[i].setReadCount(ArticleRepository.articles[i].getReadCount() + 1);

					System.out.println("번    호 : " + ArticleRepository.articles[i].getNumber());
					System.out.println("제    목 : " + ArticleRepository.articles[i].getTitle());
					System.out.println("내    용 : " + ArticleRepository.articles[i].getContent());
					System.out.println("작 성 자 : " + ArticleRepository.articles[i].getWriter());		
					String dateStr = time(i);
					System.out.println("날    짜 : " + dateStr);
					System.out.println("조 회 수 : " + ArticleRepository.articles[i].getReadCount());

					isFind = true;
					break;
				}
			}

			if(isFind == false) {
				System.out.println("조회한 글이 없습니다.");
			}
		}

	}

	public void update() {

		System.out.println("게시글 수정 모드");
		if(ArticleRepository.lastArticlePosition == 0) {
			System.out.println("등록된 글이 없습니다.");
		} else {
			System.out.print("조회 번호 : ");
			int number = keyboard.nextInt();

			boolean isFind = false;
			for(int i = 0 ; i < ArticleRepository.lastArticlePosition ; i++) {
				if(number == ArticleRepository.articles[i].getNumber()) {
					ArticleRepository.articles[i].setReadCount(ArticleRepository.articles[i].getReadCount() + 1);

					while(true) {
						System.out.println("수정 항목 선택");
						System.out.println("1. 제목");
						System.out.println("2. 내용");
						System.out.println("3. 작성자");
						System.out.println("4. 취소");

						int updateMenu = keyboard.nextInt();

						if(updateMenu == 1) {
							
							System.out.println("제목 수정 모드");
							System.out.print("수정할 제목 : ");
							String title = keyboard.next();									
							ArticleRepository.articles[i].setTitle(title);
							ArticleRepository.articles[i].setDate(new Date());
							
						} else if(updateMenu == 2) {
							
							System.out.println("내용 수정 모드");
							System.out.print("수정할 내용 : ");
							String content = keyboard.next();									
							ArticleRepository.articles[i].setContent(content);
							ArticleRepository.articles[i].setDate(new Date());
							
						} else if(updateMenu == 3) {
							
							System.out.println("작성자 수정 모드");
							System.out.print("수정할 작성자 : ");
							String  writer = keyboard.next();									
							ArticleRepository.articles[i].setWriter(writer);
							ArticleRepository.articles[i].setDate(new Date());
							
						} else if(updateMenu == 4) {
							System.out.println("수정 취소");
							break;
						}  else {
							System.out.println("수정할 항목을 다시 선택해 주세요.");
						}				

					}

					isFind = true;
					break;
				}
			}

			if(isFind == false) {
				System.out.println("조회한 글이 없습니다.");
			}
		}

	}
	
	public String time(int i){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd.H.mm.ss");
		Date date = ArticleRepository.articles[i].getDate();
		String dateStr = format.format(date);
		return dateStr;
		
	}
	
}
