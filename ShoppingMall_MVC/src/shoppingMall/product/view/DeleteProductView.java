package shoppingMall.product.view;

import shoppingMall.product.vo.Product;

public class DeleteProductView {

	public Product deleteProductView(int selectedNum){
	
		Product deleteProduct = new Product();
		
		deleteProduct.setNumber(selectedNum);
		
		return deleteProduct;
		
	} // End of deleteProductView()

}
