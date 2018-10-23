package com.example.demo.event;

import java.util.EventObject;

public class EventState extends EventObject {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4270654569909320227L;
	
	private String state = "";
	
	
	public EventState(Object source) {
		super(source);
	}
	
	public EventState(Object source, String state){
		super(source);
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
