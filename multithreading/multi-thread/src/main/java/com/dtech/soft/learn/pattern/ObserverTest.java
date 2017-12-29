package com.dtech.soft.learn.pattern;

import java.util.Scanner;

import com.dtech.soft.learn.pattern.observer.KeyListner;
import com.dtech.soft.learn.pattern.observer.NewsKeyPress;
import com.dtech.soft.learn.pattern.observer.SportsKeyPress;

public class ObserverTest {

	public static void main(String[] args) {

		KeyListner listner = null;
		Scanner sc = new Scanner(System.in);
		String input = sc.next();

		while (sc.hasNext() && !(input.equals("exit") || input.equals("end"))) {
			if (input.equals("sports")) {
				listner = new SportsKeyPress();
				listner.listenKeyPress();
			} else if (input.equals("news")) {
				listner = new NewsKeyPress();
				listner.listenKeyPress();
			} else {
				System.out.println("unknown input : " + input);
			}
			input = sc.next();
		}
		sc.close();
	}
}
