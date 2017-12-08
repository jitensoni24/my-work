package com.bskyb.db.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "blog")
public class Blog extends Publication {

	private String url;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "publicationblog", 
		joinColumns = { 
			@JoinColumn(name = "blogid", referencedColumnName = "id") 
		},
		inverseJoinColumns = { 
			@JoinColumn(name = "authorid", referencedColumnName = "id")
		}
	)
	private Set<Author> authors = new HashSet<>();

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
}
