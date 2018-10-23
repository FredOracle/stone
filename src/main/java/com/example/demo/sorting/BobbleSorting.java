package com.example.demo.sorting;


import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;


public class BobbleSorting {

	public static void main(String[] args) {
		Integer[] arr = { 19, 3, 12, 4, 55, 6, 32, 56, 78, 2, 45 ,100,10};
		System.out.println(Arrays.asList(arr));
		bobbleSorting(arr);
		System.out.println(Arrays.asList(arr));
		invertedLinkedList(arr);
		System.out.println(Arrays.asList(arr));
		printFileName("G:\\迅雷下载\\");
	}
	
	
	public static void printFileName(String dirPath){
		File dir = new File(dirPath);
		if(dir.isFile()){
			System.out.println(dir.getAbsolutePath());
			return;
		}else{
			for(int i=0;i<dir.listFiles().length;i++){
				printFileName(dir.listFiles()[i].getAbsolutePath());
			}
		}
	}
	
	
	public static void invertedLinkedList(Integer[] arr){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addAll(Arrays.asList(arr));
		Collections.reverse(list);
		list.toArray(arr);
	}
	
	
	public static void bobbleSorting(Integer[] arr){
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int temp = arr[i];
				if (arr[i] < arr[j]) {
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	

}
