package shoppingMall.repository;

import java.util.ArrayList;

import shoppingMall.vo.User;

public class UserRepository {

	// 유저 배열
	private ArrayList<User> users = new ArrayList<User>();

	// 유저의 수
	private int lastUserPosition;

	// 로그인한 유저정보
	private int loginUserNumber;

	// constructor
	public UserRepository() {

		User admin = new User("admin","1111","관리자");
		this.users.add(0, admin);
		
	}
	
	// getter and setter
	public ArrayList<User> getUsers() {
		return users;
	}

	public int getLastUserPosition() {
		return lastUserPosition;
	}

	public int getLoginUserNumber() {
		return loginUserNumber;
	}

	public void setLoginUserNumber(int loginUserNumber) {
		this.loginUserNumber = loginUserNumber;
	}

	public void setLastUserPosition(int lastUserPosition) {
		this.lastUserPosition = lastUserPosition;
	}

}
