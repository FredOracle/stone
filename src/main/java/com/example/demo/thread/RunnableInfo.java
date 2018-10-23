package com.example.demo.thread;

public class RunnableInfo implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("=======Runnable===========");
	}

	public static void main(String[] args) throws Exception{
		Thread runningable = new Thread(new RunnableInfo());
		runningable.start();
	}
}
