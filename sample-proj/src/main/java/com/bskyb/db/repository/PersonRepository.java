package com.bskyb.db.repository;

import com.bskyb.db.entity.Person;

@org.springframework.stereotype.Repository
public class PersonRepository extends Repository<Person>{

	PersonRepository() {
		super(Person.class);
	}

}
