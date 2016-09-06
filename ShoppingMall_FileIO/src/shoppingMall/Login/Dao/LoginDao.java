package shoppingMall.Login.Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import shoppingMall.Login.Vo.Login;

public class LoginDao {

	File loginFile;
	File userFile;

	// constructor
	public LoginDao(){

		loginFile = new File("login.txt");
		userFile = new File("user.txt");

		try{		

			loginFile.createNewFile();

		} catch(IOException e) {

			e.printStackTrace();

		}

	}


	// 로그인
	public int login(Login login){

		int loginUserNumber = -1;

		String userID = null;
		String userPW = null;

		String loginUserID = null;
		String loginUserPW = null;

		FileWriter loginFileWriter = null;
		BufferedWriter loginBufferedWriter = null;

		try{

			// 로그인 정보 파일에 쓰기
			loginFileWriter = new FileWriter(loginFile);
			loginBufferedWriter = new BufferedWriter(loginFileWriter);

			loginBufferedWriter.write(login.getUserID() + ",");
			loginBufferedWriter.write(login.getUserPW() + "\r\n");

		} catch(FileNotFoundException e) {

			e.printStackTrace();

		} catch(IOException e) {

			e.printStackTrace();

		} finally {

			try{

				loginBufferedWriter.close();
				loginFileWriter.close();

			} catch(IOException e) {

				e.printStackTrace();

			}
		}


		FileReader loginFileReader = null;
		BufferedReader loginBufferedReader = null;

		try{
			// 로그인한 정보 파일 읽기
			loginFileReader = new FileReader(loginFile);
			loginBufferedReader = new BufferedReader(loginFileReader);

			String loginString = loginBufferedReader.readLine();
			StringTokenizer stringTokenizer = new StringTokenizer(loginString, ",");

			if(stringTokenizer.hasMoreTokens()){

				loginUserID = stringTokenizer.nextToken();
				loginUserPW = stringTokenizer.nextToken();

			}		

		}catch(FileNotFoundException e) {

			e.printStackTrace();

		} catch(IOException e) {

			e.printStackTrace();

		} finally {

			try{

				loginBufferedReader.close();
				loginFileReader.close();

			} catch(IOException e) {

				e.printStackTrace();

			}
		}


		FileReader userFileReader = null;
		BufferedReader userBufferedReader = null;

		try{
			// 유저 정보 파일 읽기
			userFileReader = new FileReader(userFile);
			userBufferedReader = new BufferedReader(userFileReader);

			while(true){

				String userString = userBufferedReader.readLine();

				if(userString == null){
					break;
				}

				StringTokenizer userStringTokenizer = new StringTokenizer(userString, ",");

				if(userStringTokenizer.hasMoreTokens()){

					loginUserNumber = Integer.parseInt(userStringTokenizer.nextToken());
					userID = userStringTokenizer.nextToken();
					userPW = userStringTokenizer.nextToken();
					userStringTokenizer.nextToken();
					userStringTokenizer.nextToken();
					userStringTokenizer.nextToken();
					userStringTokenizer.nextToken();
					userStringTokenizer.nextToken();

					if(loginUserID.equals("admin") && loginUserPW.equals(1111)){

						loginUserNumber = 1;

						return loginUserNumber;
					}

					if(loginUserID.equals(userID) && loginUserPW.equals(userPW)){

						return loginUserNumber;
					}
				}				
			}

		}catch(FileNotFoundException e) {

			e.printStackTrace();

		} catch(IOException e) {

			e.printStackTrace();

		} finally {

			try{

				userBufferedReader.close();
				userFileReader.close();

			} catch(IOException e) {

				e.printStackTrace();

			}
		}
		
		return loginUserNumber;

	}


	// 로그인상태 체크
	public boolean checkLogin(){

		boolean success = false;

		FileReader loginFileReader = null;
		BufferedReader loginBufferedReader = null;

		try{

			loginFileReader = new FileReader(loginFile);
			loginBufferedReader = new BufferedReader(loginFileReader);
			String loginString = loginBufferedReader.readLine();

			if(loginString == null){
				return success;
			} 

		} catch(FileNotFoundException e) {

			e.printStackTrace();

		} catch(IOException e) {

			e.printStackTrace();

		} finally {

			try{

				loginBufferedReader.close();
				loginFileReader.close();

			} catch(IOException e) {

				e.printStackTrace();

			}

		}

		success = true;
		return success;

	}


	// 로그아웃
	public boolean logOut(){

		boolean success = false;

		loginFile.delete();

		success = true;

		File file = new File("order.txt");
		file.delete();

		return success;	

	}

}
