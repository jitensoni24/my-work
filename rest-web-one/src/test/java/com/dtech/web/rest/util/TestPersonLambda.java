package com.dtech.web.rest.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

import com.dtech.web.rest.resource.Person;

public class TestPersonLambda {

	private List<Person> list = Arrays.asList(new Person("jiten", "bbb", 39),
			new Person("paul", "aaa", 25), 
			new Person("chars", "abb", 39), 
			new Person("sam", "sss", 39));
	
	
	//sort list by last name
	 Comparator<Person> strcompare = (first, second) -> first.getLastName().compareTo(second.getLastName());
		
	
	//create method that prints all elements in the list
	
	
	//create method that prints all people that have last name not beginning with a
	 
	@Test
	public void sortPerson() {
		System.out.println("sort print");
		list.sort(strcompare);
		list.forEach(p -> System.out.println(p));
	}
	@Test
	public void testPrintAll() {
		System.out.println("all print");
		list.forEach(p -> System.out.println(p.toString()));
	}
	
	Predicate<Person> lastNameP = p -> !p.getLastName().startsWith("a");
	
	
	@Test
	public void printPersonNotA() {
		System.out.println("last name not with a print");
		list
			.forEach(p -> {
				if( lastNameP.test(p) ) {
					System.out.println(p);
				}
			});
	}
	
	
}
