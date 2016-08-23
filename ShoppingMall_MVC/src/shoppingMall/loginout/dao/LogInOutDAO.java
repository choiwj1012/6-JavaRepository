package shoppingMall.loginout.dao;

import shoppingMall.user.repository.UserRepository;
import shoppingMall.user.vo.User;

public class LogInOutDAO {
	
	public int logIn(User logInUser){ // 로그인하기

		int userIdentifiedNumber = -1;
		int loginUserNumber = -1;
		boolean isFind = false;
		
		for(int i=0; i<UserRepository.getUsers().size(); i++){
			if(logInUser.getUserID().equals(UserRepository.getUsers().get(i).getUserID())){

				loginUserNumber = i;
				UserRepository.setLoginUserNumber(i);
				userIdentifiedNumber = UserRepository.getLoginUserNumber();
				isFind = true;
				break;

			}
		}
		
		if(!isFind){
			
			return userIdentifiedNumber;
			
		}
	
		if(logInUser.getUserPW().equals(UserRepository.getUsers().get(loginUserNumber).getUserPW())){
			
			
			return userIdentifiedNumber;
			
		}
		
		return userIdentifiedNumber = -1;

	} // End of logIn()


	public void logOut(User loginUser){ // 로그아웃하기

		UserRepository.setLoginUserNumber(-1);

	} // End of logOut()

}
