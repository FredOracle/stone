package com.example.demo.util;

import java.io.File;
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


		listDirSize(new File("C:\\Users\\Fred\\AppData"), 0);

	}

	public static void testServiceType() {
		String serviceTypeStr = "intranet";
		ServiceType serviceType = ServiceType.fromValue(serviceTypeStr);
		System.out.println(serviceType);
	}

	public static void testIP() {
		System.out.println(!PATTERN_IP.matcher("").matches());

		System.out.println(!PATTERN_IP.matcher("2.2.2.2").matches());
	}

	public static void listDirSize(File file, long max) {

		if (file.isFile()) {
			if (file.length() > 0) {
				long len = file.length();
				long kb = 0;
				long mb = 0;
				long gb = 0;
				if (len > 1000) {
					kb = len/1000;
//					System.out.println(file.getAbsolutePath() + " ========= " +  kb + "KB");
				}

				if (kb > 1000) {
					mb = kb/1000;
					if (mb >= max) {
						max = mb;
						System.out.println(file.getAbsolutePath() + " ========= " +  mb + "MB");
					}
				}
				if (mb > 1000) {
					gb = mb/1000;
					System.out.println(file.getAbsolutePath() + " ========= " +  gb + "G");
				}


			}
			return;
		}

		final File[] children = file.listFiles();
		long total = 0;
		if (children != null) {
			for (File f : children) {
				listDirSize(f, max);
			}
		}

		return ;
	}
}
