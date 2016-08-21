package shoppingMall.vo;

import java.util.Date;

public class User {

	// variable
	private String userID;
	private String userPW;
	private String userName;
	private Date joinDate;
	
	
	// constructor
	public User(){
		
	}
	
	public User(String userID, String userPW){
	
		this.userID = userID;
		this.userPW = userPW;
		
	}
	
	public User(String userID, String userPW, String userName){
		
		this.userID = userID;
		this.userPW = userPW;
		this.userName = userName;
		this.joinDate = new Date();
		
	}

	// getter and setter
	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
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


	public Date getJoinDate() {
		return joinDate;
	}

}
