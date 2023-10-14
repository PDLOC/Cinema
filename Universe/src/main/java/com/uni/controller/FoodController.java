package com.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class FoodController {
	@RequestMapping("food")
	public String seat() {
		
		return "home/food/food.html";
	}
}
