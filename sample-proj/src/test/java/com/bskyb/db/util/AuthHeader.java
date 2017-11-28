package com.bskyb.db.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;

public class AuthHeader {

	public static void main(String[] args) {
		String plainClientCredentials="myusername:mypassword";
		String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));
		 
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64ClientCredentials);
		
		System.out.println(headers);
	}
}
