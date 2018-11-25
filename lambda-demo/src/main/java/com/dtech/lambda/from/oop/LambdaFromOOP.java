package com.dtech.lambda.from.oop;

import com.dtech.oop.Greeting;

public class LambdaFromOOP {

	static final Greeting helloGreeting = () -> System.out.println("Greeting lambda behaviour : says : " + "hello");
	
	public static void main(String[] args) {
		greet(helloGreeting);
	}
	
	public static void greet(Greeting g) {
		g.perform();
	}
}
