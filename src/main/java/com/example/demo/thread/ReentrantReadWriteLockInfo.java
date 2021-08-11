package com.example.demo.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.swing.text.Keymap;

/**
 * @PackageName:com.example.demo.thread
 */
public class ReentrantReadWriteLockInfo {

  public static void main(String[] args) throws InterruptedException {
    CacheWithMap.put("Fred", "Good");

    for (;;){
      new Thread(new ReaderThread()).start();
      new Thread(new WriterThread()).start();
      new Thread(new ReaderThread()).start();
      TimeUnit.SECONDS.sleep(5);
    }


  }




  static class ReaderThread implements Runnable{
    @Override
    public void run() {
      try {
        String value = CacheWithMap.get("Fred").toString();
        System.out.println(value);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  static class WriterThread implements Runnable{
    @Override
    public void run() {
      try {
        CacheWithMap.put("Fred", UUID.randomUUID().toString()).toString();
        TimeUnit.MILLISECONDS.sleep(100);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  static class CacheWithMap{
    private static Map<String, Object> cacheData = new HashMap<>();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private static Lock readLock = readWriteLock.readLock();


    public static final Object get(String key) {
      readLock.lock();
      try {
        return cacheData.get(key);
      } finally {
        readLock.unlock();
      }
    }

    public static final Object put(String key, Object value) {
      writeLock.lock();
      try {
        return cacheData.put(key, value);
      } finally {
        writeLock.unlock();
      }
    }

    public static final void clear() {
      writeLock.lock();
      try {
        cacheData.clear();
      } finally {
        writeLock.unlock();
      }
    }

  }
}
