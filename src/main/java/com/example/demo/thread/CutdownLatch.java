package com.example.demo.thread;

import io.netty.util.concurrent.DefaultThreadFactory;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * The type Cutdown latch.
 */
public class CutdownLatch {

  /**
   * 初始化需要等待的 3 个事件<p/>
   */
  private static final int RUNNER_COUNT = 10;
  private static CountDownLatch begin = new CountDownLatch(1);
  private static CountDownLatch end = new CountDownLatch(RUNNER_COUNT);
  ThreadFactory factory = new DefaultThreadFactory("poolName", true, Thread.MIN_PRIORITY, null);

  private static ExecutorService exec = Executors.newFixedThreadPool(20);

//  private static ThreadPoolExecutor =


  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws InterruptedException the interrupted exception
   */
  public static void main(String[] args) throws InterruptedException {

    ClassLoader a = null;
    /**
     * 创建 3 个线程去执行事件
     */
    System.out.println("比赛开始 ...");

    for (int i = 0; i < RUNNER_COUNT; i++) {
      final int NO = i + 1;
      exec.submit(new Worker(NO, begin, end));
    }
    begin.countDown();
    end.await();
    System.out.println("比赛结束 ...");
    exec.shutdown();

//    new Thread(() -> {
//      System.out.println("*****_*****");
//      latch.countDown();
//    }).start();
//
//    new Thread(() -> {
//      System.out.println("*****_*****");
//      latch.countDown();
//    }).start();
//
//    new Thread(() -> {
//      System.out.println("*****_*****");
//      latch.countDown();
//    }).start();

    // 在计数器为 0 之前会一直阻塞

    System.out.println("~~~~~_~~~~~");
  }

}

class Worker extends Thread {

  private Integer runner_no;
  private CountDownLatch begin;
  private CountDownLatch end;

  public Worker(Integer runner_no, CountDownLatch begin, CountDownLatch end) {
    this.runner_no = runner_no;
    this.begin = begin;
    this.end = end;
  }

  @Override
  public void run() {
    try {

      Thread.sleep((long) (Math.random() * 10000));
      System.out.println("选手No." + runner_no + " 到达终点。");
      begin.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      end.countDown();
    }

  }
}
