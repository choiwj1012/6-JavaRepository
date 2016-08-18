package Robot;

import java.util.Scanner;

public class RobotProcess {

	static Scanner keyboard = new Scanner(System.in);

	void createRobot(){

		if(RobotRepository.currentRobotCount >= RobotRepository.MAX_ROBOT_COUNT){

			System.out.println("더이상 로봇을 만들 수 없습니다");

		}else{

			System.out.println("로봇의 이름을 설정해 주세요");
			String name = keyboard.next();
			String serialNumber = "R_" + (RobotRepository.currentRobotCount + 1);
			RobotRepository.robots[RobotRepository.currentRobotCount] = new Robot(name, serialNumber); 
			RobotRepository.currentRobotCount = RobotRepository.currentRobotCount + 1;

		}

	}

	void workingRobot(){

		boolean innerExit = false;
		while(!innerExit){

			System.out.println("원하시는 로봇의 번호를 선택해 주세요(R_X 형태로 작성할 것)");
			System.out.println("종료를 원하시면 2번을 눌러주세요");
			String selectRobot = keyboard.next();

			if(selectRobot == "2"){
				innerExit = true;
			}

			boolean isFind = false;
			for(int i=0; i<RobotRepository.currentRobotCount; i++){
				if(selectRobot.equals(RobotRepository.robots[i].getSerialNumber())){
					isFind = true;
					System.out.println(selectRobot + "을 선택하셨습니다");
					innerExit = true;
				}	
			}

			if(isFind == false){ // 찾는 로봇이 없다면
				System.out.println("원하시는 로봇이 없습니다");
				break;
			}

			boolean outerExit = false;
			while(!outerExit){ // 로봇 명령하기

				System.out.println("원하시는 로봇 명령을 선택해 주세요");
				String[] workingMenu = {"1. 걷기","2. 뛰기","3. 날기","4. 검휘두르기","5. 미사일쏘기", "6. 종료"};
				for(int i=0; i<workingMenu.length; i++){
					System.out.println(workingMenu[i]);
				}

				int selectedMenu = keyboard.nextInt();

				if(selectedMenu == 1){
					this.actionWalk(selectRobot);
				}else if(selectedMenu == 2){
					this.actionRun(selectRobot);
				}else if(selectedMenu == 3){
					this.actionFlyYes(selectRobot);
				}else if(selectedMenu == 4){
					this.actionKnifeLazer(selectRobot);
				}else if(selectedMenu == 5){
					this.actionMissileYes(selectRobot);
				}else if(selectedMenu == 6){
					System.out.println("로봇 운용을 종료합니다");
					outerExit = true;
				}else{
					System.out.println("잘못 선택하셨습니다");
				}

			} // inner while end 

		} // outer while end

	}

	void modifyRobotInfo(){
		System.out.println("원하시는 로봇 번호를 선택해 주십시오. (R_X 형태로 작성할 것)");
		String selectedRobot = keyboard.next();

		boolean isFind = false;
		for(int i=0; i<RobotRepository.currentRobotCount; i++){
			if(selectedRobot.equals(RobotRepository.robots[i].getSerialNumber())){
				isFind = true;
				System.out.println("이름을 입력해 주십시오");
				String name = keyboard.next();
				RobotRepository.robots[i].setName(name);
			}
		}

	}

	void viewRobotInfo(){
		System.out.println("원하시는 로봇 번호를 선택해 주십시오. (R_X 형태로 작성할 것)");
		String selectedRobot = keyboard.next();

		boolean isFind = false;
		for(int i=0; i<RobotRepository.currentRobotCount; i++){
			if(selectedRobot.equals(RobotRepository.robots[i].getSerialNumber())){
				isFind = true;
				String name = RobotRepository.robots[i].getName();
				String sn = RobotRepository.robots[i].getSerialNumber();
				System.out.println("SN\tName\t");
				System.out.println(name + "\t" + sn);
			}
		}

		if(!isFind){
			System.out.println("선택하신 로봇이 없습니다");
		}

	}

	void viewAllRobotInfo(){

		System.out.println("SN\tName\t");
		for(int i=0; i<RobotRepository.currentRobotCount; i++){
			String name = RobotRepository.robots[i].getName();
			String sn = RobotRepository.robots[i].getSerialNumber();
			System.out.println(name + "\t" + sn);
		}

	}

	void shape(){
		System.out.println("로봇의 머리, 몸통, 팔, 다리가 생겼습니다");
	}

	void actionWalk(String selectRobot){
		System.out.println(selectRobot + "이/가 걷고 있습니다");
	}

	void actionRun(String selectRobot){
		System.out.println(selectRobot + "이/가 뛰고 있습니다");
	}

	void actionFlyYes(String selectRobot){
		System.out.println(selectRobot + "이/가 날고 있습니다");
	}

	void actionFlyNo(String selectRobot){
		System.out.println(selectRobot + "이/가 날 수 없습니다");
	}

	void actionMissileYes(String selectRobot){
		System.out.println(selectRobot + "이/가 미사일을 쏩니다");
	}

	void actionMissileNo(String selectRobot){
		System.out.println(selectRobot + "이/가 미사일을 쏠 수 없습니다");
	}

	void actionKnifeLazer(String selectRobot){
		System.out.println(selectRobot + "이/가 레이저 칼을 사용 합니다");
	}

	void actionknifeWood(String selectRobot){
		System.out.println(selectRobot + "이/가 나무 칼을 사용합니다");
	}

	void actionknifeNo(String selectRobot){
		System.out.println(selectRobot + "이/가 칼이 없습니다");
	}

}
