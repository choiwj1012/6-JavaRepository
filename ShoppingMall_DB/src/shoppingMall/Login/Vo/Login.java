package shoppingMall.Login.Vo;

public class Login {
	
	//variable
	private String userID;
	private String userPW;
	
	//constructor
	public Login(){
	
	}

	public Login(String userID, String userPW) {
		
		this.userID = userID;
		this.userPW = userPW;
		
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

}
