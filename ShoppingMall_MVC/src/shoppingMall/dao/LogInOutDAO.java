package shoppingMall.dao;

import shoppingMall.repository.UserRepository;
import shoppingMall.vo.User;

public class LogInOutDAO {
	
	// variable
	UserRepository userRepository;

	// constructor
	public LogInOutDAO(){

		this.userRepository = new UserRepository();

	}
	public int logIn(User logInUser){ // 로그인하기

		int userIdentifiedNumber = -1;

		for(int i=0; i<userRepository.getUsers().size(); i++){
			if(logInUser.getUserID().equals(userRepository.getUsers().get(i).getUserID()) && logInUser.getUserPW().equals(userRepository.getUsers().get(i).getUserPW()))
			{

				userRepository.setLoginUserNumber(i);
				userIdentifiedNumber = userRepository.getLoginUserNumber();
				System.out.println("하하하하하하하");
				break;

			}
		}

		return userIdentifiedNumber;

	} // End of logIn()


	public void logOut(User loginUser){ // 로그아웃하기

		userRepository.setLoginUserNumber(-1);

	} // End of logOut()

}
