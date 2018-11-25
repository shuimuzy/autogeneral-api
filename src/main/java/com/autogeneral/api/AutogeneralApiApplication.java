package com.autogeneral.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * This is an entry point of the Spring Boot application.
 *
 * @author Simon Tian
 */

@SpringBootApplication
@EnableJpaAuditing
public class AutogeneralApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutogeneralApiApplication.class, args);
	}
}
