package com.bskyb.db.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends Person {

	private Long salary;

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
}
