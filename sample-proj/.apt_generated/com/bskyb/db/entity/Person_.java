package com.bskyb.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Person.class)
public abstract class Person_ extends com.bskyb.db.entity.Identity_ {

	public static volatile ListAttribute<Person, Address> address;
	public static volatile SingularAttribute<Person, Sex> sex;
	public static volatile SingularAttribute<Person, String> name;
	public static volatile SingularAttribute<Person, Department> department;
	public static volatile SingularAttribute<Person, Integer> age;

}

