package Robot;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		System.out.println("원하시는 목록을 선택해주세요");
		Scanner keyboard = new Scanner(System.in);
		RobotProcess process = new RobotProcess();
		boolean exit = false;
		
		// 메뉴 선택
		while(!exit){
			
			String[] mainMenu = {"메뉴 선택", "1. 로봇 생성", "2. 로봇 운용", "3. 로봇 정보 수정", "4. 로봇 정보 보기", "5. 전체 로봇 정보 보기", "6. 종료"};
			for(int i=0; i<mainMenu.length; i++){
				System.out.println(mainMenu[i]);
			}
			
			int selectedMenu = keyboard.nextInt();
			
			if(selectedMenu == 1){ // 로봇 생성
				
				System.out.println("로봇 생성합니다");
				process.createRobot();
				
			}else if(selectedMenu == 2){ // 로봇 운용
				
				System.out.println("로봇 운용합니다");
				process.workingRobot();
				
			}else if(selectedMenu == 3){ // 로봇 정보 수정
				
				System.out.println("로봇 정보 수정합니다");
				process.modifyRobotInfo();
				
			}else if(selectedMenu == 4){ // 로봇 정보 보기
				
				System.out.println("로봇 정보 봅니다");
				process.viewRobotInfo();
				
			}else if(selectedMenu == 5){ // 전체 로봇 정보 보기
				
				System.out.println("전체 로봇의 정보를 봅니다");
				process.viewAllRobotInfo();
				
			}else if(selectedMenu == 6){ // 종료
				
				System.out.println("종료합니다");
				exit = true;
				
			}else{ // 잘봇 눌렀을 때
				
				System.out.println("잘못 누르셧습니다");
				
			}
			
		}
		
	}
	
}
