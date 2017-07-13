package com.dtech.mock.model;


import java.util.List;

public class Car {

	private String make;
	
	private String model;
	
	private Integer year;
	
	private List<Driver> drivers;
	
	public Car() {}

	public Car(String make, String model, Integer year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}
}
