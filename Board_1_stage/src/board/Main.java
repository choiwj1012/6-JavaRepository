package board;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){

		// 게시글 정보 : 번호, 제목, 내용, 작성자, 조회수
		// 게시판 기능 : 게시글 쓰기, 게시글 조회, 게시글 수정, 게시글 목록, 게시글 삭제
		Scanner keyboard = new Scanner(System.in);	
		final int MAX_ARTICLE_COUNT = 5;
		int[] numbers = new int[MAX_ARTICLE_COUNT]; // 글 번호
		String[] titles = new String[MAX_ARTICLE_COUNT]; // 글 제목
		String[] contents = new String[MAX_ARTICLE_COUNT]; // 글 내용
		String[] writers = new String[MAX_ARTICLE_COUNT]; // 글 작성자
		int[] readCounts = new int[MAX_ARTICLE_COUNT]; // 조회수

		int lastArticlePosition = 0;

		boolean exit = false;
		while(!exit){

			// 게시글 쓰기, 게시글 목록, 게시글 조회, 게시글 수정
			System.out.println("메인 메뉴 목록");
			System.out.println("1. 게시글 쓰기");
			System.out.println("2. 게시글 목록");
			System.out.println("3. 게시글 조회");
			System.out.println("4. 게시글 수정");
			System.out.println("5. 프로그램 종료");

			// 목록선택
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1){ // 게시글 쓰기 모드
				System.out.println("게시글 쓰기 모드");

				if(lastArticlePosition == MAX_ARTICLE_COUNT){

					System.out.println("저장소에 빈 공간이 없습니다");

				} else {

					System.out.println("제목 : ");       
					String title = keyboard.next();   // 제목 입력 
					System.out.println("내용 : ");   
					String content = keyboard.next(); // 내용 입력
					System.out.println("작성자 : ");
					String writer = keyboard.next();  // 작성자 입력

					numbers[lastArticlePosition] = lastArticlePosition + 1; // 글 번호 1 증가
					titles[lastArticlePosition] = title; // 글 제목 입력
					contents[lastArticlePosition] = content; // 글 내용 입력
					writers[lastArticlePosition] = writer; // 글 작성자 입력
					readCounts[lastArticlePosition] = 0; // 조회수 

					lastArticlePosition = lastArticlePosition + 1; // 글갯수 1 증가

				} // if end

			} else if(selectedMenu == 2) { // 게시글목록

				System.out.println("게시글 목록 모드");
				System.out.println("번호\t제목\t작성자\t조회수");
				if(lastArticlePosition == 0){

					System.out.println("등록된 글이 없습니다");

				} else {

					for(int i=(lastArticlePosition-1); i>-1; i--){

						System.out.print(numbers[i] + "\t"); // 글번호 출력
						System.out.print(contents[i] + "\t"); // 글내용 출력
						System.out.print(writers[i] + "\t"); // 글작성자 출력
						System.out.println(readCounts[i]); // 조회수 출력

					} // for end

				} // if end

			} else if (selectedMenu == 3) {

				System.out.println("게시글 조회 모드");

				if(lastArticlePosition == 0){

					System.out.println("등록된 글이 없습니다");

				} else {

					System.out.println("조회 번호 : ");
					int number = keyboard.nextInt();

					boolean isFind = false;
					for(int i=0; i<lastArticlePosition; i++){
						if(number == numbers[i]){
							readCounts[i] = readCounts[i] + 1;

							System.out.println("번  호 : " + numbers[i]);
							System.out.println("제  목 : " + titles[i]);
							System.out.println("내  용 : " + contents[i]);
							System.out.println("작성자 : " + writers[i]);
							System.out.println("조회수 : " + readCounts[i]);

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
					for(int i = 0; i < lastArticlePosition; i++){

						if(number == numbers[i]){

							readCounts[i] = readCounts[i] + 1; // 조회수 증가

							while(true){

								String[] menu = {"수정 항목 선택", "1. 제목","2. 내용","3. 작성자","4. 취소"};
								for(int j=0; j<menu.length; j++){
									System.out.println(menu[j]);
								}

								int updateMenu = keyboard.nextInt();

								if(updateMenu == 1){
									System.out.println("제목 수정 모드");
									System.out.println("수정할 제목 : ");
									String title = keyboard.next();
									titles[i] = title;
								} else if(updateMenu == 2){
									System.out.println("내용 수정 모드");
									System.out.println("수정할 내용 : ");
									String content = keyboard.next();
									contents[i] = content;
								} else if(updateMenu == 3){
									System.out.println("작성자 수정 모드");
									System.out.println("수정할 작성자 : ");
									String writer = keyboard.next();
									writers[i] = writer;
								} else if(updateMenu == 4){
									System.out.println("수정 취소");
									break;
								} else {
									System.out.println("수정할 항목을 다시 선택해 주세요");
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
