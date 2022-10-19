package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
public class MircoprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircoprojectApplication.class, args);
	}

}
