package shoppingMall.dao;

import java.util.ArrayList;

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
	public boolean addUser(User newUser){ // 유저 등록

		boolean success = false;

		for(int i=0; i<userRepository.getUsers().size(); i++){
			if(newUser.getUserID().equals(userRepository.getUsers().get(i).getUserID())){
				return success;
			}
		}

		userRepository.setLastUserPosition(userRepository.getLastUserPosition() + 1);
		newUser.setNumber(userRepository.getLastUserPosition());
		userRepository.getUsers().add(newUser);
		
		success = true;

		return success;

	} // End of addUser()


	public void updateUserInfo(User updateUser, int userIdentifiedNumber){ // 유저 수정

		for(int i=0; i<userRepository.getUsers().size(); i++){
			if(userIdentifiedNumber == userRepository.getLoginUserNumber()){
			
				if(updateUser.getUserPW() != null){
					userRepository.getUsers().get(i).setUserPW(updateUser.getUserPW());	
				}
				
				if(updateUser.getUserName() != null){
					userRepository.getUsers().get(i).setUserName(updateUser.getUserName());	
				}
				
				if(updateUser.getUserTel() != null){
					userRepository.getUsers().get(i).setUserTel(updateUser.getUserTel());
				}
				 
			}
		}

	} // End of updateUserInfo()


	public ArrayList<User> selectAllUser(){
		
		ArrayList<User> users = null;
		
		users = userRepository.getUsers();
		
		return users;
		
	} // End of selectAllUser()
	
	
	public User readUserInfo(){ // 로그인한 유저 정보 가져오기

		User loginUser = userRepository.getUsers().get(userRepository.getLoginUserNumber());
			
		return loginUser;

	} // End of readUserInfo()

	
	public void withDrawMember(User loginUser){ // 탈퇴하기

		userRepository.getUsers().remove(userRepository.getLoginUserNumber());

	} // End of withDrawMember()


	public int logIn(User logInUser){ // 로그인하기

		int userIdentifiedNumber = -1;

		for(int i=0; i<userRepository.getUsers().size(); i++){
			if(logInUser.getUserID().equals(userRepository.getUsers().get(i).getUserID()) && 
					logInUser.getUserPW().equals(userRepository.getUsers().get(i).getUserPW()))
			{

				userRepository.setLoginUserNumber(i);
				userIdentifiedNumber = userRepository.getLoginUserNumber();
				break;

			}
		}
			
		return userIdentifiedNumber;

	} // End of logIn()


	public void logOut(User loginUser){ // 로그아웃하기

		userRepository.setLoginUserNumber(-1);

	} // End of logOut()

}
