package com.uni;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class UniverseApplication {
	
	@GetMapping("/message")
	public String message() {
		return "hello";
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(UniverseApplication.class, args);
	}

}
