package com.hescha.barbershop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations(
        		"classpath:/static/css/");
        registry.addResourceHandler("/img/**").addResourceLocations(
        		"classpath:/static/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath" +
				":/static/js/");
        registry.addResourceHandler("/**").addResourceLocations("classpath" +
				":/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registration").setViewName("registration");
    }
}