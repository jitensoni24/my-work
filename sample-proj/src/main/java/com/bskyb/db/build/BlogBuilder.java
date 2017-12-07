package com.bskyb.db.build;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bskyb.db.entity.Author;
import com.bskyb.db.entity.Blog;

public class BlogBuilder {

	private String title;
	
	private Integer version;
	
	private Set<Author> authors = new HashSet<>();
	
	private String url;
	
	private BlogBuilder() {}
	
	public static BlogBuilder blog() {
		return new BlogBuilder();
	}
	
	public BlogBuilder title(String value) {
		this.title = value;
		return this;
	}
	
	public BlogBuilder version(Integer value) {
		this.version = value;
		return this;
	}
	
	public BlogBuilder url(String value) {
		this.url = value;
		return this;
	}
	
	public BlogBuilder authors(List<Author> value) {
		Set<Author> authors = new HashSet<>(value);
		this.authors = authors;
		return this;
	}
	
	public Blog build() {
		Blog blog = new Blog();
		blog.setTitle(title);
		blog.setVersion(version);
		blog.setUrl(url);
		blog.setAuthors(authors);
		return blog;
	}
}
