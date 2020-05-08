package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan("com.org.model")
@ComponentScan("com.org.dao")
@ComponentScan("com.org.service")
@ComponentScan("com.org.controller")
public class FmsSpringBootBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsSpringBootBackendApplication.class, args);
	}
}
