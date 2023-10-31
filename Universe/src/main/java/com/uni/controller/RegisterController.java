package com.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class RegisterController {
	@RequestMapping("register")
	public String register() {
		
		return "home/register_login/register";
	}
}
