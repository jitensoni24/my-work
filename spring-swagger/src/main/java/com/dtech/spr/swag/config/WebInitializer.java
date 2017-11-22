package com.dtech.spr.swag.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.commons.io.IOUtils;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		//set the application context
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(SpringSwaggerApplication.class);
		
		String profile = loadProperties(context).getProperty("env.name", "local");

        ConfigurableEnvironment environment = context.getEnvironment();
        environment.setActiveProfiles(profile);
        
        context.setServletContext(servletContext);
		
		//set up the servlet
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		dispatcher.addMapping("/");
		dispatcher.setLoadOnStartup(1);
	}
	

    private Properties loadProperties(AnnotationConfigWebApplicationContext ctx) throws ServletException {
        String path = System.getProperty("file.environment.conf");

        Properties properties = new Properties();

        if (path != null) {
            InputStream inputStream = null;

            try {
                inputStream = ctx.getResource("file://" + path).getInputStream();

                properties.load(inputStream);
            } catch (IOException e) {
                throw new ServletException(e);
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        }

        return properties;
    }
}
