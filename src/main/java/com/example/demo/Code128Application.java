package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Code128Application {

	public static void main(String[] args) {
		SpringApplication.run(Code128Application.class, args);
	}

}
