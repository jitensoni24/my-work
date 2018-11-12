package com.dtech.lambda;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringStreamDemo {
	public static void main(String[] args) {
		//contains "c" predicate with lambda expression
		Predicate<String> myC = (x) -> x.contains("c");
				
		List<String> namesWithC = 
				Stream
					.of("aaa", "aab", "aac", "bbc")
					.filter(myC)
					.map(String::toUpperCase)
					.collect(Collectors.toList());
		
		namesWithC.forEach(System.out::println);
	}
}
