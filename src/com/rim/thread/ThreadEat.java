package com.rim.thread;

public class ThreadEat extends Thread{

	@Override
	public void run() {
		// 동시에 진행하고픈 코드
		eat();
	}
	
	private void eat() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(500);
				System.out.println("냠냠");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
}
