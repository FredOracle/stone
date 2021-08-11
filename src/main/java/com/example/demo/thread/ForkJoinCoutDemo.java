package com.example.demo.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @PackageName:com.example.demo.thread
 *
 * 此类说明用Fork，Join来计算1+2+3+4+...+N
 *
 */
public class ForkJoinCoutDemo extends RecursiveTask<Integer> {

  private static final int THRESHOLD = 2;//阈值, 希望每个子任务最多执行二个数的相加，分割任务最小单位

  private int start;

  private int end;

  public ForkJoinCoutDemo(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  protected Integer compute() {
    int sum = 0;
    //如果任务足够小就计算任务
    boolean canCompute = (end - start) < THRESHOLD;
    if (canCompute) {
      for (int i = start; i <= end; i++) {
        sum += i;
      }
    } else {
      //如果任务大于阀值，就分裂成两个子任务计算
      int middle = (start + end) / 2;
      ForkJoinCoutDemo leftTask = new ForkJoinCoutDemo(start, middle);
      ForkJoinCoutDemo rightTask = new ForkJoinCoutDemo(middle + 1, end);

      //执行子任务
      leftTask.fork();
      rightTask.fork();

      //等待子任务执行完成，并得到其结果
      int leftResult = leftTask.join();
      int rightResult = rightTask.join();

      //最后合并子任务
      sum = leftResult + rightResult;
    }

    return sum;
  }

  public static void main(String[] args) {

    ForkJoinPool forkJoinPool = new ForkJoinPool();

    //生成一个计算任务， 负责计算1+2+3+4+5+6
    ForkJoinCoutDemo task = new ForkJoinCoutDemo(1, 6);

    //执行一个任务
    Future<Integer> result = forkJoinPool.submit(task);
    try {
      System.out.println(result.get());
    } catch (Exception e) {
      e.printStackTrace();
    }

  }


}
