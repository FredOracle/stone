package com.example.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;

/**
 * @PackageName:com.example.demo.thread
 */
public class ExchangerInfo {

  public static void main(String[] args) {
    ExecutorService threadPool = new ThreadPoolExecutor(2, 4, 1000, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(4),
        new AbortPolicy());

    final Exchanger exchanger = new Exchanger();

    //第一个线程
    threadPool.execute(new Runnable() {

      @SneakyThrows
      @Override
      public void run() {
        String data1 = "Love";
        System.out.println("Thread" + Thread.currentThread().getName()+"正在把数据"+data1+"放入！");

        TimeUnit.SECONDS.sleep(2);

        String data2 = null;
        try {
          //此线程执行了exchange方法，那么他会等另一个线程执行exchange方法
          data2 = (String) exchanger.exchange(data1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        System.out.println("Thread" +Thread.currentThread().getName()+"得到数据"+data2);

      }
    });

    //第二个线程
    threadPool.execute(new Runnable() {
      @Override
      public void run() {

        String data1 = "Hate";
        System.out.println("Thread"+Thread.currentThread().getName()+"正在把数据"+data1+"存入。" );
        try {
          TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        String data2 = null;
        try {
          //此线程执行了exchange方法，他会等其它线程也执行exchange方法，如果发现有其它线程执行exchange方法后，就会交换结果。
          data2 = (String) exchanger.exchange(data1);
        } catch (InterruptedException e){
          e.printStackTrace();
        }

        System.out.println("Thread"+Thread.currentThread().getName() + "得到数据"+data2);

      }
    });

    threadPool.shutdown();

  }

}
