package com.example.demo.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @PackageName:com.example.demo.thread CyclicBarrier用于多线程计算，最后进行合并计算结果的场景。
 */
public class CyclicBarrierInfo {


  public static void main(String[] args) throws ExecutionException, InterruptedException {

    WorkGather.play();
    StaffManager.play();
//    ColleaguePlay.play();
  }

  static class WorkGather {

    private static CyclicBarrier cb = new CyclicBarrier(4, new Gather());
    private static ConcurrentHashMap<Integer, List> data = new ConcurrentHashMap<Integer, List>();

    public static void play() {
      data.put(0, Arrays.asList(1, 2, 4, 5, 3, 2));
      data.put(1, Arrays.asList(4, 5, 9, 2, 1, 2));
      data.put(2, Arrays.asList(8, 9, 6, 3, 2, 1));
      data.put(3, Arrays.asList(4, 7, 8, 4, 3, 1));
      Executor executor = new ThreadPoolExecutor(4, 10, 1000, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(10),
          Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
      for (int i = 0; i < 4; i++) {
        executor.execute(new Worker(data.get(i)));
      }
      cb.reset();
    }

    private static class Worker implements Runnable {

      private List<Integer> list;

      Worker(List list) {
        this.list = list;
      }

      @Override
      public void run() {
        AtomicReference<Integer> sum = new AtomicReference<>(0);
        try {
          list.stream().forEach(item -> sum.updateAndGet(v -> v + item));
          System.out.println(sum.get() + "子线程处理任务。。。。。。" + Thread.currentThread().getName());
          cb.await();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    /**
     * 汇总线程，这是所有线程都处理完毕后进行的后续处理线程
     */
    private static class Gather implements Runnable {

      @Override
      public void run() {
        try {
          System.out.println("进行汇总处理，总共4个线程，已处理完毕。。。。。。。");
          cb.await();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

  }

  static class StaffManager {
    static ConcurrentHashMap<Integer, List> data = new ConcurrentHashMap<Integer, List>();
    public static void play() throws InterruptedException, ExecutionException {
      data.put(0, Arrays.asList(1, 2, 4, 5, 3, 2));
      data.put(1, Arrays.asList(4, 5, 9, 2, 1, 2));
      data.put(2, Arrays.asList(8, 9, 6, 3, 2, 1));
      data.put(3, Arrays.asList(4, 7, 8, 4, 3, 1));
      ExecutorService executorService = new ThreadPoolExecutor(4, 10, 1000, TimeUnit.MICROSECONDS,
          new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new AbortPolicy());

      for (int i = 0; i < 4; i++) {
        FutureTask<Integer> futureTask = new FutureTask<>(new Staff(data.get(i)));
        executorService.submit(futureTask);
        System.out.println(futureTask.get());
      }

      System.out.println("========================================");
      CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);
      for (int i = 0; i < 4; i++) {
        completionService.submit(new Staff(data.get(i)));
      }
      for (int i = 0; i < 4; i++) {
        System.out.println(completionService.take().get());
      }

      executorService.shutdown();
    }

    /**
     * 各个处理业务的子线程。并在最后把处理结果返回 返回值类型为Integer，入参为List
     */
    private static class Staff implements Callable<Integer> {

      private List<Integer> list;

      public Staff(List<Integer> list) {
        this.list = list;
      }

      @Override
      public Integer call() throws Exception {
        AtomicReference<Integer> sum = new AtomicReference<>(0);
        list.stream().forEach(item -> sum.updateAndGet(v -> v + item));
        return sum.get();
      }
    }

    private static class Manager implements Callable<Integer> {

      private List<Integer> list;

      public Manager(List<Integer> list) {
        this.list = list;
      }

      @Override
      public Integer call() throws Exception {
        AtomicReference<Integer> sum = new AtomicReference<>(0);
        list.stream().forEach(item -> sum.updateAndGet(v -> v + item));
        return sum.get();
      }
    }

  }

  static class ColleaguePlay {

    public static void play() {
      ExecutorService pool = new ThreadPoolExecutor(3, 10, 1000, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(10),
          new AbortPolicy());

      final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

      for (int i = 0; i < 3; i++) {
        Runnable runnable = new Runnable() {
          @Override
          public void run() {
            try {
              TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

            System.out.println(
                Thread.currentThread().getName() + "到达地点一，当前等待人数为" + (cyclicBarrier.getNumberWaiting() + 1) + (
                    cyclicBarrier.getNumberWaiting() + 1 == 3 ? "继续出发" : "继续等待"));

            try {
              //障碍等待点
              cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
              e.printStackTrace();
            }

            try {
              TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

            System.out.println(
                Thread.currentThread().getName() + "到达地点二，当前等待人数为" + (cyclicBarrier.getNumberWaiting() + 1) + (
                    cyclicBarrier.getNumberWaiting() + 1 == 3 ? "继续出发" : "继续等待"));

            try {
              //障碍等待点
              cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
              e.printStackTrace();
            }

            try {
              TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

            System.out.println(
                Thread.currentThread().getName() + "到达地点三，当前等待人数为" + (cyclicBarrier.getNumberWaiting() + 1) + (
                    cyclicBarrier.getNumberWaiting() + 1 == 3 ? "人全到了，出发" : "继续等待"));

            try {
              //障碍等待点
              cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
              e.printStackTrace();
            }
          }
        };

        pool.execute(runnable);
      }
      pool.shutdown();


    }
  }


}
