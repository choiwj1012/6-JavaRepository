package ShoppingMall.domain;

public class User {

	// variable
	private int number; // 유저 번호
	private String id;  // 유저 아이디
	private String pw;  // 유저 비밀번호
	private String name; // 유저 이름

	// constructor
	public User(){
		
	}
	
	public User(String id, String pw){
		
		this.id = id;
		this.pw = pw;
		
	}
	
	public User(String id, String pw, String name) {
		
		this.id = id;
		this.pw = pw;
		this.name = name;
		
	}	

	// method

	// 유저 번호
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	// 아이디
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	// 비밀번호
	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	// 유저 이름
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

}