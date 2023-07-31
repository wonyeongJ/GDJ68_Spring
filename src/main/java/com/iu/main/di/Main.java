package com.iu.main.di;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Dependency Injection(의존성 주입)
		//1. method
		//2. 생성자
		
		
		Arm arm = new Arm();
		Robot robot = null;
		int a=10;
		
		robot.setArm(arm);
		
		robot=null;
		
		
		

	}

}
