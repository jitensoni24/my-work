package com.bskyb.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Blog.class)
public abstract class Blog_ extends com.bskyb.db.entity.Publication_ {

	public static volatile SingularAttribute<Blog, String> url;
	public static volatile SetAttribute<Blog, Author> authors;

}

