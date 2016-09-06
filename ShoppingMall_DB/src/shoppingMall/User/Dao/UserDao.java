package shoppingMall.User.Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import shoppingMall.User.Vo.User;

public class UserDao {

	private Connection conn;

	// constructor
	public UserDao(){

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	// 가입
	public boolean userSignUp(User userSign){

		boolean signUpSuccess = false;

		int nextUserNumber = 0;
		String sql = "select max(userNumber) + 1 from userInfo";
		
		
		
		
		return signUpSuccess;

	}


	//중복아이디 체크
	public boolean checkUserId(User userCheckId){

		boolean isFindID = false;

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try{

			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			while(true){

				String userInfoString = bufferedReader.readLine();

				if(userInfoString == null){
					break;
				}

				StringTokenizer stringTokenizer = new StringTokenizer(userInfoString, ",");

				if(stringTokenizer.hasMoreTokens()){

					stringTokenizer.nextToken();
					String id = stringTokenizer.nextToken();
					stringTokenizer.nextToken();
					stringTokenizer.nextToken();
					stringTokenizer.nextToken();
					stringTokenizer.nextToken();
					stringTokenizer.nextToken();
					stringTokenizer.nextToken();

					if(id.equals(userCheckId.getUserID())){
						isFindID = true;
						return isFindID;
					}

				}
			}

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
		
			e.printStackTrace();
			
		} finally {

			try{
				
				bufferedReader.close();
				fileReader.close();
				
			} catch(IOException e){
				
				e.printStackTrace();
				
			}

		}

		return isFindID;

	}

		
	//목록
	public ArrayList<User> userList(){

		ArrayList<User> userList = new ArrayList<User>();
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try{
			
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			while(true){
				
				String userString = bufferedReader.readLine();
				
				if(userString == null){
					break;
				}
				
				StringTokenizer stringTokenizer = new StringTokenizer(userString, ",");
				
				if(stringTokenizer.hasMoreTokens()){
					
					int userNumber = Integer.parseInt(stringTokenizer.nextToken());
					String userID = stringTokenizer.nextToken();
					String userPW = stringTokenizer.nextToken();
					String userEmail = stringTokenizer.nextToken();
					String userName = stringTokenizer.nextToken();
					int userAge = Integer.parseInt(stringTokenizer.nextToken());
					String userAddr = stringTokenizer.nextToken();
					String userTel = stringTokenizer.nextToken();
					
					User newUser = new User(userNumber, userID, userPW, userEmail, userName, userAge, userAddr, userTel);
					userList.add(newUser);
					
				}
				
			}
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try{
				bufferedReader.close();
				fileReader.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		return userList;

	}

	
	public User searchUser(int searchNumber){

		User selectedUser = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try{
			
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			while(true){
				
				String userString = bufferedReader.readLine();
				
				if(userString == null){
					break;
				}
				
				StringTokenizer stringTokenizer = new StringTokenizer(userString, ",");
				
				if(stringTokenizer.hasMoreTokens()){
					
					int userNumber = Integer.parseInt(stringTokenizer.nextToken());
					
					if(searchNumber == userNumber){
						
						selectedUser = new User();
						selectedUser.setUserNumber(userNumber);
						
						String userID = stringTokenizer.nextToken();
						selectedUser.setUserID(userID);
						
						String userPW = stringTokenizer.nextToken();
						selectedUser.setUserPW(userPW);
						
						String userEmail = stringTokenizer.nextToken();
						selectedUser.setUserEmail(userEmail);
						
						String userName = stringTokenizer.nextToken();
						selectedUser.setUserName(userName);
						
						int userAge = Integer.parseInt(stringTokenizer.nextToken());
						selectedUser.setUserAge(userAge);
						
						String userAddr = stringTokenizer.nextToken();
						selectedUser.setUserAddr(userAddr);
						
						String userTel = stringTokenizer.nextToken();
						selectedUser.setUserTel(userTel);
							
					}
					
				}
					
			}
	
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			
			try{
				bufferedReader.close();
				fileReader.close();
			} catch(IOException e){
				e.printStackTrace();
			}
			
		}

		
		return selectedUser;

	}

	
	public User deleteUser(int searchNumber){

		User deleteUser = null;

		ArrayList<User> userList = userList();
		
		for(int i=0; i<userList.size(); i++){
			if(searchNumber == userList.get(i).getUserNumber()){
				userList.remove(i);
			}
		}
		
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try{
			
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			for(int i=0; i<userList.size(); i++){
				
				bufferedWriter.write(userList.get(i).getUserNumber() + ",");
				bufferedWriter.write(userList.get(i).getUserID() + ",");
				bufferedWriter.write(userList.get(i).getUserPW() + ",");
				bufferedWriter.write(userList.get(i).getUserEmail() + ",");
				bufferedWriter.write(userList.get(i).getUserName() + ",");
				bufferedWriter.write(userList.get(i).getUserAge() + ",");
				bufferedWriter.write(userList.get(i).getUserAddr() + ",");
				bufferedWriter.write(userList.get(i).getUserTel() + "\r\n");
				
			}
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try{
				bufferedWriter.close();
				fileWriter.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}

		
		
		return deleteUser;

	}


	//유저정보수정
	public boolean updateUser(User updateUser){

		boolean success = false;
		
		ArrayList<User> users = userList();
		
		for(int i=0; i<users.size(); i++){
			if(updateUser.getUserNumber() == users.get(i).getUserNumber()){
				
				users.get(i).setUserName(updateUser.getUserName());
				users.get(i).setUserPW(updateUser.getUserPW());
				users.get(i).setUserEmail(updateUser.getUserEmail());
				users.get(i).setUserAddr(updateUser.getUserAddr());
				users.get(i).setUserTel(updateUser.getUserTel());
				
			}
		}

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try{
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			for(int i=0; i<users.size(); i++){
				
				bufferedWriter.write(users.get(i).getUserNumber() + ",");
				bufferedWriter.write(users.get(i).getUserID() + ",");
				bufferedWriter.write(users.get(i).getUserPW() + ",");
				bufferedWriter.write(users.get(i).getUserEmail() + ",");
				bufferedWriter.write(users.get(i).getUserName() + ",");
				bufferedWriter.write(users.get(i).getUserAge() + ",");
				bufferedWriter.write(users.get(i).getUserAddr() + ",");
				bufferedWriter.write(users.get(i).getUserTel() + "\r\n");
				
			}
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			
			try{
				bufferedWriter.close();
				fileWriter.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			
		}
		
		success = true;

		return success;

	}


//	//회원탈퇴
//	public User withdrawUser(){
//
//		//return UserRepository.getUsers().remove(LoginRepository.getLoginUserNumber());
//
//	}

	
	// 유저번호찾기
	public int lastUserNumber(){
		
		int lastUserNumber = 0;
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try{
			
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			while(true){
				
				String userString = bufferedReader.readLine();
				
				if(userString == null){
					break;
				}
				
				StringTokenizer stringTokenizer = new StringTokenizer(userString, ",");
				
				if(stringTokenizer.hasMoreTokens()){
					lastUserNumber = Integer.parseInt(stringTokenizer.nextToken());
					stringTokenizer.nextToken();
					stringTokenizer.nextToken();
					stringTokenizer.nextToken();
					stringTokenizer.nextToken();
					stringTokenizer.nextToken();
					stringTokenizer.nextToken();
					stringTokenizer.nextToken();
				}
				
			}
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			
			try{
				bufferedReader.close();
				fileReader.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return lastUserNumber;

	}

}