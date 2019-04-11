package com.rim.thread;

public class ThreadTV extends Thread{
	
	@Override
	public void run() {
		tv();
	}

	private void tv() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(1000);
				System.out.println("tv보기");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
