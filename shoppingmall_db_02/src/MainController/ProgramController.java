package MainController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProgramController {

	// variable
	private Connection conn;
	
	// constructor
	public ProgramController() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연결 실패");
		}
		
	}
	
	// method
	// DB 연결
	public Connection getConn() {
		
		return conn;
		
	}
	
	// 프로그램 종료
	public void requestExitProgram(){
		
		if(conn != null){
			try{conn.close();} catch(SQLException e){e.printStackTrace();}
		}
		
		System.out.println("프로그램 종료");
		System.exit(0);
		
	}
	
}
