package com.sample;

public class ThreadUsingRunnable {
	public static void main(String[] args) {
		Target target = new Target();
		Thread thread1 = new Thread(target);
		thread1.start();
		Thread thread2=new Thread(target);
		thread2.start();
				

	}
}

class Target implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello-- " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
