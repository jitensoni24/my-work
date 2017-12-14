package com.bskyb.db.repository;

import java.util.Arrays;
import java.util.List;

import com.bskyb.db.entity.two.Carousel;
import com.bskyb.db.entity.two.Element;
import com.bskyb.db.entity.two.Product;
import com.bskyb.db.entity.two.Text;

@org.springframework.stereotype.Repository
public class ProductRepository extends RepositoryTwo<Product>{

	public ProductRepository() {
		super(Product.class);
	}
	
	public Product init() throws Exception {
		Product p = new Product();
		p.setCode("productcode");
		p.setName("productname");
		
		Text text = new Text();
		text.setDesc_("textdesc");
		text.setName("text");
		
		List<Element> textList = Arrays.asList(text);
		
		Carousel c = new Carousel();
		c.setName("carouselname");
		c.setElements(textList);
		entityManager.merge(c);
		
		p.setElements(textList);
		
		Product merge = entityManager.merge(p);

		System.out.println(merge);
		
		return merge;
	}
}
