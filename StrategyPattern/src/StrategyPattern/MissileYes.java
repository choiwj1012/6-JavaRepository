package StrategyPattern;

public class MissileYes implements Missile_Interface {

	@Override
	public void missile() {
		System.out.println("미사일을 쏠 수 있습니다");

	}

}
