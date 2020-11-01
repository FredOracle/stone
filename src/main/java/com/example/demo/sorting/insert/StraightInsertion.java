package com.example.demo.sorting.insert;

import com.example.demo.sorting.SortingUtils;

/**
 * 直接插入
 * 把数组A[n]中待排序的N个元素看成一个有序表和一个无序表，开始时有序表中只包含一个元素A[0]，无序表中包含n-1个元素（a[1]~A[n-1]）。排序过程中每次从无序表中取出第一个元素，把它插入到有序表适当的位置，使之成为新的有序表，这样经过n-1次插入后，无序表变为空，有序表包含了全部n个元素，至此排序完毕。
 *
 * @author Fred
 */
public class StraightInsertion {

    public static Integer[] sort(Integer[] toSortArr) {
        Integer[] resultArr = new Integer[toSortArr.length];
        resultArr[0] = toSortArr[0];

        for (int i = 1; i < toSortArr.length; i++) {

            Integer toInsertInteger = toSortArr[i];
            resultArr[i] = toInsertInteger;

            for (int j = i - 1; j >= 0; j--) {
                if (toInsertInteger < resultArr[j]) {
                    int tmp = resultArr[j];
                    resultArr[j] = resultArr[j + 1];
                    resultArr[j + 1] = tmp;
                }
            }

        }

        return resultArr;
    }

    public static void main(String[] args) {
        SortingUtils.print(SortingUtils.arr);
        Integer[] result = StraightInsertion.sort(SortingUtils.arr);
        SortingUtils.print(result);

    }

}
