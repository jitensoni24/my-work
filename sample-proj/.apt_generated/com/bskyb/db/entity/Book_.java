package com.bskyb.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ extends com.bskyb.db.entity.Publication_ {

	public static volatile SingularAttribute<Book, Integer> pages;
	public static volatile SetAttribute<Book, Author> authors;

}

