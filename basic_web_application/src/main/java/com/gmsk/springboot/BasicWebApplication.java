package com.gmsk.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@EntityScan("com.gmsk.model.Book")
@SpringBootApplication
public class BasicWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicWebApplication.class, args);
		System.out.println("Spring boot application started...");
	}

}
