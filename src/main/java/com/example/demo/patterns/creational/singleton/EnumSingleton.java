package com.example.demo.patterns.creational.singleton;

/**
 * @PackageName:com.example.demo.patterns.creational.singleton
 */
public class EnumSingleton {

  private EnumSingleton() {
  }

  public static EnumSingleton getInstance() {
    return EnumHolder.INSTANCE.getInstance();
  }

  private enum EnumHolder {
    INSTANCE;

    private EnumSingleton instance = null;

    private EnumHolder() {
      instance = new EnumSingleton();
    }

    private EnumSingleton getInstance() {
      return instance;
    }

  }
}