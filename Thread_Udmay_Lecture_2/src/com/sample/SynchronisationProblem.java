package com.sample;

public class SynchronisationProblem {
	private int count = 0;

	public  void increment() {
		count++;
	}

	public static void main(String[] args) throws InterruptedException {
		new SynchronisationProblem().incrementCount();
	}

	public void incrementCount() throws InterruptedException {

		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}

			}
		});
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println("Count: " + count);
	}
}