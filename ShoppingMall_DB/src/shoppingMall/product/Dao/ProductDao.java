package shoppingMall.product.Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import shoppingMall.product.vo.Product;

public class ProductDao {

	private File file;

	public ProductDao() {

		file = new File("product.txt");

		try{

			boolean newFile = file.createNewFile();

			if(newFile){
				System.out.println("파일생성");
			} else {
				System.out.println("파일존재");
			}

		} catch (IOException e) {
			System.out.println("실패");
			e.printStackTrace();
		}

	}


	// 상품등록
	public boolean registerProduct(Product newProduct) {

		boolean success = false;

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		try{

			fileWriter = new FileWriter(file,true);
			bufferedWriter = new BufferedWriter(fileWriter);

			int productNumber = productLastPosition() + 1;
			newProduct.setProductNumber(productNumber);

			bufferedWriter.write(newProduct.getProductNumber() + ",");
			bufferedWriter.write(newProduct.getProductName() + ",");
			bufferedWriter.write(newProduct.getProductPrice() + ",");
			bufferedWriter.write(newProduct.getProductBrandName() + ",");
			bufferedWriter.write(newProduct.getProductColor() + "\r\n");

			success = true;

			return success;

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {

			try{

				bufferedWriter.close();
				fileWriter.close();

			} catch(IOException e){

				e.printStackTrace();

			}

		}

		return success;

	}


	// 상품전체목록 가져오기
	public ArrayList<Product> productAll() {

		ArrayList<Product> listAll = new ArrayList<Product>();
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try{

			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			while(true){

				String productString = bufferedReader.readLine();

				if(productString == null){
					break;
				}

				StringTokenizer stringTokenizer = new StringTokenizer(productString, ",");

				while(stringTokenizer.hasMoreTokens()){
					int number = Integer.parseInt(stringTokenizer.nextToken());
					String productName = stringTokenizer.nextToken();
					int productPrice = Integer.parseInt(stringTokenizer.nextToken());
					String productBrandName = stringTokenizer.nextToken();
					String productColor = stringTokenizer.nextToken();

					Product product = new Product(number,productName,productPrice,productBrandName,productColor);
					listAll.add(product);
				}	

			}

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {

			try{
				bufferedReader.close();
				fileReader.close();
			}catch(IOException e){
				e.printStackTrace();
			}

		}

		return listAll;

	} 


	// 선택상품찾기
	public Product searchProduct(int searchProductNumber) {

		Product product = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try{

			File file = new File("product.txt");
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			while(true){
				String productString = bufferedReader.readLine();

				if(productString == null){
					break;
				}

				StringTokenizer stringTokenizer = new StringTokenizer(productString, ",");

				if(stringTokenizer.hasMoreTokens()){
					int number = Integer.parseInt(stringTokenizer.nextToken());

					if(searchProductNumber == number){
						product = new Product();

						product.setProductNumber(number);
						String productName = stringTokenizer.nextToken();
						product.setProductName(productName);
						int productPrice = Integer.parseInt(stringTokenizer.nextToken());
						product.setProductPrice(productPrice);
						String productBrandName = stringTokenizer.nextToken();
						product.setProductBrandName(productBrandName);
						String productColor = stringTokenizer.nextToken();
						product.setProductColor(productColor);

						break;
					}
				}
			}

		}catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				bufferedReader.close();
				fileReader.close();

			} catch (IOException e) {

			}
		}		

		return product;

	}


	// 선택상품 수정
	public boolean updateProduct(int selectedProductNumber, Product updateProduct){

		boolean success = false;

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		ArrayList<Product> products = productAll();

		for(int i =0; i<products.size(); i++){
			if(selectedProductNumber == products.get(i).getProductNumber()){
			
				
			
				products.get(i).setProductName(updateProduct.getProductBrandName());
				products.get(i).setProductPrice(updateProduct.getProductPrice());
				products.get(i).setProductBrandName(updateProduct.getProductBrandName());
				products.get(i).setProductColor(updateProduct.getProductColor());
				
				success = true;
				
			}
		}

		this.productToFile(products);
		return success;

		}


		//선택상품 삭제
		public boolean deleteProduct(int selectedProductNumber) {

			boolean success = false;
			ArrayList<Product> products = productAll();

	
				for(int i=0; i<products.size(); i++){
					if( selectedProductNumber== products.get(i).getProductNumber()){

						products.remove(i);
						success = true;
						break;

					}
				}

				this.productToFile(products);

			return success;

		}

		public int productLastPosition(){

			int lastProductNumber = 0;

			FileReader fileReader = null;
			BufferedReader bufferedReader = null;

			try{

				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);

				while(true){

					String productString = bufferedReader.readLine();

					if(productString == null){
						break;
					}

					StringTokenizer stringTokenizer = new StringTokenizer(productString, ",");

					if(stringTokenizer.hasMoreTokens()){
						lastProductNumber = Integer.parseInt(stringTokenizer.nextToken());
						stringTokenizer.nextToken();
						stringTokenizer.nextToken();
						stringTokenizer.nextToken();
						stringTokenizer.nextToken();
					}	

				}

			} catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			} finally {

				try{
					bufferedReader.close();
					fileReader.close();
				}catch(IOException e){
					e.printStackTrace();
				}

			}

			return lastProductNumber;

		}

		private void productToFile(ArrayList<Product> products) {

			FileWriter fileWriter = null;
			BufferedWriter bufferedWriter = null;

			try {
				File file = new File("product.txt");
				fileWriter = new FileWriter(file);
				bufferedWriter = new BufferedWriter(fileWriter);

				for(int i = 0 ; i < products.size() ; i++) {
					bufferedWriter.write(products.get(i).getProductNumber()+ ",");
					bufferedWriter.write(products.get(i).getProductName()+ ",");
					bufferedWriter.write(products.get(i).getProductPrice() + ",");
					bufferedWriter.write(products.get(i).getProductBrandName() + ",");
					bufferedWriter.write(products.get(i).getProductColor() + "\r\n");
					
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					bufferedWriter.close();
					fileWriter.close();
				} catch(IOException e) {}
			}

		}
	
		
	}
