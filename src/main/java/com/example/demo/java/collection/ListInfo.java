package com.example.demo.java.collection;

import com.example.demo.util.Profiler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

/**
 * @PackageName:com.example.demo.java.collection
 */
public class ListInfo {

  private static final int CONT = 100000;

  private static LinkedList linkedList = new LinkedList<>();
  private static ArrayList arrayList = new ArrayList();
  private static Vector vector = new Vector();
  private static Stack stack = new Stack();

  public static void main(String[] args) {


    Set set = new HashSet<>();

    set.toArray();
    Map map = new HashMap<>();
    map.values().toArray();

    insertByPosition(stack);
    insertByPosition(arrayList);
    insertByPosition(vector);
    insertByPosition(linkedList);

    System.out.println("============================================");

    readByPosition(stack);
    readByPosition(arrayList);
    readByPosition(vector);
    readByPosition(linkedList);

    System.out.println("============================================");

    deleteByPosition(stack);
    deleteByPosition(arrayList);
    deleteByPosition(vector);
    deleteByPosition(linkedList);

  }

  private static String getListName(List list) {
    if (list instanceof LinkedList) {
      return "LinkedList";
    } else if (list instanceof ArrayList) {
      return "ArrayList";
    } else if (list instanceof Stack) {
      return "Stack";
    } else if (list instanceof Vector) {
      return "Vector";
    } else {
      return "List";
    }
  }


  private static void insertByPosition(List list) {
    Profiler.begin();
    for (int i = 0; i < CONT; i++) {
      list.add(0,i);
    }
    System.out.println(getListName(list) + " Insert " + CONT + " 用时 " + Profiler.end());
  }


  private static void deleteByPosition(List list) {
    Profiler.begin();
    for (int i = 0; i < CONT; i++) {
      list.remove(0);
    }
    System.out.println(getListName(list) + " Remove " + CONT + " 用时 " + Profiler.end());
  }

  private static void readByPosition(List list) {
    Profiler.begin();
    for (int i = 0; i < CONT; i++) {
      list.get(i);
    }
    System.out.println(getListName(list) + " Read " + CONT + " 用时 " + Profiler.end());
  }



}
