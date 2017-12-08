package com.bskyb.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address extends Identity {

	private Integer doorNo;
	
	private String city;
	
	@ManyToOne
    @JoinColumn(name = "p_id", referencedColumnName = "id")
	private Person person;

	public Integer getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(Integer doorNo) {
		this.doorNo = doorNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
