package com.example.demo.thread;

import com.mysql.jdbc.TimeUtil;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class FutureTaskInfo extends FutureTask<String> {


  public FutureTaskInfo(Callable<String> callable) {
    super(callable);
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    ExecutorService executorService = new ThreadPoolExecutor(4, 10, 1000, TimeUnit.MICROSECONDS,
        new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new AbortPolicy());

    CallableThreadInfo cThreadInfo = new CallableThreadInfo();
    FutureTask<String> fTask = new FutureTaskInfo(cThreadInfo);

    executorService.submit(fTask);

    System.out.println(fTask.get());

    FutureTask<Integer> result = new FutureTask<>(new Task());
    executorService.submit(result);

    TimeUnit.SECONDS.sleep(2);
    System.out.println("Task 运行结果 ： " + result.get());


    executorService.shutdown();
  }

  static class CallableThreadInfo implements Callable<String> {

    @Override
    public String call() throws Exception {
      System.out.println("===========CallableThreadInfo============");
      return UUID.randomUUID().toString();
    }
  }


  static class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
      System.out.println("子线程在进行计算。。。。");
      TimeUnit.SECONDS.sleep(3);
      int sum = 0;
      for (int i = 0; i < 100; i++) {
        sum += 1;
      }
      return sum;
    }
  }
}
