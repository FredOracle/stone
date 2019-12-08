package com.example.demo.sorting.swap;

import com.example.demo.sorting.SortingUtils;

public class BobbleSorting {

	public static Integer[] sort(Integer[] toSortArr) {
		for (int i = 0; i < toSortArr.length; i++) {
			for (int j = i; j < toSortArr.length; j++) {
				if(toSortArr[i] > toSortArr[j]){
					int tmp = toSortArr[i];
					toSortArr[i] = toSortArr[j];
					toSortArr[j] = tmp; 
				}
			}
		}
		return toSortArr;
	}

	public static void main(String[] args) {
		SortingUtils.print(SortingUtils.arr);
		Integer[] result = BobbleSorting.sort(SortingUtils.arr);
		SortingUtils.print(result);
	}

}
