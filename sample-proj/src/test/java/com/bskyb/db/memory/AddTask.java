package com.bskyb.db.memory;

import com.bskyb.db.builder.UserBuilder;
import com.bskyb.db.entity.User;
import com.github.javafaker.Faker;

public class AddTask implements Runnable {
	
	public static final Faker fake = new Faker();

	StatusManager manager = new StatusManager();

	@Override
	public void run() {
		User user = null; 

		try {

			for(int i = 0; i < 20; i++) {
				long numberBetween = fake.number().numberBetween(1L, 10L);
				user = UserBuilder.user().withId(numberBetween).withUserName(fake.name().username()).withPassword(fake.internet().password()).buildUser();
				
				manager.addEntry(user.getId() + user.getUsername(), user);
				
				Thread.sleep(1000);
				
				System.out.println("map current size: " + manager.getAllStatusList().size() + "  users : " + manager.getAllStatusList().get(user.getId() + user.getUsername()).getUsername());

			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
