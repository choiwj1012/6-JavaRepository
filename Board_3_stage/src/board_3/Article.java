package board_3;

public class Article {
	
	static final int MAX_ARTICLE_COUNT = 5;
	static int lastArticlePosition = 0;
	private int number;
	private String title;
	private String content;
	private String writer;
	private int readCount;
	
	public Article(String title, String content, String writer){
		this.title = title;
		this.content = content;
		this.writer = writer;
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
