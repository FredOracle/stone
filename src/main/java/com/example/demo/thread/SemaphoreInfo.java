package com.example.demo.thread;

import com.example.demo.thread.YieldInfo.Runner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/**
 * @PackageName:com.example.demo.thread 信号量，多线程环境下，负责协调各个线程的一种设施。 如一段高速路，只能通过10辆汽车在上面行驶。信号量就相当于红绿灯。当绿灯时，车辆可以进入高速公路。当公路上满10辆时，灯会转为红灯。第11辆车要等待。
 * 当有车驶出公路时，灯就转为绿灯。又可以让车进入公路。 信号量有一个acquire(),和release()接口。Acquire表示获取一个许可。如果获取不到就等待。Release()表示释放一个许可。
 */
public class SemaphoreInfo {

  public static void main(String[] args) {

    ExecutorService pool = new ThreadPoolExecutor(3, 10, 1000, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(10),
        new AbortPolicy());

    final Semaphore semaphore = new Semaphore(3, true);

    for (int i = 0; i < 10; i++) {
      Runnable runnable = new Runnable() {
        @Override
        public void run() {
          try {
            //获取信号量
            semaphore.acquire();
          } catch (Exception e){
            e.printStackTrace();
          }

          System.out.println("Thread" + Thread.currentThread().getName() + "进入当前系统的并发数量是： " + (3-semaphore.availablePermits()));

          try {
            TimeUnit.SECONDS.sleep(2);
          } catch (Exception e) {
            e.printStackTrace();
          }

          System.out.println("Thread" + Thread.currentThread().getName() + "即将离开。。。");
          //释放信号量
          semaphore.release();
          System.out.println("Thread" + Thread.currentThread().getName() + "已经离开， 当前系统的并发数是： " + (3-semaphore.availablePermits()));
        }
      };
      pool.execute(runnable);
    }
  }
}
