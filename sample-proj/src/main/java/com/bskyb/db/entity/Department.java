package com.bskyb.db.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "deparment")
public class Department extends Identity {

	private String name;
	
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private List<Person> persons;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + "]";
	}
}
