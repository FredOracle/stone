package com.example.demo.business;

public interface JDKInterface {

	public static final String USER_PATH = "aaaaaa";
	
	public static void showMessage(){
		System.out.println("================" + USER_PATH);
	}
	
	public default void showAge(){
		System.out.println("===========100=====");
	}
	
	void showContent(String msg);
	
	void showPassword();
}
