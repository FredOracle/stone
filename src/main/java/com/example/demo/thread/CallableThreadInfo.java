package com.example.demo.thread;

import java.util.concurrent.Callable;

public class CallableThreadInfo implements Callable<String> {

	@Override
	public String call() throws Exception {
		
		System.out.println("===========CallableThreadInfo============");
		return Boolean.TRUE.toString();
	}
	
	
	

}
