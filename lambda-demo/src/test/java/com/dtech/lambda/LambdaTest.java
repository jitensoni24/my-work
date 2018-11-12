package com.dtech.lambda;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.Resources;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

public class LambdaTest {

	String resource;
	
	@Before
	public void init() throws Exception {
		resource = IOUtils.toString(Resources.getResource("vod.json"), Charset.defaultCharset());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void streamGetWithId() throws Exception {
/*		Predicate<Integer> child1234 = (value) -> value.intValue() == 1234;
*/		
		//do this once as it is heavy
		Object doc = Configuration.defaultConfiguration().jsonProvider().parse(resource);
		
		//now read and get the size of childnode 
		List<Integer> cSize = JsonPath.read(doc, "$..childnodes.length()");
		System.out.println("childnodes size: " + cSize.stream().findFirst().orElse(null));
		
		//read the title of child1234
		List<Map<String, String>> childNodes = ((List<Map<String, String>>)JsonPath.read(doc, "$.childnodes[*]"));
		
//		System.out.println(childNodes);
	
		childNodes
			.stream().forEach(x -> x.entrySet().stream().forEach(y -> System.out.println(y.getKey())));
		
		
		
		System.out.println();
	}
}
