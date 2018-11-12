package com.dtech.lambda;

interface Hello {
	void show();
}

interface HelloStranger {
	void sayHello(String stranger);
}

public class LambdaInterface {
	public static void main(String[] args) {
		Hello lambda_1 = () -> {
			System.out.println("hello");
		};
		
		//invoke the lambda
		lambda_1.show();
		
		
		HelloStranger strangerLambda = (String stranger) -> {
			System.out.println("Hello : " + stranger);
		};
		
		strangerLambda.sayHello("daniel fox");
	}
}
