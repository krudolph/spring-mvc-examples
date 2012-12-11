package de.kimrudolph.tutorials.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {

        // Initialize spring application context
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();

        // Define where to scan for needed components
        root.scan("de.kimrudolph.tutorials");

        // Lifecycle management of the root application context
        sc.addListener(new ContextLoaderListener(root));

        // Handles requests into the application
        ServletRegistration.Dynamic appServlet = sc.addServlet("appServlet",
            new DispatcherServlet(new GenericWebApplicationContext()));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");
    }
}