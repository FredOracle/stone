package com.example.demo.sorting.insert;

public class ShellSort {

	public static Integer[] sort(Integer[] toSortArray){
		Integer[] arr = new Integer[toSortArray.length];
		
		int dk = arr.length/2;
		while(dk >= 1){
			StraightInsertion.sort(toSortArray);
		}
		
		return arr;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
