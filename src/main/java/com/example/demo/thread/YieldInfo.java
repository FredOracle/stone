package com.example.demo.thread;

import javax.xml.transform.Source;

/**
 * @PackageName:com.example.demo.thread
 */
public class YieldInfo {

  static class Runner extends Thread{

    public Runner(String name) {
      super(name);
    }

    @Override
    public void run() {
      for (int i = 0; i <= 50; i++) {
        System.out.println("   " + this.getName() + "-------------" + i);
        if(i == 30){
          yield();
        }
      }
    }

  }

  public static void main(String[] args) {

    Runner runner1 = new Runner("Zhang");
    Runner runner2 = new Runner("Li");
    Runner runner3 = new Runner("Wang");
    Runner runner4 = new Runner("Hu");
    Runner runner5 = new Runner("Qian");

    runner1.start();
    runner2.start();

    runner3.start();
    runner4.start();
    runner5.start();
  }
}
