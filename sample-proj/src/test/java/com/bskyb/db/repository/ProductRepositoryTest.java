package com.bskyb.db.repository;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bskyb.db.config.ApplicationConfig;
import com.bskyb.db.entity.two.Product;
import com.bskyb.db.entity.two.Text;
import com.github.javafaker.Faker;

@ActiveProfiles("unit-test")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback
@ContextConfiguration(classes = { ApplicationConfig.class })
@WebAppConfiguration
public class ProductRepositoryTest {

	public static final Faker fake = Faker.instance();

    @PersistenceContext
    protected EntityManager entityManager;
    
	@Autowired
	ProductRepository productRepository;

	@Before
	public void init() throws Exception {
		Product p = new Product();
		p.setCode("code");
		p.setName("name");
		
		Text text = new Text();
		text.setDesc_("desc");
		text.setName("textname");
		
		p.setElements(Arrays.asList(text));
		
		Product merge = entityManager.merge(p);
		
		System.out.println(merge);
	}
	
	@Test
	public void getAllProducts() throws Exception {
		System.out.println("done");
	}
}
