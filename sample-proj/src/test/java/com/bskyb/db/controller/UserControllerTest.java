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

import com.bskyb.db.builder.UserBuilder;
import com.bskyb.db.entity.User;
import com.bskyb.db.exception.UserExistsException;
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
		UserResource user1 = UserBuilder.aUser().id(fake.number().numberBetween(1, 1000)).name(fake.name().name()).age(fake.number().numberBetween(1, 99)).build();
		UserResource user2 = UserBuilder.aUser().id(fake.number().numberBetween(1, 1000)).name(fake.name().name()).age(fake.number().numberBetween(1, 99)).build();

		when(userService.getAll()).thenReturn(Arrays.asList(user1, user2));

		// when
		List<User> users = userController.getUsers();

		// then
		assertEquals(2, users.size());

		// verify
		verify(userService, times(1)).getUsers();
	}
	
	@Test
	public void shouldReturnUserWithGivenId() throws Exception {
		// given
		User expectedUser = UserBuilder.aUser().id(fake.number().numberBetween(1, 1000)).name(fake.name().name()).age(fake.number().numberBetween(1, 99)).build();
		when(userService.getUser(expectedUser.getId())).thenReturn(expectedUser);

		// when
		User result = userController.getUser(expectedUser.getId());

		// then
		assertNotNull(result);
		assertEquals(expectedUser.getId(), result.getId());
		assertEquals(expectedUser.getName(), result.getName());
		
		// verify
		verify(userService, times(1)).getUser(expectedUser.getId());
	}
	
	@Test
	public void shouldSaveNewUser() throws Exception {
		// given
		User expectedUser = UserBuilder.aUser().id(fake.number().numberBetween(1, 1000)).name(fake.name().name()).age(fake.number().numberBetween(1, 99)).build();
		when(userService.saveUser(expectedUser)).thenReturn(expectedUser);
		
		// when
		User result = userController.saveUser(expectedUser);
		
		// then
		assertNotNull(result);
		assertEquals(expectedUser.getId(), result.getId());
		assertEquals(expectedUser.getName(), result.getName());
		
		// verify
		verify(userService, times(1)).saveUser(expectedUser);
	}

	
	@Test(expected = UserExistsException.class)
	public void shouldThrowUserExistsException_1() throws Exception {
		// given
		User expectedUser = UserBuilder.aUser().id(fake.number().numberBetween(1, 1000)).name(fake.name().name()).age(fake.number().numberBetween(1, 99)).build();
		when(userService.saveUser(expectedUser)).thenThrow(new UserExistsException("User already exists"));
		
		// when
		userController.saveUser(expectedUser);
	}
	
	@Test
	public void shouldDeleteUser() throws Exception {
		// given
		Integer id = 1;
		
		// when
		userService.deleteUser(id);
		
		// verify
		verify(userService, times(1)).deleteUser(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
