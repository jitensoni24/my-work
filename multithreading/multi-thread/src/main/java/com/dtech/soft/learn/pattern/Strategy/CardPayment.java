package com.dtech.soft.learn.pattern.Strategy;

@SuppressWarnings("unused")
public class CardPayment implements PaymentStrategy {

	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;

	public CardPayment(String nm, String ccNum, String cvv, String expiryDate) {
		this.name = nm;
		this.cardNumber = ccNum;
		this.cvv = cvv;
		this.dateOfExpiry = expiryDate;
	}

	public void pay(Integer amount) {
		System.out.println(amount + " paid with credit/debit card");
	}
}
