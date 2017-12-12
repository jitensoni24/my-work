package com.bskyb.db.entity.two;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "element_image")
public class Image extends Element {

	private String URL;

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}
	
}
