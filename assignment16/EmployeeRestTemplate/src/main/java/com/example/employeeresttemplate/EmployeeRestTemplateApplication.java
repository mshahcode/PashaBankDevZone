package com.example.employeeresttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@EnableFeignClients
public class EmployeeRestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestTemplateApplication.class, args);
	}

}
