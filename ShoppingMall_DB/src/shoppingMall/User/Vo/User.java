package shoppingMall.User.Vo;

public class User {

	// variable
	private int userNumber; 	// 유저번호
	private String userID;  	// 유저아이디
	private String userPW;  	// 유저비밀번호
	private String userEmail;	// 유저 이메일
	private String userName;	// 유저 이름
	private int userAge;		// 유저 나이
	private String userAddr;	// 유저 주소
	private String userTel;		// 유저 전화번호

	// constructor
	public User(){


	}

	public User(String userID, String userPW, String userEmail, 
			String userName,String userAddr, int userAge, String userTel) {

		this.userID = userID;
		this.userPW = userPW;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userAddr= userAddr;
		this.userAge = userAge;
		this.userTel = userTel;

	}

	public User(int userNumber, String userID, String userPW, String userEmail, 
			String userName, int userAge, String userAddr, String userTel) {

		this.userNumber = userNumber;
		this.userID = userID;
		this.userPW = userPW;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userAge = userAge;
		this.userAddr= userAddr;
		this.userTel = userTel;

	}

	// getter and setter
	public int getUserNumber() {

		return userNumber;

	}


	public void setUserNumber(int userNumber) {

		this.userNumber = userNumber;

	}


	public String getUserPW() {

		return userPW;

	}


	public void setUserPW(String userPW) {

		this.userPW = userPW;

	}


	public String getUserEmail() {

		return userEmail;

	}


	public void setUserEmail(String userEmail) {

		this.userEmail = userEmail;

	}


	public String getUserName() {

		return userName;

	}


	public void setUserName(String userName) {

		this.userName = userName;

	}


	public int getUserAge() {

		return userAge;

	}


	public void setUserAge(int userAge) {

		this.userAge = userAge;

	}


	public String getUserAddr() {

		return userAddr;

	}


	public void setUserAddr(String userAddr) {

		this.userAddr = userAddr;

	}


	public String getUserTel() {

		return userTel;

	}


	public void setUserTel(String userTel) {

		this.userTel = userTel;

	}


	public String getUserID() {

		return userID;

	}
	
	public void setUserID(String userID) {

		this.userID = userID;

	}
	
}
