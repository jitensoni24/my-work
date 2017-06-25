package com.dtech.java8.sample.lambda.ch1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareStr 
{
    public static void main( String[] args )
    {
    	existingWay(Arrays.asList("cat", "hat", "mat"));
    	
    	newWay(Arrays.asList("rat", "fat", "bat"));

    	newWay2(Arrays.asList("man", "fan"));
    }

    private static void newWay2(List<String> asList) {
		asList.sort((a,b) -> a.compareTo(b));
		asList.forEach(i -> System.out.println(i));
	}

	/**
     * Compare using lambda expression *1
     * @param sortMe
     */
	private static void newWay(List<String> sortMe) {
		Collections.sort(sortMe, (String a, String b) -> {
			return a.compareTo(b);
		});
		sortMe.forEach(s -> System.out.println(s));
	}

	/**
	 * Compare using existing string compare
	 * @param sortMe
	 */
	private static void existingWay(List<String> sortMe) {
		Collections.sort(sortMe, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
    	sortMe.forEach(s -> System.out.println(s));
	}
}
