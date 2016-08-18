package StrategyPattern;

public class SuperRobot extends Robot{
	
	// constructor
	public SuperRobot() {
		
		this.fly = new FlyYes();
		this.missile = new MissileYes();
		this.knife = new KnifeLazer();
		
	}

	@Override
	public void shape() {
		System.out.println("슈퍼로봇임");
		
	}
	
}
