package com.example.demo.interview.cs.arraysandmatrices.note3;

import java.util.Random;

/**
 * 题目描述:
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 */
public class Exam {

  public static void main(String[] args) {
    int len = 9;
    explain(generator(len));
  }


  private static void explain(int[] ints) {
    System.out.println();
    int[] result = new int[ints.length];
    for (int i = 0; i < ints.length; i++) {
      int currentValue = ints[i];
      int tmp = result[currentValue];
      result[currentValue] = tmp + 1;
    }

    for (int i = 0; i < result.length; i++) {
      var value = result[i];
      if (value != 0) {
        System.out.println(i + ">>>>" + value);
      }
    }
  }

  private static void duplicate(int[] ints){
    System.out.println();




  }

  private static int[] generator(int n) {
    int[] result = new int[n];
    Random random = new Random(1);
    for (int i = 0; i < n; i++) {
      result[i] = random.nextInt(n);
      System.out.print(result[i] + ",");
    }
    return result;
  }


}
