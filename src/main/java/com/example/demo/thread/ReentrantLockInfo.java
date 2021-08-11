package com.example.demo.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @PackageName:com.example.demo.thread
 */
public class ReentrantLockInfo {

  private static Lock fairLock = new ReentrantLock(true);
  private static Lock unfairLock = new ReentrantLock(false);


  private static class Job extends Thread {
    private Lock lock;
    public Job(Lock lock) {
      this.lock = lock;
    }

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName());
      System.out.println(Thread.currentThread().getName());
    }
  }

  private static class ReentrantLock2 extends ReentrantLock {
    public ReentrantLock2(boolean fair) {
      super(fair);
    }

    @Override
    public Collection<Thread> getQueuedThreads() {
      List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
      Collections.reverse(arrayList);
      return arrayList;
    }

  }

  public static void main(String[] args) {

  }


}
