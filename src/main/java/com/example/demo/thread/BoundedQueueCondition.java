package com.example.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @PackageName:com.example.demo.thread
 *
 * 自定义一个有限队列，通过构造方法来定义队列长度。提供添加和移除方法。通过Lock,和Condition来保证线程安全
 */
public class BoundedQueueCondition {

  //存放数据的队列
  private Object[] items;

  //添加位置，删除位置，队列当前存放的总数
  private int addIndex, removeIndex, count;


  private Lock lock = new ReentrantLock();

  private Condition notEmpty = lock.newCondition();

  private Condition notFull = lock.newCondition();

  public BoundedQueueCondition(int size) {
    items = new Object[size];
  }

  /**
   * 添加一个元素，如果数组满了，则添加线程进入等待状态，直到收到有空位让出来的通知。
   * @param t
   * @throws InterruptedException
   */
  public void add(Object t) throws InterruptedException {
    lock.lock();

    try {
      //当数组长度和数组内的数量相同时，表明数组已放满了，当前线程进入等待状态。
      while (count == items.length) {
        notFull.await();
      }

      //放放元素
      items[addIndex] = t;

      //元素数量+1
      ++count;

      if (++addIndex == items.length) {
        addIndex = 0;//如果数组满了，则从头开始放置
      }

      //数组元素不等于数组长度，表示数组没满，通知notEmpty线程，可以添加元素
      notEmpty.signal();
    } finally {
      lock.unlock();
    }
  }

  /**
   * 由头部删除一个元素，如果数组空了，则删除线程进入等待状态，直到有新元素添加
   * @return
   * @throws InterruptedException
   */
  public Object remove() throws InterruptedException {
    lock.lock();
    try {
      //如果数组内没有元素，则不能删除，当前线程进入等待状态。
      while (count == 0){
        notEmpty.await();
      }

      Object x = items[removeIndex];
      if (++removeIndex == items.length) {
        removeIndex = 0;
      }
      --count;

      notFull.signal();
      return x;
    } finally {
      lock.unlock();
    }
  }

}
