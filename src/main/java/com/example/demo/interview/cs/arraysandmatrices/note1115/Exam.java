package com.example.demo.interview.cs.arraysandmatrices.note1115;

import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 我们提供一个类：
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 *
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 *示例 1:
 *
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 *
 * 示例 2:
 *
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 *
 *
 */
public class Exam {


    public static void main(String[] args) {

        FooBar fooBar = new FooBar(9);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
              fooBar.foo();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                fooBar.bar();
            }
        });

        thread1.start();
        thread2.start();

    }

}

class FooBar{

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    volatile boolean fin = true;

    public void foo() {
        lock.lock();
        try {
            for (int i=0; i< printCount; i++) {
                while (!fin) {
                    condition.await();
                }

                System.out.print("foo");

                fin = false;
                condition.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    public void bar() {
        lock.lock();
        try {
            for (int i=0; i< printCount; i++) {
                while (fin) {
                    condition.await();
                }

                System.out.print("bar");


                fin = true;
                condition.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    private Integer printCount;

    public FooBar(Integer printCount) {
        this.printCount = printCount;
    }

    public Integer getPrintCount() {
        return printCount;
    }

    public void setPrintCount(Integer printCount) {
        this.printCount = printCount;
    }
}
