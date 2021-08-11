package com.example.demo.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @PackageName:com.example.demo.thread
 *
 *
 */
public class ConditionInfo {

  public static void main(String[] args) throws InterruptedException {

    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

//    Thread thread1 = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        try {
//          lock.lock();
//          System.out.println("I need a signal " + this);
//
//          condition.await();
//
//          System.out.println("I get a signal" + this);
//        } catch (Exception e) {
//          e.printStackTrace();
//        } finally {
//          lock.unlock();
//        }
//      }
//    }, "thread1");
//
//    thread1.start();
//
//    Thread thread2 = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        try {
//          lock.lock();
//          System.out.println("I get");
//          Thread.sleep(500);
//          System.out.println("I send a signal");
//          condition.signal();
//        } catch (Exception e) {
//          e.printStackTrace();
//        } finally {
//          lock.unlock();
//        }
//      }
//    }, "thread2");
//
//    thread2.start();


    final Business business = new Business();
    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 50; i++) {
          business.sub(i);
        }
      }
    }).start();

    for (int i = 0; i < 50; i++) {
      business.main(i);
    }


    //Example 2//////////////////////////////////////////////////////
    final Lock lock1 = new ReentrantLock();
    final Condition condition1 = lock1.newCondition();

    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          lock.lock();
          System.out.println("我的工作已经作完，我要等一个信号： " + this);
          TimeUnit.SECONDS.sleep(4);
          condition.await();
          System.out.println("我已经等到信息了：" + this);

        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
        }
      }
    }, "Thread1");
     thread1.start();


    TimeUnit.SECONDS.sleep(4);

     Thread thread2 = new Thread(new Runnable() {
       @Override
       public void run() {
         try {
           lock.lock();
           System.out.println("我拿到了锁。。");
           TimeUnit.SECONDS.sleep(4);
           System.out.println("我要发出一个信息，通知其它人。。。。");
           condition.signal();
         } catch (Exception e) {
           e.printStackTrace();
         } finally {
           lock.unlock();
         }
       }
     }, "Thread2");
     thread2.start();


  }

  static class Business {
    private Lock lock =new ReentrantLock();
    private boolean isMain = true;
    private Condition condition = lock.newCondition();

    public void main(int i) {
      lock.lock();
      try {
        while (!isMain) {
          condition.await();
        }

        for (int j = 0; j < 100; j++) {
          System.out.println("main is looping: " + j + " in " + i);
        }

        isMain =false;
        condition.signal();

      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }

    public void sub(int i) {
      lock.lock();
      try {
        while (isMain) {
          condition.await();
        }
        for (int j = 0; j < 10; j++) {
          System.out.println("sub is looping ： " + j + " in " + i);
        }
        isMain = true;
        condition.signal();
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }

  }
}
