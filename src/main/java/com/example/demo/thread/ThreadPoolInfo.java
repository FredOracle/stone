package com.example.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @PackageName:com.example.demo.thread
 */
public class ThreadPoolInfo {

  private static ExecutorService pool;


  public static void main(String[] args) {

    //直接提交队列
    //    synchronousQueue();


      //有界的任务队列
    arrayBlockingQueue();


      //无界的任务队列
//    linkedBlockingDeque();

    //优先任务队列
//    priorityBlockingQueue();

  }


  private static void synchronousQueue() {
    //创建直接提交队列。主要是使用SynchronousQueue。 设置为SynchronousQueue队列，SynchronousQueue是一个特殊的BlockingQueue，它没有容量，没执行一个插入操作就会阻塞，需要再执行一个删除操作才会被唤醒，反之每一个删除操作也都要等待对应的插入操作。
    pool = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MICROSECONDS, new SynchronousQueue<>(),
        Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    for (int i = 0; i < 3; i++) {
      pool.execute(new ThreadTaskP());
    }
  }

  private static void arrayBlockingQueue() {
    //创建有界的任务队列， 主要是使用ArrayBlockingQueue。 有界的任务队列可以使用ArrayBlockingQueue实现
    pool = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(10),
        Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    for (int i = 0; i < 3; i++) {
      pool.execute(new ThreadTaskP());
    }
  }

  private static void linkedBlockingDeque() {
    //创建无界的任务队列， 主要使用LinkedBlockingDeque。 无界任务队列可以使用LinkedBlockingQueue实现
    pool = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>(),
        Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    for (int i = 0; i < 3; i++) {
      pool.execute(new ThreadTaskP());
    }
  }

  private static void priorityBlockingQueue() {
    //优先任务队列， 主要是使用PriorityBlockingQueue。 优先任务队列通过PriorityBlockingQueue实现
    pool = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MICROSECONDS, new PriorityBlockingQueue<>(),
        Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    for (int i = 0; i < 20; i++) {
      pool.execute(new PriortyThreadTask(i));
    }
  }

  /**
   * 任务类
   */
  private static class ThreadTaskP implements Runnable {

    public ThreadTaskP() {

    }

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName());
    }
  }

  private static class PriortyThreadTask implements Runnable, Comparable<PriortyThreadTask> {

    private int priority;

    public int getPriority() {
      return priority;
    }

    public void setPriority(int priority) {
      this.priority = priority;
    }

    public PriortyThreadTask() {

    }

    public PriortyThreadTask(int priority) {
      this.priority = priority;
    }

    @Override
    public int compareTo(PriortyThreadTask o) {
      return this.priority > o.priority ? -1 : 1;
    }

    @Override
    public void run() {

      try {
        Thread.sleep(1000);
        System.out.println("priority: " + this.priority + ", ThreadName:　" + Thread.currentThread().getName());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }


}





