package com.bskyb.db.repository;

import java.util.Arrays;

import com.bskyb.db.entity.two.Product;
import com.bskyb.db.entity.two.Text;

@org.springframework.stereotype.Repository
public class ProductRepository extends RepositoryTwo<Product>{

	public ProductRepository() {
		super(Product.class);
	}
	
	public Product init() throws Exception {
		Product p = new Product();
		p.setCode("code");
		p.setName("name");
		
		Text text = new Text();
		text.setDesc_("desc");
		text.setName("textname");
		
		p.setElements(Arrays.asList(text));
		
		Product merge = entityManager.merge(p);
		
		System.out.println(merge);
		
		return merge;
	}
}
