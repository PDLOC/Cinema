package com.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class PromotionController {
	@RequestMapping("promotion")
	public String promotion() {
		
		return "home/promotion/promotion";
	}
}