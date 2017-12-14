package com.bskyb.db.entity.two;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "element_carousel")
public class Carousel extends Element {

	@OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
    List<Element> elements;

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}
}
