package com.bskyb.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ extends com.bskyb.db.entity.Identity_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile ListAttribute<User, Address> address;
	public static volatile SetAttribute<User, UserRole> roles;
	public static volatile SingularAttribute<User, String> username;

}

