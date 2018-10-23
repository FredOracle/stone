package com.example.demo.thread;

public class ThreadInfo extends Thread {
	
	public void run(){
		System.out.println("=====Thread=====");
		
	}

	public static void main(String[] args) {
		Thread thread = new ThreadInfo();
		thread.start();
	}

}
