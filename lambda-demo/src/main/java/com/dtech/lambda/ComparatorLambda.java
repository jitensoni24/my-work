package com.dtech.lambda;

import java.util.Comparator;

/**
 * Hello world!
 *
 */
public class ComparatorLambda 
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        Comparator<String> strcompare = new Comparator<String>() {
        	public int compare(String first, String second) {
        		return first.compareTo(second);
        	}
		};
		
		int result = strcompare.compare("a", "e");
		System.out.println(result);
		
		
		Comparator<String> lambda_1 = (String first, String second) -> {
			return first.compareTo(second);
		};
		System.out.println(lambda_1);
		
		Comparator<String> lambda_2 = (first, second) -> first.compareTo(second);
		System.out.println(lambda_2);
		
		
		System.out.println(lambda_2.compare("af", "ac"));
    }
}
