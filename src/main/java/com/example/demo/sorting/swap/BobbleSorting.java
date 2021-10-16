package com.example.demo.sorting.swap;

import com.example.demo.sorting.SortingUtils;
import java.util.Arrays;

public class BobbleSorting {

	public static Integer[] sort(final Integer[] toSortArr) {
		Integer[] result = Arrays.copyOf(toSortArr, toSortArr.length);

		for (int i = 0; i < result.length; i++) {
			for (int j = i; j < result.length; j++) {
				if(result[i] > result[j]){
					int tmp = result[i];
					result[i] = result[j];
					result[j] = tmp;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SortingUtils.print(SortingUtils.arr);
		Integer[] result = BobbleSorting.sort(SortingUtils.arr);
		SortingUtils.print(result);
	}

}
