package com.example.demo.interview;

import java.util.Arrays;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class JudgeDataInArray {


    public static void main(String[] args) {
        int[][] array = {{1,2,8,9}, {2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean result = JudgeDataInArray.find(7,array);
        System.out.println(result);
    }

    private static boolean find(int target, int[][] array) {
        return Arrays.stream(array).anyMatch(arr -> Arrays.stream(arr).anyMatch(item -> item == target));
    }
}
