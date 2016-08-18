package ShoppingMall.DAO;

import java.util.ArrayList;
import ShoppingMall.domain.Product;
import ShoppingMall.repository.ProductRepository;

public class ProductDAO {

	// ProductRepository와 ProductDAO 연결
	ProductRepository productRepository;
		
	// constructor
	public ProductDAO(){
		
		this.productRepository = new ProductRepository();
		
	}
	
	// method
	public void insertBasicProduct(Product product) { // 기본 상품 등록
		
		productRepository.lastProductNumber = productRepository.lastProductNumber + 1;
		product.setNumber(productRepository.lastProductNumber);
		productRepository.products.add(product);
		
	} // End of insertBasicProduct
	
	
	public boolean insertProductInProductList(Product product) {
	
		boolean success = false;
		
		productRepository.lastProductNumber = productRepository.lastProductNumber + 1;
		product.setNumber(productRepository.lastProductNumber);
		success = productRepository.products.add(product);
		
		return success;
		
	} // End of insertProductInProductList()
	
	
	public ArrayList<Product> displayProductList() {
		
		return productRepository.products;
		
	} // End of displayProductList()
	
	
	public boolean updateProductList(Product product, int selectedMenu) {
		
		boolean success = false;
		Product product2 = null;
		
		for(int i = 0; i<productRepository.products.size(); i++) {
			if(product.getNumber() == productRepository.products.get(i).getNumber()) {
				product2 = productRepository.products.get(i);
				success = true;
				break;
			}
		}
		
		if(product == null) {
			return success;
		}
		
		if(selectedMenu == 1) {
			product2.setName(product.getName());			
		} else if(selectedMenu == 2) {
			product2.setPrice(product.getPrice());			
		} else if(selectedMenu == 3) {
			product2.setInformation(product.getInformation());			
		}
		
		return success;
		
	} // End of displayProductList()
	
	
	public boolean deleteProductList(int selectedNum){
		
		boolean success = false;
		
		for(int i=0; i<productRepository.products.size(); i++) {
			if(selectedNum == productRepository.products.get(i).getNumber()) {
				productRepository.products.remove(i);
				success = true;
				break;
			}
		}
		
		return success;
		
	} // End of deleteProductList()
	
}
