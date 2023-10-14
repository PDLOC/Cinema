package com.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {
	@RequestMapping("index")
	public String home() {

		return "home/view.html";
	}
	
	@RequestMapping("detail")
	public String detail() {
		
		return "home/detail/detail.html";
	}
	@RequestMapping("contact")
	public String contact() {
		
		return "home/contact/contact.html";
	}
}
