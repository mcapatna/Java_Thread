package com.sample;

/**
 * @author Power House
 */
public class CacheingProblemInThread {
	private static volatile int MY_INT = 0;

	public static void main(String[] args) {
		Target target = new Target();
		Source source = new Source();

		target.start();
		source.start();
	}

	static class Target extends Thread {
		@Override
		public void run() {
			int local_value = MY_INT;
			while (local_value < 5) {
				if (local_value != MY_INT) {
					System.out.println("Chaning the value of Local value " + MY_INT);
					local_value = MY_INT;
				}
			}
		}
	}

	static class Source extends Thread {
		@Override
		public void run() {
			int local_value = MY_INT;
			while (local_value < 5) {
				System.out.println("Incrementing the value of MY_INT " + (local_value + 1));
				MY_INT = ++local_value;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}