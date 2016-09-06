package productDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MainController.Controller;
import productVo.Product;

public class ProductDao {


	// variable



	// constructor
	public ProductDao() {


	}


	// 제품 목록 보기를 위한 dao 메서드
	public ArrayList<Product> selectList() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Product> productList = new ArrayList<Product>();

		try {
			stmt = Controller.getProgramController().getConn().createStatement();
			String sql = "select * from product";
			rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				Product product = new Product();
				product.setProductNumber(rs.getInt("productNumber"));
				product.setProductName(rs.getString("productName"));
				product.setProductComment(rs.getString("productComment"));
				product.setProductPrice(rs.getInt("productPrice"));
				product.setProductVendorName(rs.getString("productVendorName"));
				productList.add(product);
			}

		} catch (SQLException e) {
			System.out.println("제품 목록보기에서 예외 발생");
			e.printStackTrace();

		} finally {
			if(rs != null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}			
			}
			if(stmt != null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


		return productList;
	}

	
	// 제품 등록을 위한 메서드
	public boolean regist(Product newProduct) {
		
		boolean success = false;
		int nextProductNumber = 0;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
			//현재 제품 테이블에 있는 마지막 제품의 제품 번호를 읽어와서 +1을 한 nextProductNumber를 설정
			String sql = "select max(productNumber)+1 as \"MaxProductNumber\" from product";
			stmt = Controller.getProgramController().getConn().createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				nextProductNumber = rs.getInt("MaxProductNumber");
				if(rs.wasNull()){ // 최초로 제품을 등록할 떄
					nextProductNumber = 1;
				}
			}
			
			// 제품번호 등록
			newProduct.setProductNumber(nextProductNumber);
			
			// 제품등록
			sql = "insert into product values(?,?,?,?,?)";
			pstmt = Controller.getProgramController().getConn().prepareStatement(sql);
			pstmt.setInt(1, newProduct.getProductNumber());
			pstmt.setString(2, newProduct.getProductName());
			pstmt.setString(3, newProduct.getProductComment());
			pstmt.setInt(4, newProduct.getProductPrice());
			pstmt.setString(5, newProduct.getProductVendorName());
			int result = pstmt.executeUpdate();
			
			if(result != 0){
				success = true;
			}
			
		} catch(SQLException e) {
			System.out.println("제품등록중 예외발생");
			e.printStackTrace();
		} finally {
			
			if(pstmt != null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}			
			}
			
			if(rs != null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(stmt != null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}
		
		return success;
	}


	public Product selectOne(int searchProductNumber) {
		
		Product searchedProduct = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
			String sql = "select * from product where productNumber = ?";
			pstmt = Controller.getProgramController().getConn().prepareStatement(sql);
			pstmt.setInt(1, searchProductNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				searchedProduct = new Product();
				searchedProduct.setProductNumber(rs.getInt("productNumber"));
				searchedProduct.setProductName(rs.getString("productName"));
				searchedProduct.setProductComment(rs.getString("productComment"));
				searchedProduct.setProductPrice(rs.getInt("productPrice"));
				searchedProduct.setProductVendorName(rs.getString("productVendorName"));
				
			}
			
		} catch(SQLException e) {
			
			System.out.println("제품조회 예외발생");
			e.printStackTrace();
			
		} finally {
			
			if(rs != null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt != null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}			
			}
			
		}
		
		
		return searchedProduct;
	}

}
