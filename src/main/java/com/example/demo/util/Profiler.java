package com.example.demo.util;

/**
 * @PackageName:com.example.demo.util
 *
 * 可作为方法调用耗时测试类。在调用方法前先调用begin方法。在调用方法后再调用end方法。可测试出调用些方法耗时
 *
 */
public class Profiler {

  private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<>(){
    @Override
    protected Long initialValue() {
      return System.currentTimeMillis();
    }
  };

  public static final void begin() {
    TIME_THREADLOCAL.set(System.currentTimeMillis());
  }

  public static final long end(){
    return System.currentTimeMillis() - TIME_THREADLOCAL.get();
  }

}
