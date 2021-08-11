package com.example.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @PackageName:com.example.demo.thread
 *
 * 主线程中再分出10个子线程去处理业务，有一个特点就是，每一个线程都会有一个前置线程。只能等前置线程运行完成后，才可返回当前线程处理结果。
 *
 *
 *
 */
public class JoinInfo {

  public static void main(String[] args) throws Exception{
    Thread previous = Thread.currentThread();
    previous.setName("First Thread..");
    for (int i = 0; i < 10; i++) {
      //每一个线程都要有一个前置线程的引用，要等前置线程终止后，才能从等待中返回。第一个前置线程为主线程。
      Thread thread = new Thread(new Domino(previous), String.valueOf(i));
      thread.start();

      previous = thread;
    }

    //处理主线程业务
    TimeUnit.SECONDS.sleep(5);
    System.out.println(Thread.currentThread().getName() + " terminate.");
  }

  static class Domino implements Runnable {

    private Thread thread;

    public Domino(Thread thread) {
      this.thread = thread;
    }

    @Override
    public void run() {
      try {
        //处理当前线程的业务
        System.out.println(Thread.currentThread().getName() + " is doing work.....");
        //做完后，进行等
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + " terminate.");
    }
  }
}
