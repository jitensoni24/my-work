package com.dtech.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaFiles {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Comparator<String> strCompare = (first, second) -> first.compareTo(second);
		Comparator<Integer> intCompare = (a, b) -> a - b;
		
		Stream<String> rows = Files.lines(Paths.get("/Users/sonijit/git/my-work/lambda-demo/src/test/resources/lamb.csv"));
		
//		int c = (int)rows.map(l -> l.split(",")).filter(x -> x.length == 2).count();
//		System.out.println("total lines in the file x: " + c);
		

//		The code below will fetch all second column elements
//		List<String> ids = 
//				rows
//				.map(x -> x.split(","))
//				.filter(x -> x.length > 1)
//				.skip(1)
//				.map(x -> x[1])
//				.collect(Collectors.toList());
//		
//		ids.stream().forEach(x -> System.out.println(x));
//		
//		rows.close();
		
//		create a map of id and name
		Map<String, String> idmap = rows
				.skip(1)
				.map(row -> row.split(","))
				.filter(array -> array.length == 3)
				.filter(array -> Double.parseDouble(array[2]) > 23)
				.collect(Collectors.toMap(array -> array[0], array -> array[1]));
		
		idmap
			.entrySet()
			.stream()
			.forEach(x -> System.out.println(x.getKey() +"-"+ x.getValue()));
		
		
	}
	
}
