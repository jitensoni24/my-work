package com.bskyb.db.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bskyb.db.entity.two.Product;
import com.bskyb.db.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Transactional
	public Product init() throws Exception {
		return productRepository.init();
	}
}
