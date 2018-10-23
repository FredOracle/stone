package com.example.demo.event.spring;

import org.springframework.context.ApplicationEvent;

public class CreatedEvent extends ApplicationEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	private String type = "Created";
	
	
	public CreatedEvent(Object source) {
		super(source);
	}

	public CreatedEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
