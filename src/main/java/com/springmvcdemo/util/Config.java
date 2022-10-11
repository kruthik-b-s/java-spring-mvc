package com.springmvcdemo.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.springmvcdemo")
public class Config {

	@Bean
	public EntityManagerFactory getEntityManagerFactory() {
		
		return Persistence.createEntityManagerFactory("springmvc");
		
	}
	
}
