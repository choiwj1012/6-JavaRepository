package board;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		ArticleProcess process = new ArticleProcess();
		
		boolean exit = false;
		while(!exit) {
			//게시글 쓰기, 게시글 목록, 게시글 조회, 게시글 수정
			System.out.println("메인 메뉴 목록");
			System.out.println("1. 게시글 쓰기");
			System.out.println("2. 게시글 목록");
			System.out.println("3. 게시글 조회");
			System.out.println("4. 게시글 수정");
			System.out.println("5. 프로그램 종료");
			
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1) {	//게시글 쓰기
				process.write();
			} else if(selectedMenu == 2) { //게시글 목록			
				process.list();				
			} else if(selectedMenu == 3) {
				process.read();
			} else if(selectedMenu == 4) {
				process.update();
			} else if(selectedMenu == 5) {
				exit = true;
			} else {
				System.out.println("메뉴를 다시 선택해 주세요.");
			}

		}

		System.out.println("프로그램 종료");		

	}
}
