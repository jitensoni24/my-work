package com.dtech.lambda;

import java.util.stream.IntStream;

public class IntStreamDemo {

	public static void main(String[] args) {
		int sum = IntStream
			.range(1, 10)
			.sum();
		System.out.println("Range 1,10 : sum : " + sum);
		
		double average = IntStream
			.range(1, 10)
			.map(x -> x*x)
			.average()
			.orElse(0);
			//.ifPresent(System.out::println);
		
		System.out.println("Range 1,10 : average : " + average);
	}
}
