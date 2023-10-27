package com.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class ShowTController {
	@RequestMapping("show")
	public String show() {
		
		return "home/daytime/show";
	}
}
