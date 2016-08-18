package ShoppingMall.controllerAndView;

import java.util.Scanner;

public class MainControllerAndView {

	// variable
	static Scanner keyboard = new Scanner(System.in);
	static private UserControllerAndView userControllerAndView;
	static public ProductControllerAndView productControllerAndView;
	static private CartControllerAndView cartControllerAndView;
	
	// constructor
	public MainControllerAndView(){
		
		MainControllerAndView.userControllerAndView = new UserControllerAndView();
		MainControllerAndView.productControllerAndView = new ProductControllerAndView();
		MainControllerAndView.cartControllerAndView = new CartControllerAndView();
		
	}
	
	
	// method
	
	public void createAdminAndProduct(){
		
		userControllerAndView.insertAdminUser(); // 관리자 계정 삽입
		productControllerAndView.insertBasicProduct(); // 기본 상품정보 삽입
		
	}
	
	
	static public void showStartMenu(){ // 시작메뉴
		
		productControllerAndView.displayProductList(); // 기본 상품정보 출력
		
		boolean exit = false;
		while(!exit){
			
			System.out.println("\n쇼핑몰에 오신것을 환영합니다");
			System.out.println("원하시는 메뉴를 선택해 주세요");
			System.out.println("1. 회원가입하기");
			System.out.println("2. 로그인하기");
			System.out.println("3. 나가기");
			
			int selectedMenu = keyboard.nextInt();
			if(selectedMenu == 1){
				
				userControllerAndView.insertUserInUserList(); // 회원가입하기
				
			} else if(selectedMenu == 2){
				
				userControllerAndView.login(); // 로그인하기
				
			} else if(selectedMenu == 3){
				
				exit = true;
				break;
				
			} else {
				
				System.out.println("번호를 잘못 누르셨습니다.");
				
			}
			
		} // End of while 
		
		System.out.println("시스템을 종료합니다.");
			
	} // End of showStartMenu()
	
	
	static public void mainMenu(){ // 유저 로그인 후 메인메뉴
		
		boolean exit = false;
		while(!exit){
		
			String[] mainMenu = {"쇼핑몰의 메인 메뉴입니다.","메뉴를 선택 하세요","[c]. 구매하기","[m]. 회원정보수정","[r]. 회원정보조회","[o]. 로그아웃","[w]. 회원탈퇴"};
			for(int i=0; i<mainMenu.length; i++){
				System.out.println(mainMenu[i]);
			}
			
			char selectedMenu = keyboard.next().charAt(0);
			switch(selectedMenu){
			
				case 'c' :
					cartControllerAndView.purchase(); // 구매하기
					break;
					
				case 'm' :
					userControllerAndView.updateUserInformation(); // 회원정보수정
					break;
					
				case 'r' :
					userControllerAndView.viewUserInformation(); // 회원정보조회
					break;
					
				case 'o' :
					System.out.println("로그아웃되었습니다.");
					userControllerAndView.userReset(); // 로그인 상태 리셋
					showStartMenu(); // 시작메뉴로 돌아감
					break;
					
				case 'w' :
					userControllerAndView.withdrawMember(); // 회원탈퇴
					break;
					
				default :
					System.out.println("잘못입력했습니다. 다시 입력해주세요");
					
			} // End of switch
			
		} // End of while
		
	} // End of mainMenu() 
	
	
	static public void adminMenu(){ // 관리자 로그인 후 메뉴선택
		
		boolean exit = false;
		while(!exit){
			
			String[] adminMenu = {"관리자 메뉴입니다.","메뉴를 선택 하세요","1. 상품 조회","2. 상품 등록","3. 상품 수정","4. 상품 삭제","5. 메인메뉴로 가기"};
			for(int i=0; i<adminMenu.length; i++){
				System.out.println(adminMenu[i]);
			}
			
			int selectedMain = keyboard.nextInt();
			if(selectedMain == 1){

				productControllerAndView.displayProductList(); // 상품조회

			} else if(selectedMain == 2){

				productControllerAndView.insertProductInProductList(); // 상품등록

			} else if(selectedMain == 3){

				productControllerAndView.updateProductList(); // 상품수정

			} else if(selectedMain == 4){

				productControllerAndView.deleteProductList(); // 상품삭제

			} else if(selectedMain == 5){

				break; // 종료

			} else {

				System.out.println("메뉴를 다시 선택해주세요");

			}
			
		}
		
	} // End of adminMenu()
	
}
