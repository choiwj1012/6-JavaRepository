package StrategyPattern;

public class MainClass {

	public static void main(String[] args) {
		
		Robot robot = new SuperRobot();
		robot.shape();
		robot.actionWalk();
		robot.actionRun();
		
		robot.setFly(new FlyNo());
		robot.setMissile(new MissileNo());
		robot.setKnife(new KnifeNo());
		robot.actionFly();
		robot.actionMissile();
		robot.actionKnife();
		
		System.out.println();
		
		Robot robot2 = new StandardRobot();
		robot2.shape();
		robot2.actionWalk();
		robot2.actionRun();
		robot2.actionFly();
		robot2.actionMissile();
		robot2.actionKnife();
		
		System.out.println();
		
		Robot robot3 = new LowRobot();
		robot3.shape();
		robot3.actionWalk();
		robot3.actionRun();
		robot3.actionFly();
		robot3.actionMissile();
		robot3.actionKnife();
		
	}

}
