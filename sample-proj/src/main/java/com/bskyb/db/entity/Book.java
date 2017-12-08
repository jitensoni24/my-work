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
@Table(name = "book")
public class Book extends Publication {

	private Integer pages;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "publicationbook", 
		joinColumns = { 
			@JoinColumn(name = "bookid", referencedColumnName = "id") 
		},
		inverseJoinColumns = { 
			@JoinColumn(name = "authorid", referencedColumnName = "id")
		}
	)
	private Set<Author> authors = new HashSet<>();
	
	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

}
