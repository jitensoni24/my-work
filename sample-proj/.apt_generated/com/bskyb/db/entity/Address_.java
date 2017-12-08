package com.bskyb.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_ extends com.bskyb.db.entity.Identity_ {

	public static volatile SingularAttribute<Address, String> city;
	public static volatile SingularAttribute<Address, Person> person;
	public static volatile SingularAttribute<Address, Integer> doorNo;

}

