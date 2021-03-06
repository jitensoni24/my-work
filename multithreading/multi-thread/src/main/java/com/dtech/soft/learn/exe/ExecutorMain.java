package com.dtech.soft.learn.exe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.dtech.soft.learn.task.StatusTask;

public class ExecutorMain {

	public static void main(String[] args) {
		
		System.out.println("main start");
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		String[] tasks = {"vod", "linear"};
		
		for (String cmd : tasks) {
			if(cmd.equals("vod")) {
				es.submit(new StatusTask("vod"));
			} else if(cmd.equals("linear")) {
				es.submit(new StatusTask("linear"));
			}
		}
		
		es.shutdown();
		System.out.println("main end");
	}
}
