package com.dtech.soft.learn.task;

public class StatusTask implements Runnable {

	String instance;
	
	public StatusTask(String instance) {
		this.instance = instance;
	}
	
	public void run() {
		try {
			for(int i=0; i<5; i++) {
				System.out.println(instance);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
