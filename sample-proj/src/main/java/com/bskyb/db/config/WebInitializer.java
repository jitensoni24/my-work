package com.bskyb.db.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/*
 * Replaces web.xml 
 * Registers servlet and filters
 * 
 */
public class WebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//Step 1 : 
		/* 
		 * create application context, this can be xml based web app context (reading beans from xml file) 
		 * or annotation based web app context (reading beans from @configurations @component files)
		 */
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		/* Not workin???
		 * context.setConfigLocation("com.bskyb.db");
		 * servletContext.addListener(new ContextLoaderListener());
		*/
		context.register(ApplicationConfig.class);
		context.setServletContext(servletContext);
		
		System.out.println(context.getEnvironment());
		
		
		//Step 2 : creating and registering our dispatcher servlet
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
