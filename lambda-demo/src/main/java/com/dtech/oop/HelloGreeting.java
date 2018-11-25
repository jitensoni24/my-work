package com.dtech.oop;

public class HelloGreeting implements Greeting {

	@Override
	public void perform() {
		System.out.println("Greeting oop behaviour : says : " + "hello");
	}

}
