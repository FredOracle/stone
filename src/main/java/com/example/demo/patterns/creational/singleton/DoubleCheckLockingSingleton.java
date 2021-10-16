package com.example.demo.patterns.creational.singleton;

/**
 * @PackageName:com.example.demo.patterns.creational.singleton
 */
public class DoubleCheckLockingSingleton {

  private static volatile DoubleCheckLockingSingleton instance = null;

  private DoubleCheckLockingSingleton(){}

  public static DoubleCheckLockingSingleton getInstance() {

    if (null == instance) {
      synchronized (DoubleCheckLockingSingleton.class) {
        if (null == instance) {
          instance = new DoubleCheckLockingSingleton();
        }
      }
    }
    return instance;
  }


}
