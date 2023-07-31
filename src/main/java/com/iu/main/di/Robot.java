package com.iu.main.di;

public class Robot {
	
	private String name;
	
	private static Robot robot;
	
	private Arm arm;
	//SingleTone
	private Robot() {
		//this.arm = new Arm();
		//결합도가 높다(강하다)
	}
	
	public static Robot getInstance() {
		if(robot==null) {
			Robot.robot=new Robot();
		}
		return Robot.robot;
	}
	
//	public Robot(Arm arm) {
//		this.arm=arm;
//		//결합도가 낮다(약하다)
//	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Arm getArm() {
		return arm;
	}

	public void setArm(Arm arm) {
		this.arm = arm;
	}

}
