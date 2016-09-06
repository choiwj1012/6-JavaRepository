package loginVo;

public class Login {

	private String userId;
	private String userPassword;	
	
	public Login(String userId, String userPassword) {
	
		this.userId = userId;
		this.userPassword = userPassword;
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	

}
