package com.scorpions.escs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com.scorpions")
public class EmployeeSelfCareSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSelfCareSystemApplication.class, args);
	}

}
