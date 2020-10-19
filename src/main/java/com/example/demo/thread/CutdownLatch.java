package com.example.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class CutdownLatch {

    /**
     * 初始化需要等待的 3 个事件
     */
    private static CountDownLatch latch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {

        ClassLoader a = null;
        /**
         * 创建 3 个线程去执行事件
         */
        new Thread(() -> {
            System.out.println("*****_*****");
            latch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("*****_*****");
            latch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("*****_*****");
            latch.countDown();
        }).start();

        // 在计数器为 0 之前会一直阻塞
        latch.await();

        System.out.println("~~~~~_~~~~~");
    }
}
