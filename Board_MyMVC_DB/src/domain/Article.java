package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Article {
	
	
	// variable
	private int articleNumber; 	// 글번호
	private String title;		// 글제목
	private String content;		// 글내용
	private String writer;		// 작성자
	private String writeDate;	// 작성일
	private int readCount;		// 조회수
	
	
	// constructor
	public Article(){
		
		
		
	}
	
	public Article(String title, String content, String writer){
		
		this.title = title;
		this.content = content;
		this.writer = writer;
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");		
		this.writeDate = format.format(new Date());
		
	}
	
	
	public Article(int articleNumber, String title, String content, String writer){
	
		this.articleNumber = articleNumber;
		this.title = title;
		this.content = content;
		this.writer = writer;
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");		
		this.writeDate = format.format(new Date());
		
	}

	public Article(int articleNumber, String title, String content, String writer, String writeDate, int readCount){
		
		this.articleNumber = articleNumber;
		this.title = title;
		this.content = content;
		this.writer = writer;
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");		
		this.writeDate = format.format(new Date());
		this.readCount = readCount;
		
	}
	
	// getter and setter
	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
}
