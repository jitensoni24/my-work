package com.bskyb.db.memory;

public class MemoryTest {

	public static void main(String[] args) throws Exception {
		
		AddTask task = new AddTask();
		
		Thread t1 =new Thread(task);
		
		t1.start();
		
		Thread t2 =new Thread(task);
		
		t2.start();
	}
}
