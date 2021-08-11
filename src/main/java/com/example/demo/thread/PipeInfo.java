package com.example.demo.thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @PackageName:com.example.demo.thread
 */
public class PipeInfo {

  public static void main(String[] args) throws Exception {
    PipedWriter out = new PipedWriter();// 创建一个输出流
    PipedReader in = new PipedReader();// 创建一个输入流

    out.connect(in);//将输入流与输出流进行连接，否则在使用时会报IOException

    //创建一个线程
    Thread printThread = new Thread(new Print(in), "PrintThread");
    //启动线程，一直接收PipeReader内的数据
    printThread.start();


    int receive = 0;
    try {
      while ((receive = System.in.read()) != -1){
        out.write(receive);
      }
    } finally {
      out.close();
    }

  }

  /**
   * 输入类，用于接受PipedReader，把管道内的内容打印出来
   */
  static class Print implements Runnable{
    private PipedReader in;
    public Print(PipedReader in) {
      this.in = in;
    }

    @Override
    public void run() {
      int receive = 0;
      try {
        while ((receive = in.read()) != -1) {
          System.out.print((char) receive);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
