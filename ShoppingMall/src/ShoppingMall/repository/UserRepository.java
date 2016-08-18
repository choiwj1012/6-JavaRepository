package ShoppingMall.repository;

import java.util.ArrayList;

import ShoppingMall.domain.User;

public class UserRepository {
	
	// 유저 배열 리스트
	public ArrayList<User> users = new ArrayList<User>();
	
	// 유저 숫자 카운팅
	public int lastUserNumber = 0;
	
	// 로그인한 유저의 번호 저장
	public int loginUserNumber = 0;
	
}
