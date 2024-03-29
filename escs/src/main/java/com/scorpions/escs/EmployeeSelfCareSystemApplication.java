package com.scorpions.escs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = "com.scorpions")
@EnableAutoConfiguration
@EntityScan( basePackages = {"com.scorpions.entities"} )
@EnableTransactionManagement
public class EmployeeSelfCareSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSelfCareSystemApplication.class, args);
	}

}
