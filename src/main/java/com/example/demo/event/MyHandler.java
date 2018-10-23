package com.example.demo.event;

public class MyHandler extends Handler {

	public MyHandler(String valueString) {
		super(valueString);
	}

	public void doHandler(EventState state) {
		System.out.println("=============handler1 111执行了,现在状态是：===========" + super.getValueString());
	}
}
