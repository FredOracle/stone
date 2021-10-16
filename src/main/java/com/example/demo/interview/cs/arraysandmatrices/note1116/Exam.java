package com.example.demo.interview.cs.arraysandmatrices.note1116;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 假设有这么一个类：
 * <p>
 * class ZeroEvenOdd {
 * public ZeroEvenOdd(int n) { ... }      // 构造函数
 * public void zero(printNumber) { ... }  // 仅打印出 0
 * public void even(printNumber) { ... }  // 仅打印出 偶数
 * public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * <p>
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 * <p>
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * <p>
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出："0102030405"
 */
public class Exam {

    public static void main(String[] args) {
        Integer printNumber = 5;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(printNumber);

        Thread thread_zero = new Thread(new Runnable() {
            @Override
            public void run() {
                zeroEvenOdd.zero(printNumber);
            }
        });

        Thread thread_even = new Thread(new Runnable() {
            @Override
            public void run() {
                zeroEvenOdd.even(printNumber);
            }
        });

        Thread thread_odd = new Thread(new Runnable() {
            @Override
            public void run() {
                zeroEvenOdd.odd(printNumber);
            }
        });

        thread_zero.start();
        thread_even.start();
        thread_odd.start();
    }
}

class ZeroEvenOdd {

    Lock lock = new ReentrantLock();
    Condition condition_zero = lock.newCondition();
    Condition condition_even = lock.newCondition();
    Condition condition_odd = lock.newCondition();

    volatile int fin = 0;//1为偶数，-1为奇数。0为中间分隔数
    volatile Integer innerPrintNumber = 0;

    /**
     * 打印0
     * @param printNumber
     */
    public void zero(int printNumber) {
        lock.lock();
        try {
            if (fin != 0) {
                condition_even.await();
                condition_odd.await();
            }
            System.out.print(0);
            innerPrintNumber = innerPrintNumber + 1;

            if (innerPrintNumber % 2 == 0) {
                fin = 1;
                condition_odd.signal();
            } else {
                fin = -1;
                condition_even.signal();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印奇数
     */
    public void even(int printNumber) {
        lock.lock();

        try {
            if (innerPrintNumber <= printNumber) {
                // 0, 1
                if (fin >= 0) {
                    condition_zero.await();
                    condition_odd.await();
                }

                System.out.print(innerPrintNumber);

                fin = 0;
                condition_zero.signal();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    /**
     * 打印偶数
     */
    public void odd(int printNumber) {
        lock.lock();

        try {
            while (innerPrintNumber <= printNumber) {
                if (fin <= 0) {
                    condition_zero.await();
                    condition_even.await();
                }

                System.out.print(innerPrintNumber);

                fin = 0;
                condition_zero.signal();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    private Integer printNumber;

    public Integer getPrintNumber() {
        return printNumber;
    }

    public void setPrintNumber(Integer printNumber) {
        this.printNumber = printNumber;
    }

    public ZeroEvenOdd(Integer printNumber) {
        this.printNumber = printNumber;
    }
}

