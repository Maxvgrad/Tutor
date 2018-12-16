package ru.maxvgrad.tutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutorApplication {

	public static final String MODULE_BASE_URL = "/api/v3/tutor";

	public static void main(String[] args) {
		SpringApplication.run(TutorApplication.class, args);
	}

}

