package com.example.demo.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import scala.Int;

/**
 * @PackageName:com.example.demo.thread
 */
public class WaitNotifiInfo {

  static boolean flag = true;
  static Object lock  = new Object();

  public static void main(String[] args) throws InterruptedException {

    Thread waitThread = new Thread(new Wait(), "waitThread=========");
    waitThread.start();

    TimeUnit.SECONDS.sleep(1);

    Thread  notifyThread = new Thread(new Notify(), "notifyThread");
    notifyThread.start();
  }

  /**
   *  等待方（消费者）
   *  一般等待方原则：
   *  1。获取对象的锁
   *  2。如果条件不满足，就调用对象的WAIT方法，被通知后扔要检查条件
   *  3。条件满足则执行对应业务逻辑
   */
  static class Wait implements Runnable{
    @Override
    public void run() {
      synchronized (lock) {//获取对象锁
        while (flag) {//判断 条件是否满足，不满足调用wait()方法
          try {
            System.out.println(Thread.currentThread() + " Flag is true. wait @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            lock.wait();//不满足调用wait()方法
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        //满足，调用业务处理方法
        System.out.println(Thread.currentThread() + " flag is false, runnig @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

      }
    }
  }

  /**
   * 通知方（生产者）
   * 一般处理原则
   * 1。获得对象锁
   * 2。改变条件
   * 3。通知所有等待在对象上的线程
   */
  static class Notify implements Runnable {
    @Override
    public void run() {
      synchronized (lock) {//获得对象锁
        //处理业务
        System.out.println(Thread.currentThread() + " hold lock, Notify @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

        //改变条件
        flag = false;

        //通知所有等待在对象上的线程
        lock.notifyAll();
        try {
          Thread.sleep(5000);
        } catch (Exception e) {

        }
      }

      synchronized (lock) {
        System.out.println(Thread.currentThread() + " hold lock again. sleep @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        try {
          Thread.sleep(5000);
        } catch (Exception e) {

        }

      }
    }
  }
}



