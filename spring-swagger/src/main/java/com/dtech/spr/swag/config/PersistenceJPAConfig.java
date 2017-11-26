package com.dtech.spr.swag.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PersistenceJPAConfig {

	 @Autowired
	    private Environment env;

	    @Autowired
	    private DataSource ds;

	    @Bean
	    public JdbcTemplate jdbcTemplate() {
	        return new JdbcTemplate(ds);
	    }

	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        Properties properties = new Properties();
	        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto", ""));
	        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
	        properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show.sql", "false"));
	        properties.setProperty("hibernate.format_sql", env.getProperty("hibernate.format.sql", "false"));
	        properties.setProperty("hibernate.id.new_generator_mappings", "false");

	        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	        emf.setDataSource(ds);
	        emf.setPackagesToScan(env.getProperty("entity.packages.to.scan"));
	        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	        emf.setJpaProperties(properties);

	        return emf;
	    }

	    @Bean
	    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
	        JpaTransactionManager jtm = new JpaTransactionManager();
	        jtm.setEntityManagerFactory(emf);

	        return jtm;
	    }

	    @Bean
	    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	        return new PersistenceExceptionTranslationPostProcessor();
	    }

	    @Bean
	    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	        return new PropertySourcesPlaceholderConfigurer();
	    }
	
}