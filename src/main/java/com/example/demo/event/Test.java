package com.example.demo.event;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventSource source = new EventSource();
		
		
		MyHandler handler = new MyHandler("Create");
		source.addListeners(handler);

		handler = new MyHandler("Update");
		source.addListeners(handler);
		
		handler = new MyHandler("Delete");
		source.addListeners(handler);
		
		source.triggerEvent1();
	}

}
