package com.example.demo.java.volatil;

/**
 * @PackageName:com.example.demo.thread
 * 此例为了验证Volatile无法保证原子性
 */
public class VolatileInfo {

  public volatile int inc = 0;

  public void increase() {
    inc++;
  }

  public static void main(String[] args) {

    final VolatileInfo test = new VolatileInfo();
    for (int i = 0; i < 10; i++) {
      new Thread(){
        @Override
        public void run() {
          for (int j = 0; j < 1000; j++) {
            test.increase();
          }
        }
      }.start();
    }

    while (Thread.activeCount() > 1) {
      Thread.yield();
    }
    System.out.println(test.inc);
  }
}
