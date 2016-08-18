package ShoppingMall.controllerAndView;

import java.util.ArrayList;
import java.util.Scanner;

import ShoppingMall.DAO.ProductDAO;
import ShoppingMall.domain.Product;

public class ProductControllerAndView {
	
	// variable
	public Scanner keyboard = new Scanner(System.in);
	public ProductDAO productDAO;
	
	// constructor
	public ProductControllerAndView(){
		
		this.productDAO = new ProductDAO();
		
	}
	
	// method
	public void insertBasicProduct() { // 기본 상품 등록

		Product product;
		
		product = new Product("TV1", 100000, "기본TV");
		productDAO.insertBasicProduct(product);
		
		product = new Product("폰1", 200000, "기본Phone");
		productDAO.insertBasicProduct(product);
		
		product = new Product("컴퓨터1", 300000, "기본Computer");
		productDAO.insertBasicProduct(product);	

	} // End of insertBasicProduct()
	
	
	public void insertProductInProductList() { // 상품등록
		
		boolean success = false;
		
		System.out.println("등록할 상품 정보를 입력하세요.");

		System.out.print("상품 이름 : ");
		String name = keyboard.next();

		System.out.print("상품 가격 : ");
		int price = keyboard.nextInt();

		System.out.print("상품 정보 : ");
		String information = keyboard.next();

		// 입력받은 상품이름, 상품가격, 상품정보를 담은 인스턴스 생성
		Product newProduct = new Product(name, price, information);
		success = productDAO.insertProductInProductList(newProduct);
		
		if(success) {
			
			System.out.println("상품이 등록되었습니다.");
			
		} else {
			
			System.out.println("상품 등록에 실패하였습니다.");
			
		}		

	} // End of insertProductInProductList()
	
	
	public void displayProductList() { // 등록된 상품 리스트 보여주기 
		
		ArrayList<Product> products = productDAO.displayProductList();
		
		System.out.println("번호\t상품명\t가격\t정보");
		for(int i = 0; i < products.size() ; i++) {
			System.out.print(products.get(i).getNumber() + "\t");
			System.out.print(products.get(i).getName() + "\t");
			System.out.print(products.get(i).getPrice() + "\t");
			System.out.println(products.get(i).getInformation());
		}

	} // End of displayProductList()
	
	
	public void updateProductList() { // 상품수정

		boolean exit = false;

		while(!exit) {
			
			displayProductList(); // 상품리스트 보여주기

			System.out.println("수정할 상품의 번호를 입력하세요. 나가시려면 0를 누르세요");
			int selectedNum = keyboard.nextInt();

			if(selectedNum == 0){
				break;
			}
			
			System.out.println("수정하고 싶은 메뉴를 입력하세요. (1)상품명 (2)상품가격 (3)상품정보 (4)나가기");
			int selectedMenu = keyboard.nextInt();

			Product product = new Product();
			product.setNumber(selectedNum);

			switch(selectedMenu) {

			case 1:

				System.out.println("수정할 상품명을 입력해주세요.");
				String updateProductName = keyboard.next();	
				product.setName(updateProductName);
				productDAO.updateProductList(product, selectedMenu);
				break;

			case 2:

				System.out.println("수정할 상품가격을 입력해주세요.");
				int updateProductPrice = keyboard.nextInt();
				product.setPrice(updateProductPrice);
				productDAO.updateProductList(product, selectedMenu);
				break;

			case 3:

				System.out.println("수정할 상품정보를 입력해주세요.");
				String updateProductInformation = keyboard.next();
				product.setInformation(updateProductInformation);
				productDAO.updateProductList(product, selectedMenu);
				break;

			case 4: 

				System.out.println("관리자메뉴로 돌아갑니다.");
				exit = true;
				MainControllerAndView.adminMenu();
				break;

			default:
				System.err.println("잘못입력하셨습니다. 다시 입력해주세요.");

			} // End of switch
			
		} // End of while

	} // End of updateProductList()
	
	
	public void deleteProductList() { // 상품삭제

		displayProductList(); // 상품리스트 출력

		boolean exit = false;
		
		while(!exit) {

			System.out.println("삭제할 상품의 번호를 입력하세요.");
			int selectedNum = keyboard.nextInt();
			boolean success = productDAO.deleteProductList(selectedNum);
			
			if(!success){
				System.out.println("그런 물건이 없습니다");
			} else {
				System.out.println("물건이 삭제되었습니다");
			}
			
			System.out.println("(1) 상품계속삭제 (2) 나가기");
			int selectedMenu = keyboard.nextInt();

			switch(selectedMenu) {

			case 1:

				break;

			case 2:

				System.out.println("관리자메뉴로 돌아갑니다.");
				MainControllerAndView.adminMenu();
				break;

			default:

				System.err.println("잘못입력하셨습니다. 다시 입력해주세요.");

			}
		}

	} // End of deleteProductList()

}