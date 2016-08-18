package StrategyPattern;

public class StandardRobot extends Robot{
	
	// constructor
	public StandardRobot(){

		this.fly = new FlyNo();
		this.missile = new MissileYes();
		this.knife = new KnifeWood();
		
	}

	@Override
	public void shape() {
		System.out.println("보통 로봇임");
	}

}
