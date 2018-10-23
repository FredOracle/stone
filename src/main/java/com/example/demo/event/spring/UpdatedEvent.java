package com.example.demo.event.spring;

import org.springframework.context.ApplicationEvent;

public class UpdatedEvent extends ApplicationEvent {

	private String message;
	
	private String type = "Updated";
	
	
	public UpdatedEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	private static final long serialVersionUID = -3237777281080506715L;

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
