package ShoppingMall.DAO;

import ShoppingMall.domain.User;
import ShoppingMall.repository.UserRepository;

public class UserDAO {

	// UserRepository와 UserDAO 연결
	UserRepository userRepository;

	// constructor
	public UserDAO(){

		this.userRepository = new UserRepository();

	}

	// method
	public void insertAdminUser(User user) { // 메인메뉴

		userRepository.lastUserNumber = userRepository.lastUserNumber + 1;
		user.setNumber(userRepository.lastUserNumber);
		userRepository.users.add(user);

	} // End of insertAdminUser()

	
	public boolean insertUserInUserList(User newUser) {

		boolean success = false;

		for(int i=0; i<userRepository.users.size(); i++) {
			if(newUser.getId().equals(userRepository.users.get(i).getId())) {
				return success;
			}
		}

		userRepository.lastUserNumber = userRepository.lastUserNumber + 1;
		newUser.setNumber(userRepository.lastUserNumber);
		success = userRepository.users.add(newUser);

		return success;
		
	} // End of insertUserInUserList()

	
	public User login(User user) {

		boolean idFind = false;

		for(int i = 0; i < userRepository.users.size(); i++){
			if(user.getId().equals((userRepository.users.get(i).getId()))){
				idFind = true;
				userRepository.loginUserNumber = i;
				break;
			}
		}

		if(!idFind){
			return null;
		}

		if(user.getPw().equals((userRepository.users.get(userRepository.loginUserNumber).getPw()))){
			user = userRepository.users.get(userRepository.loginUserNumber);
			return user;
		}

		return null;

	} // End of login()

	
	public void updateUserInformation(String updateContent, int selectedMenu) {
	
		if(selectedMenu == 1) {
			
			userRepository.users.get(userRepository.loginUserNumber).setName(updateContent);
			
		} else if(selectedMenu == 2) {
			
			userRepository.users.get(userRepository.loginUserNumber).setPw(updateContent);
			
		}
		
	} // End of updateUserInformation()

	
	public User viewUserInformation() {
		
		return userRepository.users.get(userRepository.loginUserNumber);
		
	} // End of viewUserInformation()

	
	public void withdrawMember() {
		
		userRepository.users.remove(userRepository.loginUserNumber);
		
	} // End of withdrawMember()

	
	public void resetLoginUserNumber() {
		
		userRepository.loginUserNumber = 0;
		
	} // End of resetLoginUserNumber()
	
}
