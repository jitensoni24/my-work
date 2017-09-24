package com.dtech.soft.learn.intf;

public class FifthWay {

	public static void main(String[] args) {
		System.out.println("thread main start");
		
		Thread t = new Thread(new Runnable() {
			public void run() {
				for(int i=0; i<5; i++) {
					System.out.println(i);
				}
			}
		});
		
		t.start();
		
		System.out.println("thread main end");
	}
}
