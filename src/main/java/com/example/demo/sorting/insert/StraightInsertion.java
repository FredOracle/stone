package com.example.demo.sorting.insert;

import com.example.demo.sorting.SortingUtils;

public class StraightInsertion {

	public static Integer[] sort(Integer[] toSortArr) {
		Integer[] arr = new Integer[toSortArr.length];
		arr[0] =  toSortArr[0];

		for (int i = 1; i < toSortArr.length; i++) {

			Integer toInsertInteger = toSortArr[i];
			arr[i] = toInsertInteger;
			
			for (int j = i - 1 ; j >= 0; j--) {
				if (toInsertInteger < arr[j]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j + 1] = tmp;
				}
			}

		}

		return arr;
	}

	public static void main(String[] args) {
		
		SortingUtils.print(SortingUtils.arr);
		Integer[] result = StraightInsertion.sort(SortingUtils.arr);
		SortingUtils.print(result);

	}

}
