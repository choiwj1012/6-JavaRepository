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

		for(int i=0; i<UserRepository.getUsers().size(); i++){
			if(newUser.getUserID().equals(UserRepository.getUsers().get(i).getUserID())){
				return success;
			}
		}
		
		UserRepository.setLastUserPosition(UserRepository.getLastUserPosition());
		newUser.setNumber(UserRepository.getLastUserPosition() + 1);
		UserRepository.getUsers().add(newUser);
		
		success = true;

		return success;

	} // End of addUser()


	public void updateUserInfo(User updateUser, int userIdentifiedNumber){ // 유저 수정

		for(int i=0; i<UserRepository.getUsers().size(); i++){
			if(userIdentifiedNumber == UserRepository.getLoginUserNumber()){
			
				if(updateUser.getUserPW() != null){
					UserRepository.getUsers().get(i).setUserPW(updateUser.getUserPW());	
				}
				
				if(updateUser.getUserName() != null){
					UserRepository.getUsers().get(i).setUserName(updateUser.getUserName());	
				}
				
				if(updateUser.getUserTel() != null){
					UserRepository.getUsers().get(i).setUserTel(updateUser.getUserTel());
				}
				 
			}
		}

	} // End of updateUserInfo()


	public ArrayList<User> selectAllUser(){
		
		ArrayList<User> users = null;
		
		users = UserRepository.getUsers();
		
		return users;
		
	} // End of selectAllUser()
	
	
	public User readUserInfo(){ // 로그인한 유저 정보 가져오기

		User loginUser = UserRepository.getUsers().get(UserRepository.getLoginUserNumber());
			
		return loginUser;

	} // End of readUserInfo()

	
	public void withDrawMember(User loginUser){ // 탈퇴하기

		UserRepository.getUsers().remove(UserRepository.getLoginUserNumber());

	} // End of withDrawMember()

}
