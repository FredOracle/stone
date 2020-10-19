package com.example.demo.thread;

public class RunnableInfo {

	public static void main(String[] args) throws Exception{

		RunnalbleWorker worker = new RunnalbleWorker();

		for (int i = 0; i < 50; i++) {
			new Thread(worker, "Tom" + i).start();
		}
//		new Thread(worker, "Fred").start();
//		new Thread(worker, "Alen").start();

	}
}

class RunnalbleWorker implements Runnable{

	private int tickets = 10;

	@Override
	public synchronized void run() {
		if (tickets > 0){
			try {
				Thread.sleep(100);
				System.out.println(Thread.currentThread().getName() + "======还有余票=====" + tickets--);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}

	}
}




