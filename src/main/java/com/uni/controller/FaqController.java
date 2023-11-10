package com.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class FaqController {
	@RequestMapping("faq")
	public String home() {

		return "home/faq/faq.html";
	}
}
