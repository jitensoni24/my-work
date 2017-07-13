package com.dtech.mock.blueprint;

import java.util.List;

import com.dtech.mock.model.Car;
import com.dtech.mock.model.Driver;
import com.tobedevoured.modelcitizen.annotation.Blueprint;
import com.tobedevoured.modelcitizen.annotation.Default;
import com.tobedevoured.modelcitizen.annotation.MappedList;

@Blueprint(Car.class)
public class CarBlueprint {

	@Default
	String make = "BMW";
	
	@Default
	String model = "5 Series";
	
	@Default
	Integer year;
	
	@MappedList(size = 2, target=Driver.class, ignoreEmpty = true)
	List<Driver> drivers;
}
