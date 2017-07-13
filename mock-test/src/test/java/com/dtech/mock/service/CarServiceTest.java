package com.dtech.mock.service;

import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.dtech.mock.BaseTest;
import com.dtech.mock.model.Car;
import com.dtech.mock.repository.CarRepository;

import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest extends BaseTest {

	@Mock
	CarRepository carRepository;
	
	@InjectMocks
	CarService carService;
	
	@Test
	public void testCars() throws Exception {
		
		List<Car> expected = Collections.singletonList(modelFactory.createModel(Car.class));
		
		//when
		when(carService.getAll()).thenReturn(expected);
		
		List<Car> result = carService.getAll();
		
		assertThat(expected, equalTo(result));
	}
	
}
