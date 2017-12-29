package com.dtech.soft.learn.pattern;

import com.dtech.soft.learn.pattern.Strategy.CardPayment;
import com.dtech.soft.learn.pattern.Strategy.Item;
import com.dtech.soft.learn.pattern.Strategy.PaypalPayment;
import com.dtech.soft.learn.pattern.Strategy.ShoppingCart;

public class StrategyTest {
	
	public static void main(String[] args) {
		
		ShoppingCart cart = new ShoppingCart();
		
		Item item1 = new Item("item 1",10);
		Item item2 = new Item("item 2",40);
		
		cart.addItem(item1);
		cart.addItem(item2);
		
		cart.pay(new PaypalPayment("myemail@example.com", "mypwd"));
		
		cart.pay(new CardPayment("Jit", "1234567890123456", "786", "12/15"));
	}
}
