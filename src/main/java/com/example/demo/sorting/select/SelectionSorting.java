package com.example.demo.sorting.select;

import com.example.demo.sorting.SortingUtils;

public class SelectionSorting {

	public static Integer[] sort(Integer[] toSortArr) {

		for (int i = 0; i < toSortArr.length; i++) {
			int index = i;
			for (int j = i + 1; j < toSortArr.length; j++) {
				if(toSortArr[index] > toSortArr[j]){
					index = j;
				}
			}
			
			int tmp = toSortArr[i];
			toSortArr[i] = toSortArr[index];
			toSortArr[index] = tmp;
		}

		return toSortArr;
	}

	public static void main(String[] args) {
		SortingUtils.print(SortingUtils.arr);
		Integer[] result = SelectionSorting.sort(SortingUtils.arr);
		SortingUtils.print(result);
	}

}
