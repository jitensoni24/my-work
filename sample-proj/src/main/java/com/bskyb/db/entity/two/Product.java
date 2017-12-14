package com.bskyb.db.entity.two;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends Identity {

	private String code;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumns(@JoinColumn(name = "product_id", referencedColumnName = "id"))
	/*@JoinTable ( name = "product_element",
			joinColumns = @JoinColumn(name = "p_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "element_id", referencedColumnName = "id")
	)*/
	private List<Element> elements;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", elements=" + elements + "]";
	}
	
}
