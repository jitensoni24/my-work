package com.bskyb.db.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverDataSourceConfig {

    /*@Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(env.getProperty("data.source.driver.class.name"));
        ds.setUrl(env.getProperty("data.source.url"));
        ds.setUsername(env.getProperty("data.source.username"));
        ds.setPassword(env.getProperty("data.source.password"));

        return ds;
    }*/

}
