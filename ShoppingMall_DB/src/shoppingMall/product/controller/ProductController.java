package shoppingMall.product.controller;

import java.util.ArrayList;

import shoppingMall.mainController.MainController;
import shoppingMall.product.Dao.ProductDao;
import shoppingMall.product.View.ProductDeleteView;
import shoppingMall.product.View.ProductInsertView;
import shoppingMall.product.View.ProductMenuView;
import shoppingMall.product.View.ProductReadView;
import shoppingMall.product.View.ProductSearchView;
import shoppingMall.product.View.ProductSelectOneView;
import shoppingMall.product.View.ProductUpdateView;
import shoppingMall.product.vo.Product;

public class ProductController {

	// variable
	private ProductDao productDao;

	// constructor
	public ProductController() {

		productDao = new ProductDao();

	}
	
	// method
	// 제품검색
	public void requestSearchProduct() {
		
		// 제품 검색뷰 호출
		ProductSearchView productSearchView = new ProductSearchView();
		productSearchView.productSearch();
		
	}
	
	
	// 선택한 상품을 찾는 요청
	public Product requestSearchProductNumber(int searchProductNumber) {

		// productDao를 통해 productRepository에 데이터 확인
		Product searchProduct = productDao.searchProduct(searchProductNumber);
		
		ProductSelectOneView productSelectOneView = new ProductSelectOneView();
		
		if(searchProduct == null) {
			
			MainController.requestMainAlertView("[!]검색하신 상품이 없습니다.");
			
		} else {
			
			MainController.requestMainAlertView("[!]상품을 찾았습니다.");
			productSelectOneView.selectOneProduct(searchProduct);
		}
		
		return searchProduct;

	}
	

	//제품등록
	public void requestRegisterProduct() {

		//제품 입력뷰 호출
		ProductInsertView productInsertView = new ProductInsertView();
		Product newProduct = productInsertView.productInsertView();

		//productDao를 통해 productRepository에 데이터를 저장.
		boolean success = productDao.registerProduct(newProduct);

		if(success) {

			MainController.requestMainAlertView("[!]정상적으로 등록 되었습니다.");
			requestReadProduct();

		} else {
			
			MainController.requestMainAlertView("[!]제품 등록에 실패 했습니다.");
			
		}

	}

	
	//제품목록 가져오기
	public void requestReadProduct() {

		//productDao를 통해 productRepository에서 데이터 호출
		ArrayList<Product> listAll = productDao.productAll();

		//productView를 호출
		ProductReadView productReadView = new ProductReadView();
		productReadView.productRead(listAll);

	}

	//장바구니와 비교를 위한 제품전체목록 요청
	public ArrayList<Product> requestAllProductList(){
		
		ArrayList<Product> allProductList = productDao.productAll();
		
		return allProductList;
		
	}
	
	
	//삭제할 제품 번호 가져오기
	public void requestGetSelectedProductNumber(int selectedProductNumber) {

		//productDao를 통해 productRepository에 데이터 삭제
		boolean success = productDao.deleteProduct(selectedProductNumber);

		if(success == true) {
			
			MainController.requestMainAlertView("[!]삭제되었습니다.");

		} else {
			
			MainController.requestMainAlertView("[!]삭제를 실패 하였습니다.");

		}
	}

	
	//제품목록 삭제
	public void requestDeleteProductView() {

		//제품 목록에서 제품 선택 View
		ProductDeleteView productDeleteView = new ProductDeleteView();
		productDeleteView.productDelete();

	}

	
	// 제품목록 수정을 위한 번호와 내용 받기
	public void requestUpdateProductInfo() {

		//제품 목록에서 수정할 제품 선택 View
		ProductUpdateView productUpdateView = new ProductUpdateView();
		productUpdateView.productUpdate();

	}

	
	// 수정할 제품번호 받아서 수정요청
	public void requestUpdateProduct(int selectedProductNumber, Product updateProduct){
		
		Product selectedProduct = productDao.searchProduct(selectedProductNumber);
		
		if(selectedProduct == null){
			
			MainController.requestMainAlertView("선택하신 상품이 없습니다");
			return;
			
		}
		
		boolean success = productDao.updateProduct(selectedProductNumber, updateProduct);
		
		if(success){
			
			MainController.requestMainAlertView("수정에 성공하였습니다");
			
		} else {
			
			MainController.requestMainAlertView("수정에 실패하였습니다");
			
		}
		
	}
	

	// 관리자 상품관리메뉴뷰 요청
	public void requestProductMenuView() {

		ProductMenuView productMenuView = new ProductMenuView();
		productMenuView.productMenuView();

	}

}
