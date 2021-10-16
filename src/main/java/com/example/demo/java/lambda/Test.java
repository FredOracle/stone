package com.example.demo.java.lambda;

public class Test {


  public static void main(String[] args) {

    int[] array = {1,32,43,14,3,42,16,28,21,53};



    for(int i=0;i<array.length;i++) {

      for(int j = i; j<array.length;j++) {

        if (array[i] > array[j]) {
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }

    }


    for (int i = 0;i<array.length;i++) {
      System.out.println(array[i]);
    }

  }



}
