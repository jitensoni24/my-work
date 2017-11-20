package com.bskyb.db.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bskyb.db.builder.UserResourceBuilder;
import com.bskyb.db.resources.UserResource;
import com.bskyb.db.service.UserService;
import com.github.javafaker.Faker;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@Mock
	UserService userService;

	@InjectMocks
	UserController userController;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	public static final Faker fake = Faker.instance();

	@Test
	public void shouldReturnUsers() throws Exception {
		// given
    	List<String> roles = Arrays.asList(fake.lorem().word(), fake.lorem().word());
		
		UserResource user1 = UserResourceBuilder.userResource()
				.withUserName(fake.name().name()).withPassword(fake.internet().password())
				.withResourceRoles(roles).build();
		UserResource user2 = UserResourceBuilder.userResource()
				.withUserName(fake.name().name()).withPassword(fake.internet().password())
				.withResourceRoles(roles).build();

		when(userService.getAll()).thenReturn(Arrays.asList(user1, user2));

		// when
		List<UserResource> users = userController.getAll();

		// then
		assertEquals(2, users.size());

		// verify
		verify(userService, times(1)).getAll();
	}
	
	@Test
	public void shouldReturnUserWithGivenId() throws Exception {
		// given
		Long userId = 1L;
		UserResource expectedUser = UserResourceBuilder.userResource()
				.withUserName(fake.name().name()).withPassword(fake.internet().password())
				.withResourceRoles(Arrays.asList(fake.lorem().word())).build();
		
		when(userService.get(userId)).thenReturn(expectedUser);

		// when
		UserResource result = userController.get(userId);

		// then
		assertNotNull(result);
		assertEquals(expectedUser.getUsername(), result.getUsername());
		
		// verify
		verify(userService, times(1)).get(userId);
	}
	
	@Test
	public void shouldSaveNewUser() throws Exception {
		// given
		UserResource expectedUser = UserResourceBuilder.userResource()
				.withUserName(fake.name().name()).withPassword(fake.internet().password())
				.withResourceRoles(Arrays.asList(fake.lorem().word())).build();
		
		when(userService.create(expectedUser)).thenReturn(expectedUser);
		
		// when
		UserResource result = userController.create(expectedUser);
		
		// then
		assertNotNull(result);
		assertEquals(expectedUser.getUsername(), result.getUsername());
		
		// verify
		verify(userService, times(1)).create(expectedUser);
	}

	@Test
	public void shouldDeleteUser() throws Exception {
		// given
		Long userId = 1L;
		
		// when
		userService.delete(userId);
		
		// verify
		verify(userService, times(1)).delete(userId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
