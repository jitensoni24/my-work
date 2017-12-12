package com.bskyb.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bskyb.db.entity.two.Product;
import com.bskyb.db.service.ProductService;

@RestController
public class ProductController {

	@Autowired 
	ProductService productService;
	
	@RequestMapping(name = "/product/init")
	public Product init() throws Exception {
	
		return productService.init();
	}
}
