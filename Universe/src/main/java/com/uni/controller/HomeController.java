package com.uni.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("home")
public class HomeController {
	
	
	@RequestMapping("index")
	public String home(Model model) {
		return "redirect:film";
	}
	
	@RequestMapping("detail")
	public String detail() {
		String test = "test";
		return "home/detail/detail.html";
	}
	@RequestMapping("contact")
	public String contact() {
		
		return "home/contact/contact.html";
	}
}
