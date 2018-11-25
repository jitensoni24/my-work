package com.dtech.oop;

public class OOPPoly {

	//full behaviour - Greeting is passed and asked to perform
	public void greet(Greeting greeting) {
		greeting.perform();
	}
	
	public static void main(String[] args) {
		OOPPoly oop = new OOPPoly();
		
		oop.greet(new HelloGreeting());
	}
}
