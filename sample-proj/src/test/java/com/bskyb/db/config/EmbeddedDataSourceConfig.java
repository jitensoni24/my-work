package com.bskyb.db.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.bskyb.db.environment.UnitTest;

@UnitTest
@Configuration
public class EmbeddedDataSourceConfig {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
			.setType(EmbeddedDatabaseType.HSQL)
			/*.addScripts("classpath:/env/unit-test/test-schema.sql")
			.addScripts("classpath:/env/unit-test/test-data.sql")*/
			.build();
	}

}
