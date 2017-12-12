package com.bskyb.db.entity.two;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "element_text")
public class Text extends Element {

	private String desc_;

	public String getDesc_() {
		return desc_;
	}

	public void setDesc_(String desc_) {
		this.desc_ = desc_;
	}
	
}
