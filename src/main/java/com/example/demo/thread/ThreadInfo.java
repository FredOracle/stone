package com.example.demo.thread;

public class ThreadInfo {

    public static void main(String[] args) {
        new ThreadWorker().start();
        new ThreadWorker("Fred").start();
        new ThreadWorker("Tom").start();
        new ThreadWorker("Alen").start();
    }

}

class ThreadWorker extends Thread {

    private volatile int ticket = 10;


    ThreadWorker(){
        super("Guest");
    }

    ThreadWorker(String name){
        super(name);
    }

    @Override
    public void run() {
        while (ticket > 0){
            try {
                Thread.sleep(300);
                System.out.println(this.getName() + "======还有余票=====" + this.ticket--);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            } finally {

            }
        }
    }
}


