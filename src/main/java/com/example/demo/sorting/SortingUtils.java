package com.example.demo.sorting;

import java.util.Arrays;

public class SortingUtils {
	
	public static Integer[] arr = {3,49,10,38,65,97,8,76,13,27,49,55,4};
	
	public static void print(Integer[] list) {
		Arrays.asList(list).stream().forEach(item -> System.out.print(item + ", "));
		System.out.println();
	}
	
	

}
