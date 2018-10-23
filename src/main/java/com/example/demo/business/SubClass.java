package com.example.demo.business;

public class SubClass extends ParentClass {
	
	public final double i= Math.random();
	public static double j= Math.random();
	
	@Override
	protected String protectString(){
		System.out.println("=========SubClass================protectString=======");
		return "SubClass";
	}
	
	@Override
	public String pubString(){
		System.out.println("=========SubClass================pubString=======");
		return "SubClass";
	}
	

}
