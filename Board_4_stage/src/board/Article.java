package board;

import java.util.Date;

public class Article {

	private int number; //0
	private String title; //null
	private String content; //null
	private String writer; //null
	private int readCount; //0
	private Date date;
	
	public Article(){
		
	}
	
	public Article(String title, String content, String writer, Date date) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
	}

	public Date setDate(Date date){
		this.date = date;
		return date;
	}
	
	public Date getDate() {
		return date;
	}

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

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
}
