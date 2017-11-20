package com.bskyb.db.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.bskyb.db.environment.All;
import com.bskyb.db.environment.Dev;
import com.bskyb.db.environment.Local;

@All
@Configuration
public class PropertiesConfig {

    @Configuration
    @Local
    @PropertySource(value = {
            "classpath:/env/application.properties",
            "classpath:/env/local/persistence.properties",
            "file:${file.environment.conf}" }, ignoreResourceNotFound = true)
    static class LocalProperties {}

    @Configuration
    @Dev
    @PropertySource(value = {
            "classpath:/env/application.properties",
            "classpath:/env/dev/persistence.properties",
            "file:${file.environment.conf}" }, ignoreResourceNotFound = true)
    static class DevProperties {}
}
