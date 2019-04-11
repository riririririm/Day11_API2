package com.rim.thread;

public class ThreadMusic implements Runnable {
	private int ticket = 10;

	private synchronized void buyTicket() {
		ticket--;
		if (ticket < 1) {
			System.out.println("티켓매진");
		} else {

			System.out.println(Thread.currentThread().getName() + "님이 들어옴");
			System.out.println("ticket:" + ticket);
		}
	}

	@Override
	public void run() {
		this.music();
	}

	private void music() {

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + ": 음악재생중");
				buyTicket();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
