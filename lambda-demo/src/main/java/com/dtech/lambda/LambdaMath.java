package com.dtech.lambda;

import java.util.Arrays;

@FunctionalInterface
interface MyMultiply {
	public int multiply(Integer... numbers);
}

@FunctionalInterface
interface MyAdd {
	int add(Integer...integers);
}

public class LambdaMath {
	
	static MyMultiply multiply = (nos) -> {
//		Integer answer = 1;
//		Arrays.stream(nos).forEach(n -> System.out.println("arg : " + n));
//		for (int i=0; i<nos.length; i++) {
//			answer = nos[i] * answer;
//		}
//		return answer;
		int result = Arrays.stream(nos).reduce(1, (x,y) -> x*y);
		return result;
	};
	
	static MyAdd add_ = (nos) -> {
		int sum = Arrays.stream(nos).mapToInt(x -> x).sum();
		return sum;
	};
	
	public static void main(String[] args) {
		
		//multiply
		int result = multiply.multiply(2,2,2);
		System.out.println(result);
		
		//add
		System.out.println(add_.add(1,2,3));
		
	}
}
