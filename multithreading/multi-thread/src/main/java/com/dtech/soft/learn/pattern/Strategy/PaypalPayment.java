package com.dtech.soft.learn.pattern.Strategy;

@SuppressWarnings("unused")
public class PaypalPayment implements PaymentStrategy {

	private String emailId;
	private String password;

	public PaypalPayment(String email, String pwd) {
		this.emailId = email;
		this.password = pwd;
	}

	public void pay(Integer amount) {
		System.out.println(amount + " paid with paypal");
	}
}
