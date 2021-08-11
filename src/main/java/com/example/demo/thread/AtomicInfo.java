package com.example.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @PackageName:com.example.demo.thread
 *
 * 介绍Atomic几种类型的使用
 */
public class AtomicInfo {

  public static void main(String[] args) {

    // AtomicInterge，先New一个，然后给个初始值。
    AtomicInteger ai = new AtomicInteger(10);
    System.out.println(ai.getAndIncrement());
    ai.compareAndSet(11,90);
    System.out.println(ai.get());


    // AtomicArray，针对数级原子操作
    int[] arr = new int[]{1,2,3};
    AtomicIntegerArray aia = new AtomicIntegerArray(arr);

    System.out.println(aia.get(0));

    aia.addAndGet(0,4);
    System.out.println(aia.get(0));
    System.out.println(arr[0]);


    // AtomicReference，针对对象的引用原子操作
    AtomicReference<User> atomicReference = new AtomicReference<>();

    //先生成一个要引用的对象
    User user = new User("Fred", 19);
    //把对象放到AtomicReference中
    atomicReference.set(user);

    System.out.println(atomicReference.get().getName());

    // 重新生成一个对象，改变属性内容。用当前新生的对象替换原先引用的对象
    User updatedUser = new User("FredAAA", 20);
    atomicReference.compareAndSet(user, updatedUser);
    System.out.println(atomicReference.get().getName());


    //针对对象字段的原子引用,
    AtomicIntegerFieldUpdater<User> aifu = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");
    updatedUser.setOld(99);

    aifu.getAndIncrement(updatedUser);
    System.out.println(aifu.get(updatedUser));

    AtomicLongFieldUpdater<User> alfu = AtomicLongFieldUpdater.newUpdater(User.class, "mate");
    User atomicUser = new User("Fred", 19, 99, 100L, 10);
    alfu.getAndIncrement(atomicUser);
    System.out.println(alfu.get(atomicUser));


    Integer loa = 100;
    AtomicStampedReference<Integer> asr = new AtomicStampedReference(loa, 1);
    if (asr.compareAndSet(100, 90, 1,2)) {
      System.out.println(asr.getStamp());
      System.out.println(asr.getReference());
    }


  }

  static class User {
    private String name;

    private Integer age;

    //对于对象字段做原子引时，必须要设置成public volatile类型
    public volatile int old;

    //对于对象字段做原子引时，必须要设置成public volatile类型
    public volatile long mate;

    public volatile Integer dan;


    public User(String name, Integer age) {
      this.name = name;
      this.age = age;
    }

    public User(String name, Integer age, int old, long mate, Integer dan) {
      this.name = name;
      this.age = age;
      this.old = old;
      this.mate = mate;
      this.dan = dan;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Integer getAge() {
      return age;
    }

    public void setAge(Integer age) {
      this.age = age;
    }

    public int getOld() {
      return old;
    }

    public void setOld(int old) {
      this.old = old;
    }

    public long getMate() {
      return mate;
    }

    public void setMate(long mate) {
      this.mate = mate;
    }

    public Integer getDan() {
      return dan;
    }

    public void setDan(Integer dan) {
      this.dan = dan;
    }
  }
}
