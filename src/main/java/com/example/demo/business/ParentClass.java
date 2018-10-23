package com.example.demo.business;

public class ParentClass {
	
	private final String ab = "aaaaa";
	
	
	private String privString() {
		System.out.println("===========ParentClass========privateString====");
		return "ParentClass";
	}
	
	protected String protectString() {
		System.out.println("===========ParentClass========protectString====");
		return "ParentClass";
	}
	
	public String pubString() {
		System.out.println("===========ParentClass========pubString====");
		return "ParentClass";
	}
	
	public final String  pubFinalString(){
		System.out.println("===========ParentClass========pubFinalString====");
		return "pubFinalString";
	}

}
