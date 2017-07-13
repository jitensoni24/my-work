package com.dtech.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtech.mock.model.Car;
import com.dtech.mock.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	CarRepository carRepository;
	
	public List<Car> getAll() {
		return carRepository.getAll();
	}
}
