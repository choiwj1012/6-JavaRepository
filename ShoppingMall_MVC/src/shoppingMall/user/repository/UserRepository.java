package shoppingMall.user.repository;

import java.util.ArrayList;

import shoppingMall.user.vo.User;

public class UserRepository {

	// 유저 배열
	private static ArrayList<User> users = new ArrayList<User>();

	// 유저의 수
	private static int lastUserPosition;

	// 로그인한 유저정보
	private static int loginUserNumber;

	// constructor
	public UserRepository() {

		User admin = new User("admin","1111","관리자","111");
		users.add(0, admin);
		
	}
	
	// getter and setter
	public static ArrayList<User> getUsers() {
		return users;
	}

	public static void setUsers(ArrayList<User> users) {
		UserRepository.users = users;
	}

	public static int getLastUserPosition() {
		return lastUserPosition;
	}

	public static void setLastUserPosition(int lastUserPosition) {
		UserRepository.lastUserPosition = lastUserPosition;
	}

	public static int getLoginUserNumber() {
		return loginUserNumber;
	}

	public static void setLoginUserNumber(int loginUserNumber) {
		UserRepository.loginUserNumber = loginUserNumber;
	}
	
}
