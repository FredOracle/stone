package com.example.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @PackageName:com.example.demo.thread
 *
 */
public class ThreadLocalInfo {

  public static void main(String[] args) {

    var worker1 = new Thread(new RunWorker("Fred", new AtomicInteger(10)));
    var worker12 = new Thread(new RunWorker("Hello", new AtomicInteger(10)));

    worker1.start();
    worker12.start();
  }

  static class RunWorker implements Runnable {

    private String task;

    private AtomicInteger sum;

    private ThreadLocal<String> workInfo = new ThreadLocal<>(){
      @Override
      protected String initialValue() {
        return task;
      }
    };

    public RunWorker(String task, AtomicInteger sum) {
      this.task = task;
      this.sum = sum;
    }

    @Override
    public void run() {
      System.out.println(workInfo.get());

      if ("Fred".equals(task)) {
        this.sum.getAndAdd(4);
      } else {
        this.sum.getAndAdd(1);
      }

      System.out.println(Thread.currentThread().getName() + "===" + workInfo.get() + "====" + this.sum.get());
    }
  }
}
