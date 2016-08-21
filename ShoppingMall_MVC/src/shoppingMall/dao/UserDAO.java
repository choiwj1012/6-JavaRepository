package shoppingMall.dao;

import shoppingMall.repository.UserRepository;
import shoppingMall.vo.User;

public class UserDAO {

	// variable
	UserRepository userRepository;

	// constructor
	public UserDAO(){

		this.userRepository = new UserRepository();

	}

	// method
	public boolean addUser(User newUser){

		boolean success = false;

		for(int i=0; i<userRepository.getUsers().size(); i++){
			if(newUser.getUserID().equals(userRepository.getUsers().get(i).getUserID())){
				return success;
			}
		}

		userRepository.getUsers().add(newUser);
		success = true;

		return success;

	} // End of addUser()


	public void updateUserInfo(User updateUser, int userIdentifiedNumber){

		for(int i=0; i<userRepository.getUsers().size(); i++){
			if(userIdentifiedNumber == userRepository.getLoginUserNumber()){
			
				if(updateUser.getUserPW() != null){
					userRepository.getUsers().get(i).setUserPW(updateUser.getUserPW());	
				}
				
				if(updateUser.getUserName() != null){
					userRepository.getUsers().get(i).setUserName(updateUser.getUserName());	
				}
				 
			}
		}

	} // End of updateUserInfo()


	public User readUserInfo(){

		User loginUser = userRepository.getUsers().get(userRepository.getLoginUserNumber());
			
		return loginUser;

	} // End of readUserInfo()


	public void withDrawMember(User loginUser){

		userRepository.getUsers().remove(userRepository.getLoginUserNumber());

	} // End of withDrawMember()


	public int logIn(User logInUser){

		boolean isIDFind = false;
		int userIdentifiedNumber = -1;

		for(int i=0; i<userRepository.getUsers().size(); i++){
			if(logInUser.getUserID().equals(userRepository.getUsers().get(i).getUserID())){

				isIDFind = true;
				userRepository.setLoginUserNumber(i);
				userIdentifiedNumber = userRepository.getLoginUserNumber();
				break;

			}
		}

		if(!isIDFind){
			
			return userIdentifiedNumber;
		}
		
		if(logInUser.getUserPW().equals(userRepository.getUsers().get(userRepository.getLoginUserNumber()).getUserPW())){
			
			return userIdentifiedNumber;
			
		}

		return userIdentifiedNumber = -1;

	} // End of logIn()


	public void logOut(User loginUser){

		userRepository.setLoginUserNumber(-1);

	} // End of logOut()


}
