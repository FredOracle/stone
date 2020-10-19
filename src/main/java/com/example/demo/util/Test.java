package com.example.demo.util;

import com.example.demo.business.DemoBusiness;
import java.util.regex.Pattern;

public class Test {

	private static final String IP_PATTERN = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
			+ "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
			+ "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))$";

	public static final Pattern PATTERN_IP = Pattern.compile(IP_PATTERN);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// DemoBusiness b = new DemoBusiness();
		// EventType.CREATE.doEvent(b);
		//
		// EventType.UPDATE.doEvent(b);
		//
		// EventType.DELETE.doEvent(b);

		String serviceTypeStr = "intranet";
		ServiceType serviceType = ServiceType.fromValue(serviceTypeStr);
//		System.out.println(serviceType);

	 
		System.out.println(!PATTERN_IP.matcher("").matches());
		
		System.out.println(!PATTERN_IP.matcher("2.2.2.2").matches());
		
		 

	}

}
