package com.sample;
/**
 * Create a example using extending the Thread class
 * @author Power House
 *
 */
public class TreadUsingExtendingThreadClass {
	public static void main(String[] args) {
		Runner runner=new Runner();
		runner.start();
		
		Runner runner1=new Runner();
		runner1.start();
	}

}
class Runner extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello-" +i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
