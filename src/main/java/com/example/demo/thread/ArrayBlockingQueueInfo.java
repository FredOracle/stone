package com.example.demo.thread;

import com.google.common.base.Strings;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.units.qual.C;

/**
 * @PackageName:com.example.demo.thread
 */
public class ArrayBlockingQueueInfo {

  public static void main(String[] args) throws Exception {

    BlockingQueue<String> queue = new ArrayBlockingQueue(10);
    Thread producer = new Thread(new Producer(queue));
    Thread consumer = new Thread(new Consumer(queue));
    producer.start();
    consumer.start();


  }

  private static class Producer implements Runnable {

    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      while(true) {
        produce();
      }
    }

    private void produce() {
      try {
        String value = UUID.randomUUID().toString();
        boolean success = queue.offer(value);
        if (success) {
          System.out.println("Producer create a new value : " + value);
        } else {
          System.out.println("==============队列已满。等待消费者读取消息");
        }
        TimeUnit.SECONDS.sleep(2);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private static class Consumer implements Runnable {

    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      while(true) {
        consume();
      }
    }

    private void consume() {
      try {
        String value = queue.poll();
        if (Strings.isNullOrEmpty(value)) {
          System.out.println("****************消息队列为空，等待生产者生产消息。");
        } else {
          System.out.println("Consumer take a value : " + value);
        }
        TimeUnit.SECONDS.sleep(1);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

}
