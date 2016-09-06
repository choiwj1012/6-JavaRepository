package productController;

import java.util.ArrayList;

import MainController.Controller;
import mainView.AlertView;
import productDao.ProductDao;
import productView.ProductRegisterView;
import productView.ProductSelectList;
import productView.ProductSelectOneView;
import productVo.Product;

public class ProductController {

	// variable
	private ProductDao productDao;
	
	// constructor
	public ProductController(){
		
		productDao = new ProductDao();
		
	}
	
	
	// ��ǰ ��� ���� ��û�� ó���ϴ� �޼���
	public void requestSelectList(){
		
		// ��ǰ����� �������� (product ���̺�)
		ArrayList<Product> productList = productDao.selectList();
		
		// ��ǰ��� ǥ��
		ProductSelectList productSelectList = new ProductSelectList();
		productSelectList.printProductSelectList(productList);
		
	}
	
	// ��ǰ ��� ��û ó��
	public void requestRegister(){
		
		// ��ǰ ��Ͽ� �ʿ��� ������ ����ϴ� view ����
		ProductRegisterView productRegisterView = new ProductRegisterView();
		Product newProduct = productRegisterView.regist();
		
		// ����� ������ ��ǰ ���̺��� ����ϴ� dao �޼��� ȣ��
		boolean success = productDao.regist(newProduct);
		
		if(success){
			new AlertView().alert("����ǰ ��� ����");
		}else{
			new AlertView().alert("��� ����");
		}
		
		// ��ǰ��� ����� �̵�
		new AlertView().alert("��ǰ ��Ʈ�ѷ� ��ǰ��Ϻ���");
		Controller.getProductController().requestSelectList();
	}


	// ��ǰ ��ȸ ��û ó��
	public void requestSelectOne() {
	
		// ��ǰ ��ȣ�� �Է¹޴� ȭ��
		ProductSelectOneView productSelectOneView = new ProductSelectOneView();
		int searchProductNumber = productSelectOneView.getSearchProductNumber();
	
				
		// ��ǰ ��ȣ�� ���� ��ǰ�� ��� ������ ���ϴ� dao �޼���
		Product searchedProduct = productDao.selectOne(searchProductNumber);
			
		
		// ��ǰ�� ��� ������ ǥ���ϴ� ȭ��
		productSelectOneView.printSearchedProduct(searchedProduct);
		
	}	
	
}