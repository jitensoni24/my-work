package com.dtech.mock.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dtech.mock.model.Car;
import com.dtech.mock.model.Driver;

@Service
public class CarRepository {

	public List<Car> getAll() {
		List<Car> cars = new ArrayList<>();

		List<Driver> drivers = new ArrayList<>();
		drivers.add(new Driver("Raj", 30));

		Car car = new Car("BMW", "5 Series", 2015);
		car.setDrivers(drivers);

		cars.add(car);

		return cars;
	}

}
