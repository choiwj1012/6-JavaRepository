package shoppingMall.vo;

import java.util.Date;

public class User {

	// variable
	private int number;      // 고객번호
	private String userID;   // 식별자
	private String userPW;   // 비밀번호
	private String userName; // 유저이름
	private String userTel;  // 전화번호
	private Date joinDate;   // 가입날짜
	
	
	// constructor
	public User(){
		
	}
	
	public User(String userID, String userPW){
	
		this.userID = userID;
		this.userPW = userPW;
		
	}
	
	public User(String userID, String userPW, String userName, String userTel){
		
		this.userID = userID;
		this.userPW = userPW;
		this.userName = userName;
		this.userTel = userTel;
		this.joinDate = new Date();
		
	}

	// getter and setter
	public int getNumber() {
		return number;
	}

	
	public void setNumber(int number) {
		this.number = number;
	}

	
	public String getUserID() {
		return userID;
	}


	public String getUserPW() {
		return userPW;
	}


	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserTel() {
		return userTel;
	}

	
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	
	public Date getJoinDate() {
		return joinDate;
	}

}
