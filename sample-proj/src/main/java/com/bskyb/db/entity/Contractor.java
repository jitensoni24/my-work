package com.bskyb.db.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contractor")
public class Contractor extends Person {

	private Long dailyWage;
	
	private String company;

	public Long getDailyWage() {
		return dailyWage;
	}

	public void setDailyWage(Long dailyWage) {
		this.dailyWage = dailyWage;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
}
