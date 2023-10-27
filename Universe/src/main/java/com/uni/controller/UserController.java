package com.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class UserController {
	@RequestMapping("user")
	public String user() {
		
		return "home/user/user";
	}
}