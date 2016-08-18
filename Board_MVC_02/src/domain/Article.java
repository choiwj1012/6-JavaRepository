package domain;

import java.util.Date;

public class Article {

	private int number; 	// 글번호
	private String title;   // 글제목
	private String content; // 글내용
	private String writer;  // 작성자
	private Date writeDate; // 작성일
	private int readCount;  // 조회수
	
	// constructor
	public Article(){
		
		
	}
	
	public Article(String title, String content, String writer){
		
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = new Date();
		this.readCount = 0;
		
	}

	// method
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	public Date getWriteDate() {
		return writeDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
}
