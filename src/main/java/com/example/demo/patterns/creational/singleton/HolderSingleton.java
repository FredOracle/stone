package com.example.demo.patterns.creational.singleton;

/**
 * @PackageName:com.example.demo.patterns.creational.singleton
 */
public class HolderSingleton {

  private static HolderSingleton instance = null;

  private HolderSingleton(){}

  public static HolderSingleton getInstance() {
    return Holder.instance;
  }

  private static class Holder{
    private static HolderSingleton instance = new HolderSingleton();
  }

}
