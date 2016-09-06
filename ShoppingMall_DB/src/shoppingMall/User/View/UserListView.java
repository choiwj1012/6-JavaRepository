package shoppingMall.User.View;

import java.util.ArrayList;

import shoppingMall.User.Vo.User;

public class UserListView {

	// 유저 리스트 출력
	public void userListView(ArrayList<User> userList){

		System.out.println("유저목록");
		System.out.println("번호\t이름\tID\tPW\t나이\t주소\tE-MAIL\t전화번호");

		for(int i =0; i<userList.size(); i++){
			System.out.print(userList.get(i).getUserNumber()+"\t");
			System.out.print(userList.get(i).getUserName()+"\t");
			System.out.print(userList.get(i).getUserID()+"\t");
			System.out.print(userList.get(i).getUserPW()+"\t");
			System.out.print(userList.get(i).getUserAge()+"\t");
			System.out.print(userList.get(i).getUserAddr()+"\t");
			System.out.print(userList.get(i).getUserEmail()+"\t");
			System.out.println(userList.get(i).getUserTel());
			
		}

	}
	
}
