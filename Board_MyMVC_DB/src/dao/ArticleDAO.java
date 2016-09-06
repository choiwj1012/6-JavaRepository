package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Article;

public class ArticleDAO {

	private Connection conn;
	private Statement stmt;

	public ArticleDAO() {

		try{

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
			stmt = conn.createStatement();

		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}


	// method
	// 글쓰기
	public boolean write(Article newArticle){

		boolean success = false;

		// 글번호 생성
		String sql = "select max(num) + 1 from article";

		int rowcount = 0;

		try {			
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				rowcount = rs.getInt(1);
				if (rs.wasNull()) {
					rowcount = 1;
				}

			}

		} catch(SQLException e) {
			e.printStackTrace();
		}

		newArticle.setArticleNumber(rowcount);

		sql = "insert into article values(";
		sql += newArticle.getArticleNumber() + ",'";
		sql += newArticle.getTitle() + "','";
		sql += newArticle.getContent() + "','";
		sql += newArticle.getWriter() + "','";
		sql += newArticle.getWriteDate() + "',";
		sql += newArticle.getReadCount() + ")";

		System.out.println(sql);

		int result = 0;

		try{

			result = stmt.executeUpdate(sql);

		}catch(SQLException e){
			e.printStackTrace();
		}

		if(result != 0){
			success = true;
		}

		return success;

	}


	// 글전체목록 가져가기
	public ArrayList<Article> selectAll(){

		ArrayList<Article> articles = new ArrayList<Article>();

		String sql = "select num, title, content, writer, writeDate, readCount from article order by num desc";

		ResultSet rs = null;

		try{

			rs = stmt.executeQuery(sql);

			while(rs.next()){

				int number = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String writeDate = rs.getString("writeDate");
				int readCount = rs.getInt("readCount");

				Article article = new Article(number, title, content, writer, writeDate, readCount);
				articles.add(article);

			}

		} catch(SQLException e) {
			e.printStackTrace();
		}

		return articles;

	}


	// 선택글 한개 가져가기
	public Article selectOne(int selectedNum){

		Article selectedArticle = null;
		ResultSet rs = null;

		try{

			String sql = "update article set readCount = readCount + 1 where num = " + selectedNum;
			int result = stmt.executeUpdate(sql);
			if(result != 0){

				sql = "select * from article where num = " + selectedNum;
				rs = stmt.executeQuery(sql);

				while(rs.next()){

					selectedArticle = new Article();
					selectedArticle.setArticleNumber(rs.getInt("num"));
					selectedArticle.setTitle(rs.getString("title"));
					selectedArticle.setContent(rs.getString("content"));
					selectedArticle.setWriter(rs.getString("writer"));
					selectedArticle.setWriteDate(rs.getString("writeDate"));
					selectedArticle.setReadCount(rs.getInt("readCount"));

				}

			}


		} catch(SQLException e) {
			e.printStackTrace();
		}

		return selectedArticle;

	}


	// 업데이트하기
	public boolean update(Article article){

		boolean success = false;

		String sql = "update article set title = '" + article.getTitle() + "',";
		sql += "content = '" + article.getContent() + "',";
		sql += "writer = '" + article.getWriter() + "' where num = " + article.getArticleNumber();

		int result = 0;

		try {

			result = stmt.executeUpdate(sql);

		} catch(SQLException e) {
			e.printStackTrace();
		}

		if(result != 0){
			success = true;
		}

		return success;

	}

	// 삭제하기
	public boolean delete(int selectedNum){

		boolean success = false;

		String sql = "delete from article where num = " + selectedNum;
		int result = 0;

		try{

			result = stmt.executeUpdate(sql);

		} catch(SQLException e) {
			e.printStackTrace();
		}

		if(result != 0){
			success = true;
		}

		return success;

	}

}
