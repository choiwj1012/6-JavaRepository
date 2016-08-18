package StrategyPattern;

public abstract class Robot {
	
	Fly_Interface fly;
	Missile_Interface missile;
	Knife_Interface knife;
	
	// constructor
	public Robot() {
	
	}
	
	public void setFly(Fly_Interface fly){
		this.fly = fly;
	}
	
	public void setMissile(Missile_Interface missile){
		this.missile = missile;
	}
	
	public void setKnife(Knife_Interface knife){
		this.knife = knife;
	}
	
	// method
	// special method
	public void actionKnife(){
		this.knife.knife();
	}
	
	public void actionFly(){
		this.fly.fly();
	}
	
	public void actionMissile(){
		this.missile.missile();
	}
	
	// common method
	public abstract void shape();
	
	public void actionWalk(){
		System.out.println("걷습니다");
	}
	
	public void actionRun(){
		System.out.println("달립니다");
	}
	
}
