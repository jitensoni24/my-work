package com.dtech.lambda;

interface Consumer<T> {
	void accept(T t);
}

public class LambdaDemoOne {
	
	static Consumer<String> printLength = z -> System.out.println(z.length());
	
	public static void main(String[] args) {
		passLambda(printLength, "test");
	}
	
	static void passLambda(Consumer<String> c, String s) {
		c.accept(s);
	}
}
