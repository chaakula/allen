package com.upwork.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring boot initializer
 * @author Chandra Sekhar Babu A
 *
 */
@SpringBootApplication
@ComponentScan("com.upwork")
@EnableAutoConfiguration
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
		System.out.println("Application started........");
	}
}
