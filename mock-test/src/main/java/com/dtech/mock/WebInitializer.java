package com.dtech.mock;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ApplicationConfig.class);

        /*context.getEnvironment().setActiveProfiles(loadProperties(context).getProperty("env.name", "local"));*/
        
        context.setServletContext(servletContext);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1);
    }

    @SuppressWarnings("unused")
	private Properties loadProperties(AnnotationConfigWebApplicationContext ctx) throws ServletException {
        Properties properties = new Properties();
        String path = System.getProperty("file.environment.conf");

        if (path != null) {
            try (InputStream inputStream = ctx.getResource("file://" + path).getInputStream()) {
                properties.load(inputStream);
            } catch (IOException e) {
                throw new ServletException(e);
            }
        }

        return properties;
    }
    
}
