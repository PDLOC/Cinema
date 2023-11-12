package com.uni;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@SpringBootApplication
public class UniverseApplication {
	
	@GetMapping("/")
	public String home() {
		return "redirect:/home/index";
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(UniverseApplication.class, args);
	}

}
