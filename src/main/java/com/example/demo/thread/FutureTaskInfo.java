package com.example.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTaskInfo extends FutureTask<String> {
	
	 
	public FutureTaskInfo(Callable<String> callable) {
		super(callable);
	}

	public static void main(String[] args) {

		CallableThreadInfo cThreadInfo = new CallableThreadInfo();
		
		FutureTask<String> fTask = new FutureTaskInfo(cThreadInfo);
		
	}

}
