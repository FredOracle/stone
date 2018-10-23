package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoApplicationTests {

	public void contextLoads() {
		
	
		
		
		System.out.println("11111111111111");
		ConcurrentLinkedQueue q = null;
		
		Queue<String> queue = new LinkedBlockingQueue<String>();
		
		queue.add("1");
		queue.add("2");
		queue.add("3");
		queue.add("4");
		queue.add("5");
		queue.add("6");
		
		log.info("" + queue.poll());
	}
	
	
	@Test
	public void testClear(){
		ArrayList list = new ArrayList<String>();
		System.out.println(list.size());
		list.add("a");
		list.add("a");
		list.add("a");
		System.out.println(list.size());
		list.clear();
		System.out.println(list.size());
	}

}
