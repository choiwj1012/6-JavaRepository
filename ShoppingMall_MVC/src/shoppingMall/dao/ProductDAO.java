package shoppingMall.dao;

import java.util.ArrayList;

import shoppingMall.repository.ProductRepository;
import shoppingMall.vo.Product;

public class ProductDAO {

	// variable
	ProductRepository productRepository;
	
	// constructor
	public ProductDAO(){
		
		this.productRepository = new ProductRepository();
	}
	
	
	// method
	public void addProduct(Product product){ // 제품 등록 
		
		productRepository.setLastProductPosition(productRepository.getLastProductPosition() + 1);  
		product.setNumber(productRepository.getLastProductPosition());
		productRepository.getProduct().add(product);
		
	} // End of addProduct()
	
	
	public ArrayList<Product> selectAllProduct(){ // 전체 제품 리스트 선택
		
		ArrayList<Product> products = productRepository.getProduct();
		
		return products;
		
	} // End of selectAllProduct()
	
	
	public void updateProduct(Product updateProduct){ // 제품 수정
	
		for(int i=0; i<productRepository.getProduct().size(); i++){
			if(updateProduct.getNumber() == productRepository.getProduct().get(i).getNumber()){
			
				if(updateProduct.getName() != null){
					productRepository.getProduct().get(i).setName(updateProduct.getName());	
				}
				
				if(updateProduct.getPrice() != 0){
					productRepository.getProduct().get(i).setPrice(updateProduct.getPrice());	
				}
				
				if(updateProduct.getInformation() != null){
					productRepository.getProduct().get(i).setInformation(updateProduct.getInformation());	
				}
				 
			}
		}
		
	} // End of updateProductInfo()
	
	
	public boolean deleteProduct(Product deleteProduct){ // 제품 삭제
		
		boolean success = false;
		
		for(int i=0; i<productRepository.getProduct().size(); i++){
			if(deleteProduct.getNumber() == productRepository.getProduct().get(i).getNumber()){
				
				productRepository.getProduct().remove(i);
				success = true;
				break;
				
			}
			
		}
		
		return success;
		
	} // End of deleteProduct()
	
}
