package com.bskyb.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Department.class)
public abstract class Department_ extends com.bskyb.db.entity.Identity_ {

	public static volatile ListAttribute<Department, Person> persons;
	public static volatile SingularAttribute<Department, String> name;

}

