package com.dtech.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsDemo {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1,2,3,4,2,5,5,4,6);
		
		int variable = 4;
		
		//print less than int 4
		Predicate<? super Integer> predicate = x -> x < variable;
		
		integers.stream().filter(predicate).forEach(System.out::println);
		
		//print distinct or get the set from the list of integers
		Set<Integer> toSet = integers.stream().collect(Collectors.toSet());
		toSet.forEach(System.out::println);
		
	}
}
