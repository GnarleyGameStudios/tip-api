package com.poketeam.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TipApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TipApplication.class, args);
		System.out.println("Database URL: " + System.getenv("SPRING_DATASOURCE_URL"));
	}
	
}
