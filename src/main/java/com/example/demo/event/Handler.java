package com.example.demo.event;

import java.util.EventListener;

public abstract class Handler implements EventListener {

	private String valueString;
	
	public Handler(String valueString) {
		this.valueString =  valueString;
	}
	
	
	public String getValueString() {
		return valueString;
	}




	public void setValueString(String valueString) {
		this.valueString = valueString;
	}




	public void doHandler(EventState state) {
		System.out.println("=============handler1 执行了,现在状态是：===========" + valueString);
	}
}
