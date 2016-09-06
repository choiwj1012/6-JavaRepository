package shoppingMall.Login.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shoppingMall.Login.Vo.Login;

public class LoginDao {

	private Connection conn;
	
	// constructor
	public LoginDao(){

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}


	// 로그인
	public int login(Login login){
		
		int loginUserNumber = -1;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			String sql = "select userId, userPw from userinfo where userId = ? and userPassword = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login.getUserID());
			pstmt.setString(2, login.getUserPW());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				sql = "insert into loginInfo values (";
				sql += login.getUserID() + ",";
				sql += login.getUserPW() + ")";
				loginUserNumber = 2;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return success;
		
	}


//	// 로그인상태 체크
//	public boolean checkLogin(){
//
//		boolean success = false;
//
//		FileReader loginFileReader = null;
//		BufferedReader loginBufferedReader = null;
//
//		try{
//
//			loginFileReader = new FileReader(loginFile);
//			loginBufferedReader = new BufferedReader(loginFileReader);
//			String loginString = loginBufferedReader.readLine();
//
//			if(loginString == null){
//				return success;
//			} 
//
//		} catch(FileNotFoundException e) {
//
//			e.printStackTrace();
//
//		} catch(IOException e) {
//
//			e.printStackTrace();
//
//		} finally {
//
//			try{
//
//				loginBufferedReader.close();
//				loginFileReader.close();
//
//			} catch(IOException e) {
//
//				e.printStackTrace();
//
//			}
//
//		}
//
//		success = true;
//		return success;
//
//	}
//
//
//	// 로그아웃
//	public boolean logOut(){
//
//		boolean success = false;
//
//		loginFile.delete();
//
//		success = true;
//
//		File file = new File("order.txt");
//		file.delete();
//
//		return success;	
//
//	}

}
