package com.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class PriceController {
	@RequestMapping("price")
	public String contact() {
		
		return "home/price/price";
	}
}
