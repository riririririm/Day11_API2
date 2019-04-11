package com.rim.thread;

public class ThreadTest1 {

	public static void main(String[] args) {
		ThreadEat te= new ThreadEat();
		ThreadTV tv = new ThreadTV();
		ThreadMusic tm = new ThreadMusic();
		//run메서드 호출 금지
		
		//te.start();
		//tv.start();
		
		Thread t = new Thread(tm,"a");
		Thread t2 = new Thread(tm,"b");
		t.start();
		t2.start();

	}

}
