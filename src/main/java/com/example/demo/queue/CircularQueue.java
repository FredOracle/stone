package com.example.demo.queue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CircularQueue {

  //队列最大容量
  private final int MAX_SIZE = 5;

  //队头
  private int front = 0;

  //队尾
  private int rear = 0;

  //队列数据区
  String[] data = new String[MAX_SIZE];

  /**
   * 向队列中添加数据，如果队头与队尾重合，则说明队列已满，返回False，否则把数据添加到队列并返回True
   *
   * @param value 待添加的数据
   * @return
   */
  public boolean add(String value) {
    //(rear+1)说明数组0位置不存数据，放指针
    if ((rear + 1) % MAX_SIZE == front) {
      return Boolean.FALSE;
    }
    rear = (rear + 1) % MAX_SIZE;
    data[rear] = value;
    return Boolean.TRUE;
  }

  public String delete() {
    if (rear == front) {
      return null;
    }
    log.info("Front {} , Rear {} ", front, rear);

    return data[++front];
  }

  public boolean isEmpty() {
    return rear == front;
  }


  public static void main(String[] args) {

    CircularQueue queue = new CircularQueue();
//		log.info("Add one data result {}",queue.add("1"));
//		log.info(queue.delete());
    log.info("Add one data result {}", queue.add("1"));
    log.info("Add one data result {}", queue.add("2"));
    log.info("Add one data result {}", queue.add("3"));
    log.info("Add one data result {}", queue.add("4"));
    log.info("Add one data result {}", queue.add("5"));
    log.info("Delete data {}", queue.delete());
    log.info("Delete data {}", queue.delete());
    log.info("Delete data {}", queue.delete());
    log.info("Delete data {}", queue.delete());
    log.info("Delete data {}", queue.delete());
    log.info("Add one data result {}", queue.add("5"));
    log.info("Add one data result {}", queue.add("6"));
    log.info("Add one data result {}", queue.add("7"));

  }

}
