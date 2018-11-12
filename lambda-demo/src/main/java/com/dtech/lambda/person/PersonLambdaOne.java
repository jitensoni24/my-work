package com.dtech.lambda.person;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;

public class PersonLambdaOne {

	
	public static void main(String[] args) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		String resource = IOUtils.toString(
				Resources.getResource("persons.json"), 
				Charset.defaultCharset());
		
		resource = IOUtils.toString(Resources.getResource("persons.json"), Charset.defaultCharset());

		List<Person> list = mapper.readValue(resource.getBytes(), new TypeReference<List<Person>>() {});
		
		list.stream().forEach(System.out::println);
		System.out.println("---------------------ALL persons imported from json ABOVE---------------------------------");
		
		
		String femaleName = list
				.stream()
				.filter(person -> person.getGender().equals(Gender.FEMALE))
				.map(p -> p.getName())
				.findFirst()
				.orElse(null);
		System.out.println("name of first female : " + femaleName);
		System.out.println("---------------------persons female name filtered above ---------------------------------");
		
		//given a list of people
		//create a map with name as the key and all the people as its value
		//eg stuart -> {id: 3 object and id : 6 obj}
		
		Map<String, List<Integer>> mapOfPerson = list
			.stream()
			.collect(groupingBy(Person::getName, mapping(Person::getAge, toList())));
		
		System.out.println(mapOfPerson);	
	}
}
